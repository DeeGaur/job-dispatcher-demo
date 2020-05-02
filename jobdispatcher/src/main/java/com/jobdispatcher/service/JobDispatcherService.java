package com.jobdispatcher.service;

import com.jobdispatcher.domain.WorkflowCommandMessage;
import com.jobdispatcher.exception.JobDispatcherServiceException;

public interface JobDispatcherService {

	public void processWorkflowCommand(WorkflowCommandMessage message) throws JobDispatcherServiceException;
}
