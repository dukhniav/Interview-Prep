# Priority Queue

- Challenge: Find the largest _M_ items in a stream of _N_ items

```java
// use a min-oriented pq
MinPQ<Transaction> pq = new MinPQ<Transaction>(); // Transaction data type is Comparable (ordered by $$)

while(StdIn.hasNextLine()){
    String line = StdIn.readLine();
    Transaction item = new Transaction(line);
    pq.insert(item);
    // pq contains largest M items
    if(pq.size() > M){
        pq.delMin();
    }
}
```
