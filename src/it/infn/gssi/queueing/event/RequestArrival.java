package it.infn.gssi.queueing.event;

import it.infn.gssi.queueing.Request;
import it.infn.gssi.simulator.Agent;
import it.infn.gssi.simulator.ComplexEvent;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class RequestArrival extends ComplexEvent {

	protected Request request;
	
	public RequestArrival(Time time, Agent from, Agent to, Request request) {
		
		super(time, from, to);
		this.request = request;
	}

	@Override
	public void execute(Simulator simulator) {

		to.receiveRequest(request, from, simulator);
		//trigger next send
		from.sendRequest(from.nextRequest(), to, simulator);
	}

}
