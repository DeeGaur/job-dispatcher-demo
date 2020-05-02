package com.jobdispatcher.adapter.rest.domain;

import org.springframework.stereotype.Component;

import com.jobdispatcher.domain.WorkflowCommandType;

@Component
public class JobDispatcherRequest {

	private String guid;
	private Long workflowGoalId;
	private WorkflowCommandType workflowCommandType;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Long getWorkflowGoalId() {
		return workflowGoalId;
	}
	public void setWorkflowGoalId(Long workflowGoalId) {
		this.workflowGoalId = workflowGoalId;
	}
	public WorkflowCommandType getWorkflowCommandType() {
		return workflowCommandType;
	}
	public void setWorkflowCommandType(WorkflowCommandType workflowCommandType) {
		this.workflowCommandType = workflowCommandType;
	}

	
}
