package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import experiment.ArrayGenerator;
import algorithms.MergeSort;
import algorithms.SelectionSort;
import experiment.ArrayGenerator;

public class SortingTests {

    /**
    * Sorts an antisorted array using Selection Sort.
    */
    @Test
    public void selectionSortAntiSortedArray() {
      int size = 20;
      ArrayGenerator arrayGenerator = new ArrayGenerator();
      int[] a = arrayGenerator.generateAntiSortedIntArray(size);
      int[] b = arrayGenerator.generateSortedIntArray(size);
      SelectionSort selectionSort = new SelectionSort();
      selectionSort.sort(a);
      assertTrue(Arrays.equals(a, b));
    }

    /**
    * Sorts an random array using Selection Sort.
    */
    @Test
    public void selectionSortRandomArray() {
      int size = 20;
      ArrayGenerator arrayGenerator = new ArrayGenerator();
      int[] a = arrayGenerator.generateRandomIntArray(size);
      int[] b = arrayGenerator.generateSortedIntArray(size);
      SelectionSort selectionSort = new SelectionSort();
      selectionSort.sort(a);
      assertTrue(Arrays.equals(a, b));
    }

    /**
    * Sorts an antisorted array using Merge Sort.
    */
    @Test
    public void mergeSortAntiSortedArray() {
      int size = 20;
      ArrayGenerator arrayGenerator = new ArrayGenerator();
      int[] a = arrayGenerator.generateAntiSortedIntArray(size);
      int[] b = arrayGenerator.generateSortedIntArray(size);
      MergeSort mergeSort = new MergeSort();
      mergeSort.sort(a);
      assertTrue(Arrays.equals(a, b));
    }

    /**
    * Sorts an random array using Merge Sort.
    */
    @Test
    public void mergeSortRandomArray() {
      int size = 20;
      ArrayGenerator arrayGenerator = new ArrayGenerator();
      int[] a = arrayGenerator.generateRandomIntArray(size);
      int[] b = arrayGenerator.generateSortedIntArray(size);
      MergeSort mergeSort = new MergeSort();
      mergeSort.sort(a);
      assertTrue(Arrays.equals(a, b));
    }
}
