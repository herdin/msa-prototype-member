curl -X POST -H "Content-Type: application/json" -d "{'channel': '#alarm', 'text': '$SLACK_TEXT -> $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG' }" $SLACK_WEBHOOK_URL
