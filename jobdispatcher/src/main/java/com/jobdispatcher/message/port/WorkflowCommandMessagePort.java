package com.jobdispatcher.message.port;

import com.jobdispatcher.domain.WorkflowCommandMessage;
import com.jobdispatcher.exception.JobDispatcherAdapterException;

public interface WorkflowCommandMessagePort {

	public void sendCommand(WorkflowCommandMessage commandMessage) throws JobDispatcherAdapterException;
}
