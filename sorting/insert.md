# Insertion Sort

Compare adjacent entries and swap if they are out of order.

Insertion sort takes advantage of presorting.
- It requires fewer comparisons than bubblesort, unless the list is backwards.
- It only requires one comparison per element for a presorted list.

With a sorted array, we can insert new elements.
- How insertion sort will be used in practice most often.

## Pseudocode
```
for i = 1 to n - 1
  j = i
  while j > 0 and A[j] < A[j - 1]
    swap(A[j], A[j - 1])
    j = j - 1
```
