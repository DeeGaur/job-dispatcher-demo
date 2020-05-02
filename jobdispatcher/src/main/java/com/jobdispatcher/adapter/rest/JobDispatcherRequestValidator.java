package com.jobdispatcher.adapter.rest;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jobdispatcher.adapter.rest.domain.JobDispatcherRequest;
import com.jobdispatcher.domain.ErrorConstants;

@Component
public class JobDispatcherRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return JobDispatcherRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JobDispatcherRequest request = (JobDispatcherRequest) target;
		
		if(request.getGuid()==null || request.getGuid().isEmpty()) {
			errors.rejectValue("guid", ErrorConstants.INVALID_OR_MISSING_FIELD_MSG);	
		}

		if(request.getWorkflowGoalId()==null) {
			errors.rejectValue("workflowGoalId", ErrorConstants.INVALID_OR_MISSING_FIELD_MSG);	
		}
		
		if(request.getWorkflowCommandType()==null) {
			errors.rejectValue("workflowCommandType", ErrorConstants.INVALID_OR_MISSING_FIELD_MSG);	
		}
	}

}
