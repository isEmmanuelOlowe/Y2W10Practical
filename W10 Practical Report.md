# W10 Practical Report

## Overview

The specification requires that performance of two sorting algorithms be compared, and determined how their speed changes with problem size. The algorithms being compared are Selection Sort and Merge Sort. It is stated Selection Sort is initially faster than Merge Sort but at some point they cross over and Merge Sort become faster than Selection Sort.

Essentially it is required that a experiment be produced where the time to sort an unsorted array.

### Selection Sort

The Selection Sort algorithm works by a lop runs $n$ times. Where $n$ is the length of the array and $i$ is the number iteration of the loop. In the $i$ th iteration, the minimum value in the range $ [i, n]$ of the array is determined using another loop (finding minimum algorithm) and then set to the value of $i$ index of the array. After these $n$ iterations the array will then be sorted.

#### Time Complexities

| Best Case     | Average Case  | Worst Case |
| ------------- | ------------- | ---------- |
| $\Omega(n^2)$ | $\Theta(n^2)$ | $O(n^2)$   |

### Merge Sort

The Merge Sort algorithm is a divide and conquer which repeatedly divides the array in half until array of size 1.  This is recursive and separates the array into a left and right split by the middle until base case is reached. Then the merge function compares elements of left and right. Insert the smallest item between the left and right in the array from the start of section to end until one of left and right array is empty.  Then adds the remaining items of the other which is not empty. This happens recursively until the whole area is sorted. 

#### Time Complexities

| Best Case          | Average Case       | Worst Case    |
| ------------------ | ------------------ | ------------- |
| $\Omega(n\log{n})$ | $\Theta(n\log{n})$ | $O(n\log{n})$ |

## Experiment Design

To ensure validity of experiments as may factors as possible must be held constant. To ensure this both algorithms.

Three times of data shall be tested into these sorting algorithms:

* array with elements: sorted
* array with integers: in random order
* array with elements: anti-sorted

It is expected these shall not make massive changes as difference number of comparisons, but to ensure that they don’t they shall be tested as well.

A class has been created to handle the generation of arrays. To ensure that the arrays generated e.g. are the same every time. The random arrays which are generated are stored so that when used on the other sorting algorithm or when finding average for a specific array length. So clone of the generated array will be returned so the random with identical ordering can be reused on different sorting algorithm.

It was determined in rudimentary testing of program when running the same test on a sorted array determining the elapsed time using `System.nanoTime()` would run different results. To ensure the accuracy of results. An average would be found from a number of repetitions specified. As times for small values were seen to wildly vary. The larger the number of repetitions the more accurate the result for that iteration. Even this too proved still to have large variations in results obtained. Even median would have same problem. This problem is the upper bound for the maximum time it can take to sort any array is infinity. So very large values would create massive spikes which would cause massive disruptions in the average and median pulling them closer to unusable values. To fix this problem the Lower bound of time taken was found instead and return more consistent and stable results.

The greater the number of repetitions used the slower the program shall run. So values used in final execution will be to keep the runtime less than 2 minutes so it can be evaluated by others. 

The Experiments shall generate CSV files of all the data generated. Since it is known that `System.nanoTime()` does not give consistent results. The focus shall be on extrapolating the general trends in the graphs.

To generate the graphs python; `pandas` and `matplotlib` shall be used. The python code used to generate the results can be found in the result folder.

Since `System.nanoTime()` sporadic nature as explained before to ensure that an overlap has definitely occurred. It is check the the following 20 values past one too have overlapped. Ensuring that over lap is not due to random spike in time taken.

## Testing

To ensure the proper functionality of the sorting algorithms. `JUnit` was used to ensure they work. To run the tests please run the command in terminal:

```bash
bash run.sh
```

## Evaluation of Results

## Conclusion

From repeated testing of program it was found the Merge Sort over takes Selection Sort for arrays regardless of how sorted they are in the range of array length from 250-300.

As could be seen from graphs. The type of array (e.g. sorted, random, anti-sorted) made negligible on the trend which was discovered for both sorting algorithms. This  can be explained as regardless of the values of the array the comparisons need to be made in order to determine if the array is sorted.  

It was also seen that $n \to \infin$, where $n$ is the length of the array The values of selections sort approach infinity at a much more rapid rate than merge sort. The merge sort cure approximates that more of a curve  $O(n^2)$ as theorised. Where are merge sort appear more linear but not complete proportional $n$. So more close to $O(n\log{n})$  as theorised.

A hypothesis for the better performance of Selection Sort than merge sort for smaller value may be since merge sort was implemented in a recursive manner it takes up a lot of memory and has to perform repeated function calls. Also merge sort has to create several arrays in execution of sort which is also time consuming for small n.