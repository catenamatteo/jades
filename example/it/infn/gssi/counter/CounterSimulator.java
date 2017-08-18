package it.infn.gssi.counter;

import java.util.concurrent.TimeUnit;

import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class CounterSimulator extends Simulator {

	public static void main(String[] args) {
		
		new CounterSimulator().start();
	}

	private void start() {

		this.schedule(new Counter(new Time(0, TimeUnit.SECONDS)));
		this.doAllEvents();
	}
	
}
