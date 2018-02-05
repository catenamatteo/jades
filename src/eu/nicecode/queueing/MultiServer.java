/*
 * Copyright 2016-2018 Matteo Catena
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.nicecode.queueing;

import java.util.LinkedList;
import java.util.Queue;

import eu.nicecode.queueing.event.RequestCompletion;
import eu.nicecode.queueing.event.RequestProcessing;
import eu.nicecode.simulator.Agent;
import eu.nicecode.simulator.Simulator;

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
