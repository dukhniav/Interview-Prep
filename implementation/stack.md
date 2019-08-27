# Stack implementation

- [Linked-list implementation](#linkedlist-implementation)
- [Array implementation](#array-implementation)

## Pseudocode

`STACK-EMPTY(S)`

1. **if** _S.top_==0
2. &nbsp;&nbsp;&nbsp;&nbsp;**return** TRUE
3. **else return** FALSE

`PUSH(S,x)`

1. _S.top_ = _S.top_ + 1
2. _S_[*S.top*] = x

`POP(S)`

1. **if** STACK-EMPTY(S)
2. &nbsp;&nbsp;&nbsp;&nbsp; **error** "underflow"
3. **else** _S.top_ = _S.top_ - 1
4. &nbsp;&nbsp;&nbsp;&nbsp; **return** _S_[*S.top* + 1]

> Each of the three stack operations take _O_(1) time.

### LinkedList implementation

Generic implementation:

```java
public class Stack<item>{
  private Node first = null;

  /*
    Private inner class
    (access modiefiers don't matter)
  */
  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void push(Item item) {
    // Save pointer to beginning to list
    Node oldFirst = first;
    // Create a new node for the beginning
    first = new Node();
    // Set the instance variables in the new node
    first.item = item;
    first.next = oldFirst;
  }

  public Item pop() {
    // Save item to return
    Item item = first.item;
    // Delete first node (pop)
    first = first.next;
    return item;
  }
}

```

#### Stack of strings data type

- Read strings from StdIn
  - if strings equals "-", pop string from stack and pring
  - otherwise, push string onto stack

```java
while (!StdIn.isEmpty()){
    String s = StdIn.readString();
    if( s.equals("-")) {
        StdOut.print(stack.pop);
    } else {
        stack.push(s);
    }
}
```

### Array implementation

- use array `s[]` to store N items on stack
- `push()`: add new item to `s[N]`
- `pop()`: remove item from `s[N-1]`

> Defect: Stack overflows when N exceeds capacity

> Breaks 'API' by requiring client to provide array size

- Overflow and underflow
  - **Underflow**: throw exception if pop from an empty stack
  - **Overflow**: use resizing array for array implementation
- **Null items**: allow null items to be inserted
- **Loitering**: Holding a reference to an object when it's no longer needed

```java
public class FixedCapacityStackOfStrings{
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push (String item) {
        // index into array, then increment N
        s[N++] = item;
    }

    /**
     * Avoids 'loitering',
     * Gargabe collector can reclaim memory only if no outstanding references.
     **/
    public String pop() {
        // decrement N, then use to index into array
        String item = s[--N;
        s[N] = null;
        return item;
    }
}
```

#### Resizing-array

- Problem: requiring client to provide capapcity does not implement API
- How to grow array?
  - If array is full, create a new array of **_twice_** (_repeated doubling_) the size, and copy items.

##### _Amortized_ cost of adding to a stack

- Cost of inserting first N items: _N = (2 + 4 + 8 + ... + N) ~ 3N_

```java
public ResizingArrayStackOfStrings(){
    s = new String[1];
}

public void push(String item){
    if (N == s.length){
        resize(2 * s.length);
    } else {
        s[N++] = item;
    }
}

private void resize(int capacity) {
    String[] copy = new String[capacity];
    for(int i = 0; i < N; i++){
        cop[i] = s[i];
    }
    s = copy;
}
```

- How to shring array?
  - `push()`: double size of array s[] when array is full
  - `pop()`: halve size of array s[] when array is **_one quarter full_**

```java
public String pop(){
    String item = s[--N];
    s[N] = null;
    if (N > 0 && N == s.length/4){
        resize(s.length / 2);
    }
    return item;
}
```

> Array is always between 25% and 100% full
