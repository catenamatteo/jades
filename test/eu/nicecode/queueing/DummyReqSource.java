package eu.nicecode.queueing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import eu.nicecode.queueing.RequestSource;
import eu.nicecode.simulator.Time;

public class DummyReqSource extends RequestSource {

	private List<TestRequest> reqs;
	private Iterator<TestRequest> iterator;
	
	public int[] order;
	public long[] completions;
	
	public DummyReqSource() {
		
		reqs = new ArrayList<TestRequest>(); 
		reqs.add(new TestRequest(1, new Time(0, TimeUnit.MICROSECONDS), new Time(20, TimeUnit.MICROSECONDS)));
		reqs.add(new TestRequest(2, new Time(5, TimeUnit.MICROSECONDS), new Time(10, TimeUnit.MICROSECONDS)));
		reqs.add(new TestRequest(3, new Time(7, TimeUnit.MICROSECONDS), new Time(2, TimeUnit.MICROSECONDS)));
		reqs.add(new TestRequest(4, new Time(22, TimeUnit.MICROSECONDS), new Time(10, TimeUnit.MICROSECONDS)));
		
		order = new int[]{2,3,1,4};
		completions = new long[]{15,17,20,32}; //sorted as in 'order'
		
		iterator = reqs.iterator();
	}
	
	@Override
	public TestRequest nextRequest() {
		
		try {
			
			return iterator.next();			
			
		} catch (NoSuchElementException nsee) {
			
			return null;
		}
	}

}
