package it.infn.gssi.mm1queue;

import java.util.concurrent.TimeUnit;

import it.infn.gssi.mmnqueue.RequestGenerator;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class MM1Simulator extends Simulator {

	public static void main(String[] args) {

		MM1Simulator sim = new MM1Simulator();
		
		SingleServerWithLog s = new SingleServerWithLog();
		//run for 8 hours, requests arrive every 10 mins and take 5 mins
		RequestGenerator rq = new RequestGenerator(new Time(480, TimeUnit.MINUTES), new Time(10, TimeUnit.MINUTES),
				new Time(5, TimeUnit.MINUTES));		
		rq.sendRequest(rq.nextRequest(), s, sim);
		
		sim.doAllEvents();
		
	}

}
