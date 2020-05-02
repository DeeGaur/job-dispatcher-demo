package com.jobdispatcher.adapter.rest.domain;

import org.springframework.stereotype.Component;

import com.jobdispatcher.domain.CommandStatus;
import com.jobdispatcher.domain.WorkflowCommandType;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class JobDispatcherResponse {

	private String guid;
	private Long workflowGoalId;
	private WorkflowCommandType workflowCommandType;
	private CommandStatus status;
	
}
