package it.infn.gssi.mmnqueue;

import java.util.concurrent.TimeUnit;

import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class MMNSimulator extends Simulator {

	public static void main(String[] args) {

		MMNSimulator sim = new MMNSimulator();

		MultiServerWithLog s = new MultiServerWithLog(4);
		RequestGenerator rq = new RequestGenerator(new Time(480, TimeUnit.MINUTES), new Time(10, TimeUnit.MINUTES),
				new Time(5, TimeUnit.MINUTES));
		rq.generate(sim, s);

		sim.doAllEvents();

	}

}
