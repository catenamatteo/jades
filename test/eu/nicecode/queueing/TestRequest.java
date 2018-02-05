package eu.nicecode.queueing;

import eu.nicecode.queueing.Request;
import eu.nicecode.simulator.Time;

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
