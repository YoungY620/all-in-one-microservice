VERSION := 0.0.1-SNAPSHOT
TARGET := target
SKYWALKING_AGENT_PATH := agent/skywalking-agent.jar
# ADD_AGENT_OPT := \
# 	# -javaagent:$(SKYWALKING_AGENT_PATH) 

build: build-consumer build-register build-config \
	build-gateway build-provider



ifdef SKYWALKING_AGENT_PATH
run-config: ./$(TARGET)/allinone-homework-$(VERSION).jar
	java \
	-javaagent:./$(SKYWALKING_AGENT_PATH) \
	-jar ./$(TARGET)/allinone-homework-$(VERSION).jar

run-register: ./eureka2/$(TARGET)/eureka2-$(VERSION).jar
	java \
	-javaagent:./eureka2/$(SKYWALKING_AGENT_PATH) \
	-jar ./eureka2/$(TARGET)/eureka2-$(VERSION).jar

run-provider: ./provider2/$(TARGET)/provider2-$(VERSION).jar
	java \
	-javaagent:./provider2/$(SKYWALKING_AGENT_PATH) \
	-jar ./provider2/$(TARGET)/provider2-$(VERSION).jar
	
run-consumer: ./consumer/$(TARGET)/feign-$(VERSION).jar
	java \
	-javaagent:./consumer/$(SKYWALKING_AGENT_PATH) \
	-jar ./consumer/$(TARGET)/feign-$(VERSION).jar
	
run-gateway: ./gateway/$(TARGET)/gateway-$(VERSION).jar
	java \
	-javaagent:./gateway/$(SKYWALKING_AGENT_PATH) \
	-jar ./gateway/$(TARGET)/gateway-$(VERSION).jar

else
run-config: ./$(TARGET)/allinone-homework-$(VERSION).jar
	java \
	-jar ./$(TARGET)/allinone-homework-$(VERSION).jar

run-register: ./eureka2/$(TARGET)/eureka2-$(VERSION).jar
	java \
	-jar ./eureka2/$(TARGET)/eureka2-$(VERSION).jar

run-provider: ./provider2/$(TARGET)/provider2-$(VERSION).jar
	java \
	-jar ./provider2/$(TARGET)/provider2-$(VERSION).jar
	
run-consumer: ./consumer/$(TARGET)/feign-$(VERSION).jar
	java \
	-jar ./consumer/$(TARGET)/feign-$(VERSION).jar
	
run-gateway: ./gateway/$(TARGET)/gateway-$(VERSION).jar
	java \
	-jar ./gateway/$(TARGET)/gateway-$(VERSION).jar
endif


build-consumer ./consumer/$(TARGET)/feign-$(VERSION).jar : 
	mvn clean package -f consumer -am -Dmaven.test.skip=true

build-register ./eureka2/$(TARGET)/eureka2-$(VERSION).jar: 
	mvn clean package -f eureka2 -am -Dmaven.test.skip=true

build-config ./$(TARGET)/allinone-homework-$(VERSION).jar: 
	mvn clean package -am -Dmaven.test.skip=true

build-gateway ./gateway/$(TARGET)/gateway-$(VERSION).jar : 
	mvn clean package -f gateway -am -Dmaven.test.skip=true

build-provider ./provider2/$(TARGET)/provider2-$(VERSION).jar : 
	mvn clean package -f provider2 -am -Dmaven.test.skip=true

clean-log:
	rm -f ./logs/*.log 

clean-target: 
	find ./ -type d -name "target" -exec rm -rf {} \;

clean: clean-log clean-target
