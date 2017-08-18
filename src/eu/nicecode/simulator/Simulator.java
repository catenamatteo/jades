package it.infn.gssi.simulator;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

import it.infn.gssi.simulator.exception.TimeException;

public class Simulator {

	protected PriorityQueue<Event> events;
	/**
	 * simulator time in microseconds
	 */
	protected Time time;
	
	public Simulator() {
		
		time = new Time(0, TimeUnit.MICROSECONDS);
		events = new PriorityQueue<Event>();
	}
	
	/**
	 * Get simulation time in micros
	 * @return
	 */
	public Time now() {
		
		return time;
	}
	
	public void doAllEvents() {
		
		Event e;
		while ((e = events.poll()) != null) {
			
			if (time.compareTo(e.time) <= 0)	{
				
				time.setTime(e.getTime());
			
			} else {
				
				throw new TimeException("You can't go back in time!");
				
			}
			
			e.execute(this);
		}
		
	}

	
	public void schedule(Event e) {
		
		events.add(e);
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
