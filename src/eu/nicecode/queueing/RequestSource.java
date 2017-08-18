package it.infn.gssi.queueing;

import it.infn.gssi.queueing.event.RequestArrival;
import it.infn.gssi.simulator.Agent;
import it.infn.gssi.simulator.Simulator;

public abstract class RequestSource implements Agent {

	
	@Override
	public void receiveRequest(Request request, Agent from, Simulator simulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeRequest(Request request, Simulator simulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRequestCompletion(Request request, Simulator simulator) {
		// TODO Auto-generated method stub
		
	}

	public void sendRequest(Request request, Agent to, Simulator simulator) {

		if (request != null) {
			
			RequestArrival ra = new RequestArrival(request.getArrivalTime(), this, to, request);
			simulator.schedule(ra);
			
		}
		
	}

	public abstract Request nextRequest();
	
	
}
