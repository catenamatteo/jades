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
package eu.nicecode.simulator;

public abstract class Event implements Comparable<Event> {

	/**
	 * event time in microseconds
	 */
	protected Time time;
	
	public Event(Time time) {
		
		this.time = time;
	}
	

	public int compareTo(Event o) {
		
		return time.compareTo(o.getTime());
		
	}
	
	public abstract void execute(Simulator simulator);

	public Time getTime() {
		return time;
	}
	
	
	
}
