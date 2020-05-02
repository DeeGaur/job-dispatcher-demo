package com.jobdispatcher.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorkflowCommandMessage implements Serializable, CommandMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String guid;
	private Long workflowGoalId;
	private WorkflowCommandType workflowCommandType;
	private CommandStatus status;
	
}
