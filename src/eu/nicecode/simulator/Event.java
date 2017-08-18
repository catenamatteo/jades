package it.infn.gssi.simulator;

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
