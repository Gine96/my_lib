package utils;

import java.util.Random;

//fonte:UniBSFpLib
public class NumeriCasuali {

	private static Random estrattore = new Random();

	/**
	 * @param min - valore minimo
	 * @param max - valore massimo
	 * @return numero intero casuale compreso fra <code>min</code> e <code>max</code>
	 * */
	public static int estraiIntero(int min, int max){
		int range = max + 1 - min;
		return estrattore.nextInt(range) + min;
	}

	/**
	 * @param min - valore minimo
	 * @param max - valore massimo
	 * @return numero double casuale compreso fra <code>min</code> e <code>max</code>
	 * */
	public static double estraiDouble(double min, double max){
		double range = max - min;
		return range*estrattore.nextDouble() + min;
	}

}
