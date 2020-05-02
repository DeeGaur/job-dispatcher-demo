package com.jobdispatcher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jobdispatcher.domain.CommandStatus;
import com.jobdispatcher.domain.ErrorConstants;
import com.jobdispatcher.domain.WorkflowCommandMessage;
import com.jobdispatcher.exception.JobDispatcherAdapterException;
import com.jobdispatcher.exception.JobDispatcherServiceException;
import com.jobdispatcher.message.port.WorkflowCommandMessagePort;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JobDispatcherServiceImpl implements JobDispatcherService {

	Logger log = LoggerFactory.getLogger(JobDispatcherServiceImpl.class);
	private WorkflowCommandMessagePort workflowCommandMessagePort;

	public JobDispatcherServiceImpl(WorkflowCommandMessagePort workflowCommandMessagePort) {
		this.workflowCommandMessagePort = workflowCommandMessagePort;
	}
	@Override
	public void processWorkflowCommand(WorkflowCommandMessage message) throws JobDispatcherServiceException {
		
		try {
			message.setStatus(CommandStatus.DISPATCHED);
			log.info("[guid:{}] Status changed to {}", message.getGuid(), message.getStatus());	
			workflowCommandMessagePort.sendCommand(message);
			
		} catch (JobDispatcherAdapterException e) {
			log.error("[guid:{}] JobDispatcherServiceException due to {}", message.getGuid(), e.getMessage());
			throw new JobDispatcherServiceException(ErrorConstants.UNABLE_TO_SEND_CMD_MSG);
		}
	}


	public WorkflowCommandMessagePort getWorkflowCommandMessagePort() {
		return workflowCommandMessagePort;
	}
	public void setWorkflowCommandMessagePort(WorkflowCommandMessagePort workflowCommandMessagePort) {
		this.workflowCommandMessagePort = workflowCommandMessagePort;
	}
}
