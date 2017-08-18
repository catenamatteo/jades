package it.infn.gssi.radioactive;

import it.infn.gssi.simulator.Event;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class RadioactiveParticle extends Event {

	public RadioactiveParticle(Time time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Simulator simulator) {
		
        System.out.println("A particle disintigrated at t = "+time);
	}

}
