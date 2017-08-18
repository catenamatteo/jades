package it.infn.gssi.beep;

import it.infn.gssi.simulator.Event;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class Beep extends Event {

	public Beep(Time time) {
		
		super(time);
	}
	
	@Override
	public void execute(Simulator simulator) {

		System.out.println("the time is "+time);
	}

}
