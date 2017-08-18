package it.infn.gssi.radioactive;

import java.util.concurrent.TimeUnit;

import it.infn.gssi.randomness.Random;
import it.infn.gssi.simulator.Simulator;
import it.infn.gssi.simulator.Time;

public class ParticleSimulator extends Simulator {

	public static void main(String[] args) {

		new ParticleSimulator().start();
	}
	
	private void start() {
	    
		/* Create 5 particle, each with a mean lifespan of 4 time units */
        double time = Random.exponential(4.0);
        Math.floor(time);
		schedule( new RadioactiveParticle(new Time(Random.exponential(4.0), TimeUnit.SECONDS) ));
		schedule( new RadioactiveParticle(new Time(Random.exponential(4.0), TimeUnit.SECONDS) ));
		schedule( new RadioactiveParticle(new Time(Random.exponential(4.0), TimeUnit.SECONDS) ));
		schedule( new RadioactiveParticle(new Time(Random.exponential(4.0), TimeUnit.SECONDS) ));
		schedule( new RadioactiveParticle(new Time(Random.exponential(4.0), TimeUnit.SECONDS) ));

        doAllEvents();
	}
	
	

}
