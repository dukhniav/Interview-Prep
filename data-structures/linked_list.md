# Linked Lists

One disadvantage of using arrays to store data is that arrays are static structures and therefore cannot be easily extended or reduced to fit the data set. Arrays are also expensive to maintain new insertions and deletions.

Linked Lists try to address some of the limitations of arrays. A linked list is a linear data structure, where each element is a separate object.

<img src="images/linked_list.jpg">

Each element (we will call it a node) of a list is comprising of two items:
* the data
* a reference to the next node
The last node has a reference to *null*. The entry point into a linked list is called the *head* of the list. It should be noted that head is not a separate node, but **the reference to the first node**. If the list is empty then the head is a null reference.

A linked list is a dynamic data structure. The number of nodes in a list is not fixed and can grow and shrink on demand. Any application which has to deal with an unknown number of objects will need to use a linked list.

|  | LinkedList | Array | Dynamic Array | Balanced Tree | Random Access List | Hashed Array Tree |
|---------------------------|--------------------------------------------------------------------|-------|----------------|---------------|--------------------|-------------------|
| Indexing | Θ(n) | Θ(1) | Θ(1) | Θ(log n) | Θ(log n) | Θ(1) |
| Insert/delete @ beginning | Θ(1) | N/A | Θ(n) | Θ(log n) | Θ(1) | Θ(n) |
| Insert/delete @ end | Θ(1) when last element is known; Θ(n) when last element is unknown | N/A | Θ(1) amortized | Θ(log n) | Θ(log n) updating | Θ(1) amortized |
| Insert/delete in middle | search time + Θ(1 | N/A | Θ(n) | Θ(log n) | Θ(log n) updating | Θ(n) |
| Wasted space (average) | Θ(n) | 0 | Θ(n) | Θ(n) | Θ(n) | Θ(√n) |

### Disadvantages
* It does not allow direct access to the individual elements. If you want to access a particular item then you have to start at the head and follow the references until you get to that item. (*Random access*)
* Uses more memory compared to an array - extra 4 bytes (on 32-bit CPU) to store a reference to the next node.

## Types of Linked Lists
### Singly Linked List
(described above)

### Doubly Linked List
<img src="images/doubly_linked_list.bmp">
Linked list which has two references, one to the *next* node, and another to the *previous* node.

### Circular Linked List
Linked list where last node of the list points back to the first node (or the head) of the list.

## Implementing LinkedList from scratch
Need two classes:
* Node
* CustomList

```
public class Node{
  String data;
  Node next;

  public Node(String item) {
    data = item;
  }
}

public class CustomList {
  Node head;

  public CustomList(String item) {
    head = new Node(item);
  }

  public void add(String item) {
    /*
      pseudo code: while next isn't null, walk the list
      once you reach the end, create a new LinkNode and add the item to it.  Then
      set the last LinkNode's next to this new LinkNode
    */
  }
}
```
