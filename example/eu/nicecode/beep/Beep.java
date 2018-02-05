package eu.nicecode.beep;

import eu.nicecode.simulator.Event;
import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

public class Beep extends Event {

	public Beep(Time time) {
		
		super(time);
	}
	
	@Override
	public void execute(Simulator simulator) {

		System.out.println("the time is "+time);
	}

}
