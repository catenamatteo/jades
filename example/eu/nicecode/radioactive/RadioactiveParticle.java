package eu.nicecode.radioactive;

import eu.nicecode.simulator.Event;
import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

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
