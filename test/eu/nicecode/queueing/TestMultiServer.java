package it.infn.gssi.queueing;

import it.infn.gssi.simulator.Simulator;

public class TestMultiServer extends MultiServer {
	
	public int[] order;
	public long[] completions;
	
	private int cnt = 0;

	public TestMultiServer() {
		
		super(2);
		order = new int[4];
		completions = new long[4];
	}

	@Override
	public void afterRequestCompletion(Request request,
			Simulator simulator) {

		order[cnt]=((TestRequest) request).getId();
		completions[cnt]=simulator.now().getTimeMicroseconds(); //sort as in 'order'
		
		cnt++;
	}
	
	

}
