package com.jsm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsm.dto.model.MemberModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
        /*MemberModel memberModel = new MemberModel();
        memberModel.setUserId(2000000000);
        memberModel.setUserName("Jo");
        memberModel.setUseYn("Y");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(memberModel));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }
}
