package eu.nicecode.counter;

import java.util.concurrent.TimeUnit;

import eu.nicecode.simulator.Event;
import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

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
