package eu.nicecode.beep;

import java.util.concurrent.TimeUnit;

import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

public class BeepSimulator extends Simulator {

	public static void main(String[] args) {
		
		new BeepSimulator().start();
	}

	private void start() {

		this.schedule(new Beep(new Time(4, TimeUnit.SECONDS)));
		this.schedule(new Beep(new Time(1, TimeUnit.SECONDS)));
		this.schedule(new Beep(new Time(2, TimeUnit.SECONDS)));
		this.schedule(new Beep(new Time(3, TimeUnit.SECONDS)));

		this.doAllEvents();
	}
	
}
