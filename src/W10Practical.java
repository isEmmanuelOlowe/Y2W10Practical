import experiment.ArrayGenerator;
import experiment.Experiment;
import algorithms.SortingAlgorithm;
import algorithms.SelectionSort;
import algorithms.MergeSort;
import java.util.Arrays;

/**
* Experiment created to determined the performance of MergeSort in comparison to
*/
public class W10Practical {

  /**
  * Runs the program which generates the output of experiment
  */
  public static void main(String[] args) {
    //Will generate all the arrays used in the experiments
    ArrayGenerator arrayGenerator = new ArrayGenerator();
    //selectionSort algorithm implementation
    SortingAlgorithm selectionSort = new SelectionSort();
    //MergeSort algorithm implementation
    MergeSort mergeSort = new MergeSort();

    //Runs experiment until max array size of ...
    int arrayMaxSize = 500;
    //The number of repetitions of easy array size...
    int repetitions = 1000;
    Experiment selectionSortExperiment = new Experiment("Selection Sort", selectionSort, arrayGenerator, arrayMaxSize, repetitions);
    Experiment mergeSortExperiment = new Experiment("Merge Sort", mergeSort, arrayGenerator, arrayMaxSize, repetitions);

    System.out.println("Experiment in progress please wait...");
    //runs the experiment for Selection sort and outputs the data
    selectionSortExperiment.run();
    selectionSortExperiment.close();


    //runs the experiment for Merge sort and outputs the data
    mergeSortExperiment.run();
    mergeSortExperiment.close();

    //finds where Merge Sort overtakes selection sort
    //Since state Merge Sort has better time complex expect to overtake
    mergeSortExperiment.overtake(selectionSortExperiment);

    //All data has been outputted.
    System.out.println("Experiment Ended");
  }
}
