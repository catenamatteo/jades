package it.infn.gssi.simulator;

public abstract class ComplexEvent extends Event {

	protected Agent from;
	protected Agent to;
	
	public ComplexEvent(Time time, Agent from, Agent to) {
		super(time);
		this.from = from;
		this.to = to;
	}
}
