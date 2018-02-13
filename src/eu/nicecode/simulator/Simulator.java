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

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import eu.nicecode.simulator.exception.TimeException;
import it.unimi.dsi.fastutil.PriorityQueue;
import it.unimi.dsi.fastutil.objects.ObjectHeapPriorityQueue;

public class Simulator {

	protected PriorityQueue<Event> events;
	/**
	 * simulator time in microseconds
	 */
	protected Time time;
	
	public Simulator() {
		
		time = new Time(0, TimeUnit.MICROSECONDS);
		events = new ObjectHeapPriorityQueue<>();
	}
	
	/**
	 * Get simulation time in micros
	 * @return
	 */
	public Time now() {
		
		return time;
	}
	
	public void doAllEvents() {
		
		try  {
			
			while (true) {
				
				Event e = events.dequeue();
				
				if (time.compareTo(e.getTime()) <= 0)	{
					
					time.setTime(e.getTime());
					
				} else {
					
					throw new TimeException("You can't go back in time!");
					
				}
				
				e.execute(this);
			}
			
		} catch (NoSuchElementException nsee)  {
		
			//end
		}
		
	}

	
	public void schedule(Event e) {
		
		events.enqueue(e);
	}
	
	public void remove(Event e) {
		
		throw new UnsupportedOperationException();
	}
	
	public boolean hasNextEvents() {
		
		return events.isEmpty();
	}

	public boolean isDone() {

		return false;
	}
}
