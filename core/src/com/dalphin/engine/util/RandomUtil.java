/* Author: Hunter Barnard
 * 
 * This class contains utilities for random numbers. It improves upon Javas Math.Random function
 * for now. It will contain seed genoration and such for procedular genoration. 
 * 
 */

package com.dalphin.engine.util;

public class RandomUtil {

	/**
	 * 
	 * @return random
	 */
	public float randomFloat() {
		return (float) Math.random(); 
	}
	/**
	 * 
	 * @param min
	 * @param max
	 * @return random
	 */
	public float randomFloat(int min, int max) {
		return (float) ((Math.random() * (max - min)) + min);
	}

}
