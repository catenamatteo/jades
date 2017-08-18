package it.infn.gssi.simulator;

import java.util.concurrent.TimeUnit;

class ImmutableTime extends Time {

	public ImmutableTime(long time, TimeUnit unit) {
		super(time, unit);
	}

	@Override
	public Time setTime(long time, TimeUnit unit) {
		
		throw new UnsupportedOperationException("You can't change this!");
	}

	@Override
	public Time setTime(Time time) {
		
		throw new UnsupportedOperationException("You can't change this!");

	}

	@Override
	public Time addTime(long i, TimeUnit unit) {
		throw new UnsupportedOperationException("You can't change this!");

	}

	@Override
	public Time addTime(Time i) {
		throw new UnsupportedOperationException("You can't change this!");

	}

	@Override
	public Time subTime(long i, TimeUnit unit) {
		throw new UnsupportedOperationException("You can't change this!");

	}

	@Override
	public Time subTime(Time i) {
		throw new UnsupportedOperationException("You can't change this!");

	}
	
	
	
}

public class Time implements Comparable<Time>{

	public static final Time ZERO = new ImmutableTime(0, TimeUnit.MICROSECONDS);
	public static final Time SECOND = new ImmutableTime(1, TimeUnit.SECONDS);
	public static final Time HOUR = new ImmutableTime(1, TimeUnit.HOURS);
	
	private long time;
	
	public Time(long time, TimeUnit unit) {
		
		this.time = unit.toMicros(time);

	}
	
	public Long getTimeMicroseconds() {
		
		return time;
	}
	
	public Time setTime(long time, TimeUnit unit) {
		
		this.time = unit.toMicros(time);
		return this;
	}
	
	public Time setTime(Time time) {
		
		this.time = time.getTimeMicroseconds();
		return this;
	}


	public Time addTime(long i, TimeUnit unit) {

		time += unit.toMicros(i);
		return this;
	}
	
	public Time addTime(Time i) {
		
		addTime(i.getTimeMicroseconds(), TimeUnit.MICROSECONDS);
		return this;
	}
	
	public int compareTo(Time o) {
		
		return getTimeMicroseconds().compareTo(o.getTimeMicroseconds()); 
	}
	
	public String toString() {
		
		return Long.toString(time);
	}

	public Time clone() {
		
		return new Time(time, TimeUnit.MICROSECONDS);
	}

	/**
	 * Subtract i unit of time from this obj. Result will never be negative
	 * @param i
	 * @param unit
	 * @return
	 */
	public Time subTime(long i, TimeUnit unit) {

		long l = unit.toMicros(i);
		if (l > time) {
			
			time = 0;
		} else {	
			
			time -= unit.toMicros(i);
		}
		return this;
	}

	/**
	 * Subtract i time from this. Result will never be negative
	 * @param i
	 * @return
	 */
	public Time subTime(Time i) {
		
		return subTime(i.getTimeMicroseconds(), TimeUnit.MICROSECONDS);
	}

	
	
}
