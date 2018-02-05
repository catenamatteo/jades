package eu.nicecode.mmnqueue;

import java.util.concurrent.TimeUnit;

import eu.nicecode.queueing.Request;
import eu.nicecode.queueing.RequestSource;
import eu.nicecode.queueing.event.RequestArrival;
import eu.nicecode.randomness.Random;
import eu.nicecode.simulator.Agent;
import eu.nicecode.simulator.Simulator;
import eu.nicecode.simulator.Time;

public class RequestGenerator extends RequestSource {

	protected Time lastArrivalTime = new Time(0, TimeUnit.MICROSECONDS);
	
	protected Time arrivalMean;
	protected Time serviceMean;
	protected Time duration;
	
	protected MultiServerWithLog serverWithLog;
	
	public RequestGenerator(Time duration, Time arrivalMean, Time serviceMean) {
		
		this.arrivalMean = arrivalMean;
		this.serviceMean = serviceMean;
		this.duration = duration;
	}
	
	public void generate(Simulator simulator, Agent to) {
				
		Request req = nextRequest();
		
		RequestArrival ra = new RequestArrival(lastArrivalTime, this, to, req);
		simulator.schedule(ra);
	}

	@Override
	public Request nextRequest() {

		if (lastArrivalTime.compareTo(duration) > 0) return null; //stop after duration

		Time serviceTime = new Time(Random.exponential(serviceMean.getTimeMicroseconds()), TimeUnit.MICROSECONDS);
		Request req = new Request(lastArrivalTime.clone(), serviceTime);

		lastArrivalTime.addTime(Random.exponential(serviceMean.getTimeMicroseconds()), TimeUnit.MICROSECONDS);
		
		return req;
	}
	
}
