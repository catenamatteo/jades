package it.infn.gssi.counter;

import java.util.concurrent.TimeUnit;

import it.infn.gssi.simulator.Event;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class Counter extends Event {

	private Time end = new Time(10, TimeUnit.SECONDS);
	
	public Counter(Time time) {

		super(time);
	}

	@Override
	public void execute(Simulator simulator) {
		System.out.println("the time is "+time);
		if (time.compareTo(end) < 0) {
			
			time.addTime(2, TimeUnit.SECONDS);
			simulator.schedule(this);
		}
	}

}
