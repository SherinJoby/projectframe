package Utilities;

import java.util.Random;

public class RandomGenerator {
	 public static int getRandomNumber(){
	        Random randomGenerator = new Random();
	        int low = 10;
	        int high = 29;
	        int randomInt = randomGenerator.nextInt(high-low)+ low;
	        System.out.println(randomInt);
	        return randomInt;
	       
	    }
 


}
