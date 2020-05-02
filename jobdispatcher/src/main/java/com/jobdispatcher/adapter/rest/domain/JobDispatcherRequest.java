package com.jobdispatcher.adapter.rest.domain;

import org.springframework.stereotype.Component;

import com.jobdispatcher.domain.WorkflowCommandType;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class JobDispatcherRequest {

	private String guid;
	private Long workflowGoalId;
	private WorkflowCommandType workflowCommandType;
}
