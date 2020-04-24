package com.jsm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Configuration
public class VaultConfiguration {
    private Logger logger = LoggerFactory.getLogger(VaultConfiguration.class);
    public enum VAULT_ENVIRONMENT_KEY {
        TOKEN("VAULT_TOKEN"),
        ENDPOINT("VAULT_ENDPOINT"),
        PATH_DATABASE_INFO("VAULT_PATH_DATABASE_INFO"),
        ;
        private final String value;
        VAULT_ENVIRONMENT_KEY(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }
    public enum VAULT_KEY {
        URL("url"),
        USERNAME("username"),
        PASSWORD("password"),
        ;
        private final String value;
        VAULT_KEY(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }
    public enum SPRING_DATABASE_PROPERTY_KEY {
        URL("spring.datasource.url"),
        USERNAME("spring.datasource.username"),
        PASSWORD("spring.datasource.password"),
        ;
        private final String value;
        SPRING_DATABASE_PROPERTY_KEY(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }

    public VaultConfiguration(Environment environment) throws URISyntaxException {
        logger.debug("creator");
//        logger.info("application arguments -> {}, length -> {}", applicationArguments, applicationArguments.getSourceArgs().length);
//        Arrays.stream(applicationArguments.getSourceArgs()).forEach(argument -> logger.info("application argument -> {}", argument));
        System.getenv().entrySet().stream().forEach(entry -> logger.info("system enviroment -> {}, {}", entry.getKey(), entry.getValue()));

        //reason why using Optional.of is..
        //if application arguments associated with vault are not exist, NullPointerException occur.
        Optional<String> vaultToken = Optional.of(System.getenv(VAULT_ENVIRONMENT_KEY.TOKEN.value()));
        Optional<String> vaultEndpoint = Optional.of(System.getenv(VAULT_ENVIRONMENT_KEY.ENDPOINT.value()));
        Optional<String> vaultPathDatabaseInfo = Optional.of(System.getenv(VAULT_ENVIRONMENT_KEY.PATH_DATABASE_INFO.value()));
        logger.debug("property {} -> {}", VAULT_ENVIRONMENT_KEY.TOKEN.toString(), vaultToken.get());
        logger.debug("property {} -> {}", VAULT_ENVIRONMENT_KEY.ENDPOINT.toString(), vaultEndpoint.get());

        VaultTemplate vaultTemplate = new VaultTemplate(VaultEndpoint.from(new URI(vaultEndpoint.get())), new TokenAuthentication(vaultToken.get()));
        Optional<VaultResponse> vaultResponse = Optional.of(vaultTemplate.read(vaultPathDatabaseInfo.get()));
        logger.debug("vault read -> {}", vaultResponse.get().getData());
        setSystemPropertyFromVaultDataByKey(SPRING_DATABASE_PROPERTY_KEY.URL, vaultResponse, VAULT_KEY.URL);
        setSystemPropertyFromVaultDataByKey(SPRING_DATABASE_PROPERTY_KEY.USERNAME, vaultResponse, VAULT_KEY.USERNAME);
        setSystemPropertyFromVaultDataByKey(SPRING_DATABASE_PROPERTY_KEY.PASSWORD, vaultResponse, VAULT_KEY.PASSWORD);

    }

//    @PostConstruct
//    public void init() throws URISyntaxException {
//        logger.debug("init");
//    }

    private void setSystemPropertyFromVaultDataByKey(SPRING_DATABASE_PROPERTY_KEY springDatabasePropertyKey, Optional<VaultResponse> vaultResponse, VAULT_KEY vaultKey) {
        System.setProperty(springDatabasePropertyKey.value(), String.valueOf(vaultResponse.get().getData().get(vaultKey.value())));
    }
}