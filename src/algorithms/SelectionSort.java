package algorithms;

/**
* implementation of selection sort algorithm.
*/
public class SelectionSort implements SortingAlgorithm {

  /**
  * Takes in an array and sorts the array.
  *
  * @param array the array object being sorted.
  */
  public void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      //find the minimum element and sets it to the i th index.
      for (int j = i; j < array.length; j++) {
        if (array[minIndex] > array[j]) {
          minIndex = j;
        }
      }
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
  }

}
