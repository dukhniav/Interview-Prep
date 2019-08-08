# Quicksort

- Stable: `No`
- Time complexity:
  - Best Case: `O(nlog(n))`
  - Average Case: `O(nlog(n))`
  - Worst Case: `O(n^2)`

![](images/quicksort.gif)

>Quicksort is a sorting algorithm, which, like merge-sort, is leveraging the divide-and-conquer principle. It has an average O(n log n) complexity and it’s one of the most used sorting algorithms, especially for big data volumes.

It’s **important to remember that Quicksort isn’t a stable algorithm.** A stable sorting algorithm is an algorithm where the elements with the same values appear in the same order in the sorted output as they appear in the input list.

The input list is divided into two sub-lists by an element called pivot; one sub-list with elements less than the pivot and another one with elements greater than the pivot. This process repeats for each sub-list.

Finally, all sorted sub-lists merge to form the final output.

## Algorithm steps
1. We choose an element from the list, called the pivot. We’ll use it to divide the list into two sub-lists.
2. We reorder all the elements around the pivot – the ones with smaller value are placed before it, and all the elements greater than the pivot after it. After this step, the pivot is in its final position. This is the important partition step.
3. We apply the above steps recursively to both sub-lists on the left and right of the pivot.

As we can see, **quicksort is naturally a recursive algorithm, like every divide and conquer approach**.

Let’s take a simple example in order to better understand this algorithm.

```java
Arr[] = {5, 9, 4, 6, 5, 3}
```

1. Let’s suppose we pick 5 as the pivot for simplicity
2. We’ll first put all elements less than 5 in the first position of the array: {3, 4, 5, 6, 5, 9}
3. We’ll then repeat it for the left sub-array {3,4}, taking 3 as the pivot
4. There are no elements less than 3
5. We apply quicksort on the sub-array in the right of the pivot, i.e. {4}
6. This sub-array consists of only one sorted element
7. We continue with the right part of the original array, {6, 5, 9} until we get the final ordered array

## Choosing the Optimal Pivot

The crucial point in QuickSort is to choose the best pivot. The middle element is, of course, the best, as it would divide the list into two equal sub-lists.

But finding the middle element from an unordered list is difficult and time-consuming, that is why we take as pivot the first element, the last element, the median or any other random element.

## Algorithm Analysis
### Time Complexity

In the best case, the algorithm will divide the list into two equal size sub-lists. So, the first iteration of the full n-sized list needs O(n). Sorting the remaining two sub-lists with n/2 elements takes 2*O(n/2) each. As a result, the QuickSort algorithm has the complexity of O(n log n).

In the worst case, the algorithm will select only one element in each iteration, so O(n) + O(n-1) + … + O(1), which is equal to O(n2).

On the average QuickSort has O(n log n) complexity, making it suitable for big data volumes.

### QuickSort vs MergeSort
Let’s discuss in which cases we should choose QuickSort over MergeSort.

Although both Quicksort and Mergesort have an average time complexity of O(n log n), Quicksort is the preferred algorithm, as it has an O(log(n)) space complexity. Mergesort, on the other hand, requires O(n) extra storage, which makes it quite expensive for arrays.

Quicksort requires to access different indices for its operations, but this access is not directly possible in linked lists, as there are no continuous blocks; therefore to access an element we have to iterate through each node from the beginning of the linked list. Also, Mergesort is implemented without extra space for LinkedLists.

In such case, overhead increases for Quicksort and Mergesort is generally preferred.

## Conclusion

Quicksort is an elegant sorting algorithm that is very useful in most cases.

It’s generally an “in-place” algorithm, with the average time complexity of O(n log n).

Another interesting point to mention is that Java’s Arrays.sort() method uses Quicksort for sorting arrays of primitives. The implementation uses two pivots and performs much better than our simple solution, that is why for production code it’s usually better to use library methods.


## Pseudocode
```java
/*
  low  --> Starting index
  high  --> Ending index
*/
quickSort(arr[], low, high) {
    if (low < high) {
        /*
          pi is partitioning index,
          arr[pi] is now at right place
        */
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}
```
## Implementation
>The first method is quickSort() which takes as parameters the array to be sorted, the first and the last index. First, we check the indices and continue only if there are still elements to be sorted.

>We get the index of the sorted pivot and use it to recursively call partition() method with the same parameters as the quickSort() method, but with different indices:

```java
public void quickSort(int arr[], int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
    }
}
```

>Let’s continue with the partition() method. For simplicity, this function takes the last element as the pivot. Then, checks each element and swaps it before the pivot if its value is smaller.

>By the end of the partitioning, all elements less then the pivot are on the left of it and all elements greater then the pivot are on the right of it. The pivot is at its final sorted position and the function returns this position:

```java
private int partition(int arr[], int begin, int end) {
    int pivot = arr[end];
    int i = (begin-1);

    for (int j = begin; j < end; j++) {
        if (arr[j] <= pivot) {
            i++;

            int swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }

    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
}
```
