package it.infn.gssi.queueing;

import it.infn.gssi.simulator.Simulator;

import org.junit.Assert;
import org.junit.Test;

public class TestSimulator extends Simulator {

	@Test
	public void test() {

		TestSimulator sim = new TestSimulator();
		
		TestMultiServer s = new TestMultiServer();
		DummyReqSource rq = new DummyReqSource();
		rq.sendRequest(rq.nextRequest(), s, sim);
		
		sim.doAllEvents();
		
		Assert.assertArrayEquals(rq.completions, s.completions);
		Assert.assertArrayEquals(rq.order, s.order);
	}

}
