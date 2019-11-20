package algorithms;

/**
* Implements Merge Sort Algorithm.
*/
public class MergeSort implements SortingAlgorithm {

  /**
  * Sorts the array.
  *
  * @param array the array being sorted.
  */
  public void sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  /**
  * The recursive merge sort function.
  *
  * @param array the array being sorted.
  * @param the first index of range being sorted.
  * @param end the last index of range being sorted.
  */
  private void mergeSort(int[] array, int start, int end) {
    if (start < end) {
      //Gets the middle point of the array.
      int middle = (start + end) / 2;

      //runs the merge sort algorithm on the two halves of the array.
      mergeSort(array, start, middle);
      mergeSort(array, middle + 1, end);
      //merges the two halves
      merge(array, start, middle, end);

    }
  }

  /**
  * Merges the Two halves of the array into sorted section.
  *
  * @param array the array being sorted
  * @param start the first index being sorted
  */
  private void merge(int[] array, int start, int middle, int end) {
    //Spilts the array
    int[] left = new int[middle - start + 1];
    int[] right = new int[end - middle];

    //fills the left array
    for (int i = 0; i < left.length; i++) {
      left[i] = array[start + i];
    }

    //fills the right array
    for (int i = 0; i < right.length; i++) {
      right[i] = array[middle + 1 + i];
    }
    //initialise the indexes
    int rIndex = 0;
    int lIndex = 0;
    int current = start;

    while (rIndex < right.length && lIndex < left.length) {
      //Checks if the left array elements are less than or equal to rights rights.
      if (left[lIndex] <= right[rIndex]) {
        array[current] = left[lIndex++];
      }
      else {
        array[current] = right[rIndex];
        rIndex++;
      }
      current++;
    }

    //Checks if there are still elements left in the left array.
    while (lIndex < left.length) {
      array[current++] = left[lIndex++];
    }

    //Checks if there are still elements left in the right array.
    while (rIndex < right.length) {
      array[current++] = right[rIndex++];
    }
  }
}
