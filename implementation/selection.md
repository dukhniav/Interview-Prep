# Selection sort

#### Pseudocode

```java
for i = n down to 2 do
    k <- 1						// front of array
    for j = 2 to i do			// next position after front
        if A[j] > A[k] then 	// comparison
            k <- j
        end if
    end for
    A[k] <-> A[i] 				// swap
end for
```
