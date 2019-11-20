package experiment;

import algorithms.SortingAlgorithm;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
* Runs the the experiment developed for a Sorting algorithm.
*/
public class Experiment {

  String name;
  SortingAlgorithm sortingAlgorithm;
  ArrayGenerator arrayGenerator;
  int maxArraySize;
  int startIndex = 1;
  long[] randomTime;
  long[] sortedTime;
  long[] antiSortedTime;
  int repetitions;

  /**
  * Creates an experiment.
  *
  * @param name the name of the sorting algorithm.
  * @param sortingAlgorithm the sorting alorithm being used.
  * @param arrayGenerator used to generate the arrays being used in the experiment.
  * @param maxArraySize the maximum size of array for which the experiment shall go up to.
  * @param repetitions the number of reptitions.
  */
  public Experiment(String name, SortingAlgorithm sortingAlgorithm, ArrayGenerator arrayGenerator, int maxArraySize, int repetitions) {
    this.name = name;
    this.sortingAlgorithm = sortingAlgorithm;
    this.arrayGenerator = arrayGenerator;
    this.maxArraySize = maxArraySize;
    this.repetitions = repetitions;

    this.randomTime = new long[maxArraySize - startIndex + 1];
    this.sortedTime = new long[maxArraySize - startIndex + 1];
    this.antiSortedTime = new long[maxArraySize - startIndex + 1];

  }

  /**
  * Runs the experiment.
  */
  public void run() {

    for (int i = startIndex; i <= maxArraySize; i++) {
      containedExperiment(i);
    }
  }

  /**
  * runs the experiments on the three specified array types
  *
  * @param n the size of the array.
  */
  private void containedExperiment(int n) {
    //Since minimum size of array is 3
    sortedTime[n - startIndex] = execute(arrayGenerator.generateSortedIntArray(n));
    antiSortedTime[n - startIndex] = execute(arrayGenerator.generateAntiSortedIntArray(n));
    randomTime[n - startIndex] = execute(arrayGenerator.generateRandomIntArray(n));
  }

  /**
  * Find average time to sort particular array.
  *
  * @param array the array being sorted
  */
  private long execute(int[] array) {
    long average = 0;
    long minimum  = - 1;
    for (int i = 0; i < repetitions; i++) {
      long startTime = System.nanoTime();
      sortingAlgorithm.sort(array);
      long endTime = System.nanoTime();
      average += endTime - startTime;
      //finds the average of value and the average
      // if (i > 0) {
      //   average /= 2;
      // }
      if (minimum == - 1) {
        minimum = endTime - startTime;
      }
      else if (minimum > (endTime - startTime)) {
        minimum = endTime - startTime;
      }
    }
    return minimum;
  }

  /**
  * Gets the times took to sort the different array types.
  *
  * @return the time taken to sort the different array types.
  */
  public long[][] getSortedTime() {
    return new long[][] {sortedTime, randomTime, antiSortedTime};
  }

  /**
  * Gets the name of the sorting algorithm being tested.
  *
  * @return the name of the sorting algorithm.
  */
  public String getName() {
    return name;
  }
  /**
  * Determines where one time overtakes the other in termns of being faster.
  *
  * @param other another experiment of different sorting algorithm.
  * @return n the n values in which one experiment is faster than other.
  */
  public void overtake(Experiment other) {
    //For how many points in a row has one taken over other
    int overtaken = 0;
    //The location at which one takes over the other.
    int location = 0;
    //Gets the data generated from the other experiment.
    long[][] otherData = other.getSortedTime();
    int index = 0;
    while (overtaken <= 20 && index < sortedTime.length ) {
      if (sortedTime[index] < otherData[0][index]) {
        if (overtaken > 0) {
          overtaken++;
        }
        else {
          location = index;
          overtaken = 1;
        }
      }
      else {
        overtaken = 0;
      }
      index++;
    }
    //Minimum array Size is 3 is factored
    if (overtaken == 0) {
      System.out.println("Merge Sort does not overtake Selection Sort");
    }
    else {
      String result = name + " overtakes " + other.getName() + " when the array size is larger than " + (location + startIndex) + ".";
      System.out.println(result);
    }
  }
  /**
  * Closes the experiment and writes it to a file
  */
  public void close() {
    try{
      FileWriter writer = new FileWriter("results/" + name + ".csv");
      try (PrintWriter printWriter = new PrintWriter(writer)) {
        printWriter.write("Size of Array,Sorted Array Elapsed Time,Randomised Array Elapsed Time,Anti-Sorted Array Elapsed Time\n");
        for (int i = 0; i < maxArraySize; i++) {
          printWriter.write(i + 3 + "," + sortedTime[i] + "," + randomTime[i] + "," + antiSortedTime[i] + "\n");
        }
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
}
