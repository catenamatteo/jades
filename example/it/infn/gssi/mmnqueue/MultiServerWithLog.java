package it.infn.gssi.mmnqueue;

import it.infn.gssi.queueing.MultiServer;
import it.infn.gssi.queueing.Request;
import it.infn.gssi.simulator.Simulator;

public class MultiServerWithLog extends MultiServer {

	public MultiServerWithLog(int numOfServers) {
		
		super(numOfServers);
	}

	public void completeRequest(Request request, Simulator simulator) {

		super.completeRequest(request, simulator);
		
		System.out.printf("Request %s arrived at time %s, processed at time %s and completed at time %d (service time %s)\n",
				request, 
				request.getArrivalTime(), 
				simulator.now(),
				simulator.now().getTimeMicroseconds()+request.getServiceTime().getTimeMicroseconds(), 
				request.getServiceTime()
			);
		System.out.printf("Free servers: %d/%d\n", availableServers+1, numOfServers);
	}

}
