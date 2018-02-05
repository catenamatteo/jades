package eu.nicecode.mm1queue;

import java.util.concurrent.TimeUnit;

import eu.nicecode.mmnqueue.RequestGenerator;
import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

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
