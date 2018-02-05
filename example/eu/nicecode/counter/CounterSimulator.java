package eu.nicecode.counter;

import java.util.concurrent.TimeUnit;

import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

public class CounterSimulator extends Simulator {

	public static void main(String[] args) {
		
		new CounterSimulator().start();
	}

	private void start() {

		this.schedule(new Counter(new Time(0, TimeUnit.SECONDS)));
		this.doAllEvents();
	}
	
}
