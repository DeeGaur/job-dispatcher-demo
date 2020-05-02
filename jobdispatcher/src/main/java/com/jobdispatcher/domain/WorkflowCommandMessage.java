package com.jobdispatcher.domain;

import java.io.Serializable;

public class WorkflowCommandMessage implements Serializable, CommandMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String guid;
	private Long workflowGoalId;
	private WorkflowCommandType workflowCommandType;
	private CommandStatus status;
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
	public CommandStatus getStatus() {
		return status;
	}
	public void setStatus(CommandStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "[guid="+this.guid+", workflowGoalId="+this.workflowGoalId+", type="+this.workflowCommandType+", status="+this.status+"]";
	}
}
