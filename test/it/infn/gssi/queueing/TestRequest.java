package it.infn.gssi.queueing;

import it.infn.gssi.simulator.Time;

public class TestRequest extends Request {

	protected int id;

	public int getId() {
		return id;
	}

	public TestRequest(int id, Time arrivalTime, Time serviceTime) {
		super(arrivalTime, serviceTime);
		this.id = id;
	}

}
