package com.jobdispatcher.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.jobdispatcher.domain.WorkflowCommandMessage;

@Configuration
@ConfigurationProperties
@EnableKafka
public class KafkaConfig {

	@Value("${bootstrapServers}")
	private String bootstrapServers;
	
	@Bean
	public Map<String, Object> producerConfig() {
		Map<String, Object> configProperties = new HashMap<>();
		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return configProperties; 
	}
	
	@Bean
	public KafkaTemplate<String, WorkflowCommandMessage> workflowCommandKafkaTemplate(){
		return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfig()));
	}
}
