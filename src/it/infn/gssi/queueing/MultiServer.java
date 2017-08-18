package it.infn.gssi.queueing;

import java.util.LinkedList;
import java.util.Queue;

import it.infn.gssi.queueing.event.RequestCompletion;
import it.infn.gssi.queueing.event.RequestProcessing;
import it.infn.gssi.simulator.Agent;
import it.infn.gssi.simulator.Simulator;

public class MultiServer implements Agent {

	protected Queue<Request> queue = new LinkedList<Request>();
	protected int numOfServers;
	protected int availableServers;
	
	public MultiServer(int numOfServers) {
		
		this.numOfServers = this.availableServers = numOfServers;
	}
	
	public void receiveRequest(Request request, Agent from, Simulator simulator) {

		if (queue.isEmpty() && availableServers > 0) {
			
			serveRequest(request, simulator);
			
		} else {
			
			queue.add(request);
		}
		
	}
	
	protected void serveRequest(Request request, Simulator simulator) {
		
		RequestProcessing rq = new RequestProcessing(simulator.now(), this, this, request);
		simulator.schedule(rq);
		availableServers = Math.max(0, availableServers - 1);
	}
	
	public void serveRequest(Simulator simulator) {
		
		if (!queue.isEmpty()) {
			
			Request request = queue.poll();
			serveRequest(request, simulator);
			
		} else {
			
			availableServers = Math.min(numOfServers, availableServers + 1);
		}
		
	}

	public void completeRequest(Request request, Simulator simulator) {

		RequestCompletion rc = new RequestCompletion(simulator.now().clone().addTime(request.getServiceTime()), this, this, request);
		simulator.schedule(rc);
		
	}

	public void afterRequestCompletion(Request request, Simulator simulator) {
		
	}

	@Override
	public Request nextRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendRequest(Request request, Agent to, Simulator simulator) {
		// TODO Auto-generated method stub
		
	}

	
}
