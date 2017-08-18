package it.infn.gssi.queueing;

import it.infn.gssi.simulator.Time;

public class Request {

	protected Time arrivalTime;
	protected Time serviceTime;
	
	public Request(Time arrivalTime, Time serviceTime) {
		
		super();
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	
	}
	
	public Time getArrivalTime() {
		return arrivalTime;
	}
	
	public Time getServiceTime() {
		return serviceTime;
	}
	
	
}
