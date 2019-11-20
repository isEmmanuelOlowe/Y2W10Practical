package experiment;

import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

/**
* Used to generate integer arrays of a specifed type and length.
*/
public class ArrayGenerator {

  //stores the random integer generated for the integer length specified.
  private HashMap<Integer, int[]> randomIntArrays = new HashMap<Integer, int[]>();

  /**
  * Generates a sorted array with elements 0...n - 1
  *
  * @param n the length of the array.
  * @return sorted array.
  */
  public int[] generateSortedIntArray(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i ++) {
      array[i] = i;
    }
    return array;
  }

  /**
  * Generates an anti-sorted array with elements from n-1,..,0
  *
  * @param n the length of the array.
  * @return anti sorted array.
  */
  public int[] generateAntiSortedIntArray(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i ++) {
      array[i] = n - 1 - i;
    }
    return array;
  }

  /**
  * Generates a shuffled/random array with elements contained in set {0,..,n-1}
  *
  * @param n the length of the array.
  * @return a random array.
  */
  public int[] generateRandomIntArray(int n) {
    ArrayList<Integer> shuffle = new ArrayList<Integer>();
    if (randomIntArrays.containsKey(new Integer(n))) {
      //returns a clone since array will be re-used
      return randomIntArrays.get(new Integer(n)).clone();
    }
    for (int i = 0; i < n; i ++) {
       shuffle.add(new Integer(i));
    }
    //Randomising the Array into a random order
    Collections.shuffle(shuffle);

    //Shuffles the array and returns a array of primitives ints
    int[] array = shuffle.stream().mapToInt(Integer::intValue).toArray();
    randomIntArrays.put(new Integer(n), array);
    //returns a clone since array may be re-used
    return array.clone();
  }
}
