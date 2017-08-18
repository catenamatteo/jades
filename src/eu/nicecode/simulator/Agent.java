package it.infn.gssi.simulator;

import it.infn.gssi.queueing.Request;

public interface Agent {

	public Request nextRequest();
	public void sendRequest(Request request, Agent to, Simulator simulator);
	public void receiveRequest(Request request, Agent from, Simulator simulator);
	public void completeRequest(Request request, Simulator simulator);
	public void afterRequestCompletion(Request request, Simulator simulator);
	
}
