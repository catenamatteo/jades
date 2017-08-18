package it.infn.gssi.queueing.event;

import it.infn.gssi.queueing.MultiServer;
import it.infn.gssi.queueing.Request;
import it.infn.gssi.simulator.Agent;
import it.infn.gssi.simulator.ComplexEvent;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class RequestProcessing extends ComplexEvent {

	protected Request request;

	public RequestProcessing(Time time, Agent from, Agent to, Request request) {
		super(time, from, to);
		this.request = request;
	}

	@Override
	public void execute(Simulator simulator) {

		((MultiServer) from).completeRequest(request, simulator);
	}
	
	

}
