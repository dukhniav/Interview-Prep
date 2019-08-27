# Merge sort implementation

## Merging (using extra array)

```java
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
    assert isSorted(a, lo, mid);    // precondition: a[lo .. mid]   sorted
    assert isSorted(a, mid+1, hi);  // precondition: a[mid+1 .. hi] sorted

    // Copy to aux array
    for(int k = lo; k <= hi; k++){
        aux[k] = a[k];
    }

    // Merge back sorted
    int i = lo, j = mid + 1;
    for(int k = lo; k <- hi; k++){
        if      (i > mid)               a[k] = aux[j++];
        else if (j > hi)                a[k] = aux[i++];
        else if (less(aux[j], aux[i]))  a[k] = aux[j++];
        else                            a[k] = aux[i++];
    }

    assert isSorted(a, lo, hi); // postcondition: a[lo .. hi] sorted
}
```

## Mergesort

```java
public class Merge{
    private static void merge(...){ /* Implemented above */ }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        // Compute mid-point
        int mid = lo + (hi - lo) / 2;
        // Sort fist half
        sort(a, aux, lo, mid);
        // Sort second half
        sort(a, aux, mid + 1, hi);
        // Merge them together
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
```

## Bottom-up mergesort

- Logarithmic passes (over input array)
- Bad: Takes extra space

```java
public class MergeBU{
    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int hi){
        /* Implemented above */
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz = 1; sz < N; sz = sz + sz){
            merger(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }
}
```

<details>
<summary>Basic implementation</summary>

```java
// example of merge sort in Java
// merge function take two intervals
// one from start to mid
// second from mid+1, to end
// and merge them in sorted order

void merge(int Arr[], int start, int mid, int end) {
	// create a temp array
	int temp[] = new int[end - start + 1];
	// crawlers for both intervals and for temp
	int i = start, j = mid+1, k = 0;

	// traverse both arrays and in each iteration add smaller of both elements in temp
	while(i <= mid && j <= end) {
		if(Arr[i] <= Arr[j]) {
			temp[k] = Arr[i];
			k += 1; i += 1;
		}
		else {
			temp[k] = Arr[j];
			k += 1; j += 1;
		}
	}

	// add elements left in the first interval
	while(i <= mid) {
		temp[k] = Arr[i];
		k += 1; i += 1;
	}

	// add elements left in the second interval
	while(j <= end) {
		temp[k] = Arr[j];
		k += 1; j += 1;
	}

	// copy temp to original interval
	for(i = start; i <= end; i += 1) {
		Arr[i] = temp[i - start]
	}
}

// Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr
void mergeSort(int Arr[], int start, int end) {
	if(start < end) {
		int mid = (start + end) / 2;
		mergeSort(Arr, start, mid);
		mergeSort(Arr, mid+1, end);
		merge(Arr, start, mid, end);
	}
}
```

</details>

[Assertions](../README.md#assert)
