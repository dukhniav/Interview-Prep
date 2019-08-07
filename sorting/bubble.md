# Bubble Sort



Comparisons = n-1 + n-2 + n-3 + ... + 2 + 1 = n(n-1)/2  =  O(n<sup>2</sup>)

## Pseudocode:
```
for i = (n - 1) to 1
  for j = 0 to (i - 1)
    if A[j] < A[j + 1]
      swap(A[j], A[j + 1])
```
