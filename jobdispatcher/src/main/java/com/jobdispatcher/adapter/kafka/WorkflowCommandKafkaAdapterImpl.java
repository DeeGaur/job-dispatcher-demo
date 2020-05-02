package com.jobdispatcher.adapter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.jobdispatcher.domain.WorkflowCommandMessage;
import com.jobdispatcher.exception.JobDispatcherAdapterException;
import com.jobdispatcher.message.port.WorkflowCommandMessagePort;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the kafka Producer 
 * This class is going to publish messages on the kafka
 * @author Deepti Gaur
 *
 */
@Slf4j
@Component
public class WorkflowCommandKafkaAdapterImpl implements WorkflowCommandMessagePort{
	
	@Value("${topic}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, WorkflowCommandMessage> workflowCommandKafkaTemplate;
	
	@Override
	public void sendCommand(WorkflowCommandMessage workflowCommandMessage) throws JobDispatcherAdapterException{

		
		ListenableFuture<SendResult<String, WorkflowCommandMessage>> future = workflowCommandKafkaTemplate.send(topic, workflowCommandMessage.getGuid() ,workflowCommandMessage);
		future.addCallback(new ListenableFutureCallback<SendResult<String, WorkflowCommandMessage>>() {

			@Override
			public void onSuccess(SendResult<String, WorkflowCommandMessage> result) {
				log.info("[guid:{}] Successfully sent the command {} to topic:{}", result.getProducerRecord().key(), result.getProducerRecord().value().toString(),result.getProducerRecord().topic());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("[guid:{}] Unable to send command due to {}", workflowCommandMessage.getGuid(), ex.getMessage() );
			}
		});

	}

	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
