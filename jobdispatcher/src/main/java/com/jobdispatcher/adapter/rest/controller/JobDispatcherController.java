package com.jobdispatcher.adapter.rest.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobdispatcher.adapter.rest.JobDispatcherRequestValidator;
import com.jobdispatcher.adapter.rest.domain.JobDispatcherRequest;
import com.jobdispatcher.domain.ErrorConstants;
import com.jobdispatcher.domain.WorkflowCommandMessage;
import com.jobdispatcher.exception.JobDispatcherException;
import com.jobdispatcher.exception.JobDispatcherServiceException;
import com.jobdispatcher.service.JobDispatcherService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Getter
@Setter
public class JobDispatcherController {

	private JobDispatcherService jobDispatcherService;
	private JobDispatcherRequestValidator jobDispatcherRequestValidator;
	
	public JobDispatcherController(JobDispatcherService jobDispatcherService, JobDispatcherRequestValidator jobDispatcherRequestValidator) {
		this.jobDispatcherService =jobDispatcherService;
		this.jobDispatcherRequestValidator = jobDispatcherRequestValidator;
	}
	
	@InitBinder("jobDispatcherRequest")
	public void setupBinder(WebDataBinder binder) {
		binder.addValidators(jobDispatcherRequestValidator);
	}
	
	@PostMapping(value ="/dispatch", consumes=MediaType.APPLICATION_JSON_VALUE ,produces = "application/json")
	public void dispatch(@Valid @RequestBody JobDispatcherRequest jobDispatcherRequest) throws JobDispatcherException{
		log.info("[guid:{}] Begining to dispatch", jobDispatcherRequest.getGuid());
		WorkflowCommandMessage message = new WorkflowCommandMessage();
		message.setGuid(jobDispatcherRequest.getGuid());
		message.setWorkflowCommandType(jobDispatcherRequest.getWorkflowCommandType());
		message.setWorkflowGoalId(jobDispatcherRequest.getWorkflowGoalId());
			
		try {
			jobDispatcherService.processWorkflowCommand(message);
		} catch (JobDispatcherServiceException e) {
			log.error("[guid:{}] JobDispatcherException due to {}", jobDispatcherRequest.getGuid(), e.getMessage());
			throw new JobDispatcherException(ErrorConstants.INVALID_OR_MISSING_FIELD_MSG);
		}
		
		log.info("[guid:{}] Completed job dispatch", jobDispatcherRequest.getGuid());
	}

}
