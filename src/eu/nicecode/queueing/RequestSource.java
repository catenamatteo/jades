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

import eu.nicecode.queueing.event.RequestArrival;
import eu.nicecode.simulator.Agent;
import eu.nicecode.simulator.Simulator;

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
