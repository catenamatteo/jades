package it.infn.gssi.randomness;

public class Random {

	protected static java.util.Random random = new java.util.Random(System.currentTimeMillis());
	
	static public long exponential(double mean) {
		
		return (long) (- mean * Math.log(random.nextDouble()));
	}
	
}
