# Interview Prep Guide

[Google Tech Dev Guide](https://techdevguide.withgoogle.com/?_ga=2.205844115.1466422996.1565078662-1599821486.1565078662)

## Table of Contents

- [Data Structures](#data-structures) - [Arrays](#arrays)
  - [Stacks](#stacks) - [Queues](#queues) - [Linked Lists](#linked-lists) - [Hash Tables](#hash-tables) - [Hash Function](#hash-function)
- [Graphs](#graphs) - Directed - Undirected - Breadth First Search (BFS) - Depth First Search (DFS)
- [Trees](#trees) - Binary Trees - Spanning Trees - Minimum Spanning Trees - AVL Trees - [Heaps](#heaps)
- Sorting Algorithms - Bubble sort - [Selection sort](#selection-sort) - [Insertion sort](#insertion-sort) - Merge sort - Quick sort
- Other Algorithms - Topological sort - Dijkstra's algorithm - Kruskal's algorithm - Prim's algorithm
- Big-O Analysis of Algorithms - Time Function: T(N) - Big-O notation
- System Design
- Networking
- Design Patterns
- Testing

## Data Structures

<hr>

<!--- ARRAYS ------------------------------------------------------------------>

### Arrays

![](images/array.gif)

#### Definition

Contiguous area of memory consisting of equal-size elements indexed by contiguous integers.

- Fixed size (immutable)
- Specific data type
  - Can make an array of a generic `object` data-type, however, the more specific, the better.
  - **Flexibility introduces overhead**.

#### Arrays in Java

[GeeksForGeeks article](https://www.geeksforgeeks.org/arrays-in-java/)

- In Java all arrays are dynamically allocated.
- A Java array variable can also be declared like other variables with [] after the data type.
- The variables in the array are ordered and each have an index beginning from 0.
- Java array can be also be used as a static field, a local variable or a method parameter.
- The size of an array must be specified by an int value and not long or short.
- The direct superclass of an array type is Object.
- Every array type implements the interfaces Cloneable and java.io.Serializable.

* _Memory representation_ - when `new` is used to create an array, Java reserves space in memory for it ( and initializes the values). Called _memory allocation_.

#### Java Array Literals

Java contains a shortcut for instantiating array of primitive types and strings. If you already know what values to insert into the array, you can use the array literal:

```java
int[] ints2 = new int[]{ 1,2,3,4,5,6,7,8 };
===
int[] ints2 = { 1,2,3,4,5,6,7,8 };
```

Notice how the values to be inserted into the array are listed inside the `{ ... }` block. The _length_ of this also determines the length of the created array.

#### Iterating Arrays

Iterating through an array of `String` objects:

```java
String[] stringArray = {"one", "two", "three"};

for(String theString : stringArray) {
    System.out.println(theString);
}
```

[Coursera: Arrays (video)](https://www.coursera.org/learn/data-structures/lecture/OsBSF/arrays)
[Lynda: Basic Arrays (video)](https://archive.org/details/0102WhatYouShouldKnow/02_04-basicArrays.mp4)
[Multi-dimentional (video)](https://archive.org/details/0102WhatYouShouldKnow/02_05-multidimensionalArrays.mp4)

#### One-Dimentional Array

<img src="images/1d_array.png" width="500">

- Constant time access to any element.
- Constant time to add/remove at the end (memory wise)
- Linear time to add/remove to an arbitrary location (memory wise)

#### Two-Dimentional Array (Matrix)

<img src="images/2d_array.png" width="500">

- Array of arrays
- Need two numbers to access.

#### Multi-Dimentional Array (Jagged Array)

<img src="images/muilti_d_array.png" width="500">

- Array of arrays of arrays
  - Just about grouping information together

#### ArrayList

- Resizable array (mutable) - Java
- Can be created empty, or some initial value.

- Adding new elements: Location?
  - `myArray.add(999);` - will be added to the end of the array, in constant time.
  - `myArray.add(999, 2);` - will be added to index 2, which means that all other indices will need to be moved.
  * Just because resizable arrays do the "shuffling" under the hood, doesn't mean we don't need to think about these details.

#### Appending items at end of array

| Lang        | Code              |
| ----------- | ----------------- |
| Java        | `add(value)`      |
| Objective-C | `addObject:Value` |
| JavaScript  | `push(value)`     |
| Ruby        | `push(value)`     |
| Python      | `append(value)`   |

#### Inserting items at specific index

| Lang        | Code                                            |
| ----------- | ----------------------------------------------- |
| Java        | `add(index,value)`                              |
| Objective-C | `addObject:Value atIndex:index`                 |
| JavaScript  | `splice(index,items_to_remove,items_to_insert)` |
| Ruby        | `insert(index,value)`                           |
| Python      | `insert(index,value)`                           |

#### Removing items from an array

| Lang        | Code                        |
| ----------- | --------------------------- |
| Java        | `remove(index)`             |
| Objective-C | `removeObjectAtIndex:index` |
| JavaScript  | `pop / slice`               |
| Ruby        | `pop / delete_at`           |
| Python      | `pop / remove`              |

```java
// need to import
import java.util.*;

// create ArrayList of Strings
List<String> resizable = new ArrayList<String>();

// add to it
resizable.add("Hello World");
```

<hr>
<!--- STACKS ------------------------------------------------------------------>

### Stacks

In a _ stack_, the element deleted from the set is the one most recently inserted: the stack implements a **_last-in, first-out_**, or **_LIFO_** policy.

- The `INSERT` operation on a stack is often called `PUSH`
- The `DELETE` operation, which doesn't an element argument, is often called `POP`

<img src="images/stack_example1.png">

In above figure, a stack can be implemented of a at most _n_ elements with an array S[1..*n*]. The array has an attribute S._top_ that indexes the most recently inserted element. The stack consists of elements S[1..*S.top*], where S[1] is the element at the bottom of the stack and S[*S.top*] is the element at the top.

When S[*S.top*] = 0, the stack contains no elements and is _empty_. We can test to see whether the stack is empty by query operation `STACK-EMPTY`. If we attempt to pop an empty stack, we say the stack **_underflows_**, which is normally an error. If S[*S.top*] exceeds n, the **_stack overflows_**. (In our pseudocode implementation, we don’t worry about stack overflow.)

#### Pseudocode

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

<hr>

<!--- QUEUES ------------------------------------------------------------------>

### Queues

In a **_queue_**, the element deleted is always the one that has been in the set for the longest time: the queue implements a **_first-in, first-out_**, or **_FIFO_** policy

<img src="images/queue_example1.png">

> A queue implemented using an array _Q_[1..12]. Queue elements appear only in the lightly shaded positions. (**a**) The queue has 5 elements, in locations _Q_[7..11]. (**b**) The configuration of the queue after the calls ENQUEUE(_Q_,17), ENQUEUE(_Q_,3), and ENQUEUE(_Q_,5). (**c**) The configuration of the queue after the call DEQUEUE(_Q_) returns the key value 15 formerly at the head of the queue. The new head has key 6.

We call the `INSERT` operation on a queue `ENQUEUE`, and we call the `DELETE` operation `DEQUEUE`; like the stack operation `POP`, `DEQUEUE` takes no element argument. The **_FIFO_** property of a queue causes it to operate like a line of customers waiting to pay a cashier. The queue has a **_head_** and a **_tail_**. When an element is enqueued, it takes its place at the tail of the queue, just as a newly arriving customer takes a place at the end of the line. The element dequeued is always the one at the head of the queue, like the customer at the head of the line who has waited the longest.

The figure above shows one way to implement a queue of at most _n_ - 1 elements using an array _Q_[1..*n*]. The queue has an attribute _Q.head_ that indexes, or points to, its head. The attribute _Q.tail_ indexes the next location at which a newly arriving element will be inserted into the queue. The elements in the queue reside in locations _Q.head_, _Q.head_ + 1, ..., _Q.tail_ - 1, where we “wrap around” in the sense that location 1 immediately follows location n in a circular order. When _Q.head_ = _Q.tail_, the queue is **empty**. Initially, we have _Q.head_ = _Q.tail_ = 1. If we attempt to dequeue an element from an empty queue, the queue underflows.

When _Q.head_ = _Q.tail_ + 1, the queue is full, and if we attempt to enqueue an element, then the queue overflows.
In our procedures `ENQUEUE` and `DEQUEUE`, we have omitted the error checking for underflow and overflow. The pseudocode assumes that _n_ = _Q.length_.

#### Pseudocode

`ENQUEUE(Q,x)`

1. _Q_[*Q.tail*] = x
2. **if** _Q.tail_ == _Q.length_
3. &nbsp;&nbsp;&nbsp;&nbsp;_Q.tail_ = 1
4. **else** _Q.tail_ = _Q.tail_ + 1

`DEQUEUE(Q)`

1. x = _Q_[*Q.head*]
2. **if** _Q.head_ == _Q.length_
3. &nbsp;&nbsp;&nbsp;&nbsp;_Q.head_ = 1
4. **else** _Q.head_ = _Q.head_ + 1
5. **return** x

<hr>

<!--- LINKED LISTS ------------------------------------------------------------>

### Linked Lists

<img src='images/linkedlist_example1.png'>

> (**a**) A doubly linked list _L_ representing the dynamic set {4, 9, 16}. Each element in the list is an object with attributes for the key and pointers (shown by arrows) to the _next_ and previous objects. The next attribute of the tail and the _prev_ attribute of the head are `NIL`, indicated by a diagonal slash. The attribute _L.head_ points to the head. (**b**) Following the execution of `LIST-INSERT(L,x)`, where _x.key_ = 25, the linked list has a new object with key 25 as the new head. This new object points to the old head with key 9. (**c**) The result of the subsequent call `LIST-DELETE(L,x)`, where x points to the object with key 4.

A **\*_linked list_** is a data structure in which the objects are arranged in a linear order. Unlike an array, however, in which the linear order is determined by the array indices, the order in a linked list is determined by a pointer in each object. Linked lists provide a simple, flexible representation for dynamic sets.

As shown in above figure, each element of a **_doubly linked list L_** is an object with an attribute _key_ and two other pointer attributes: _next_ and _prev_. The object may also contain other satellite data. Given an element _x_ in the list, _x.next_ points to its successor in the linked list, and _x:prev_ points to its predecessor. If _x:prev_ = NIL, the element _x_ has no predecessor and is therefore the first element, or **_head_**, of the list. If _x.next_ = NIL, the element x has no successor and is therefore the last element, or **_tail_**, of the list. An attribute _L.head_ points to the first element of the list. If _L.head_ = NIL, the list is empty.

A list may have one of several forms. It may be either singly linked or doubly linked, it may be sorted or not, and it may be circular or not. If a list is **_singly linked_**, we omit the _prev_ pointer in each element. If a list is **_sorted_**, the linear order of the list corresponds to the linear order of keys stored in elements of the list; the minimum element is then the head of the list, and the maximum element is the tail. If the list is **_unsorted_**, the elements can appear in any order. In a **_circular list_**, the _prev_ pointer of the head of the list points to the tail, and the next pointer of the tail of the list points to the head. We can think of a circular list as a ring of elements. In the remainder of this section, we assume that the lists with which we are working are unsorted and doubly linked.

#### Procedures

##### Searching a Linked List

The procedure `LIST-SEARCH(L,k)` finds the first element with key _k_ in list _L_ by a simple linear search, returning a pointer to this element. If no object with key _k_ appears in the list, then the procedure returns NIL. For the linked list in above figure (**a**), the call `LIST-SEARCH(L,4)` returns a pointer to the third element, and the call `LIST-SEARCH(L,7)` returns NIL.

`LIST-SEARCH(L,k)`

1. x = _L.head_
2. **while** _x_ &#8800; NIL and _x.key_ &#8800; _k_
3. &nbsp;&nbsp;&nbsp;&nbsp;_x_ = _x.next_
4. **return** _x_

To search a list of n objects, the `LIST-SEARCH` procedure takes &Theta;(_n_) time in the **worst case**, since it may have to search the entire list.

##### Inserting into a linked list

Given an element x whose _key_ attribute has already been set, the `LIST-INSERT` procedure “splices” x onto the front of the linked list, as shown above figure (**b**).

`LIST-INSERT(L,x)`

1. _x.next_ = _L.head_
2. **if** _L.head_ &#8800; NIL
3. &nbsp;&nbsp;&nbsp;&nbsp;_L.head.prev_ = _x_
4. _L.head_ = _x_
5. _x.prev_ = NIL

(Recall that our attribute notation can cascade, so that _L.head.prev_ denotes the _prev_ attribute of the object that _L.head_ points to.) The **running time** for `LIST-INSERT` on a list of _n_ elements is &Omicron;(1).

#####Deleting from a linked list
The procedure `LIST-DELETE` removes an element _x_ from a linked list _L_. It must be given a pointer to _x_, and it then “splices” _x_ out of the list by updating pointers. If we wish to delete an element with a given key, we must first call `LIST-SEARCH` to retrieve a pointer to the element.

`LIST-DELETE(L,x)`

1. **if** _x.prev_ &#8800; NIL
2. &nbsp;&nbsp;&nbsp;&nbsp;_x.prev.next_ = _x.next_
3. **else** _L.head_ = _x.next_
4. **if** _x.next_ &#8800; NIL
5. &nbsp;&nbsp;&nbsp;&nbsp;_x.next.prev_ = _x.prev_

Above figure shows how an element is deleted from a linked list. `LIST-DELETE` runs in &Omicron;(1) time, but if we wish to delete an element with a given key, &Theta;(_n_) time is required in the worst case because we must first call `LIST-SEARCH` to find the element.

<hr>

<!--- HASH ------------------------------------------------------------------>

### Hash Tables

A.K.A. _hash, hash map, map, unordered map, dictionary_

| .      | Average | Worst Case |
| ------ | ------- | ---------- |
| space  | O(n)    | O(n)       |
| insert | O(1)    | O(n)       |
| lookup | O(1)    | O(n)       |
| delete | O(1)    | O(n)       |

#### Hash function

##### Why is it needed

Collision resolution

- multiple keys map to same slot - `search, add and remove` become inefficient

Chaining

- Chain all collisions in lists attached to appropriate slot - Can handle unlimited number of collisions - Don't need prior knowledge of how many elements are contained in the collection

Open Addressing

- All elements occupy the hash table itself
- Search - Systematically examine table slots until - Either find desired element - Know that element is not in the table
- Hash table can 'fill up'
- Finding open spot (collision resolution) - Linear probing - Quadratic probing - Double hashing

##### Universal hashing

- no fixed hash function
- select hash function _at random_ from a _carefully designed_ class of functions - independent of the keys - algorithm can behave differently on each execution, even for same input

<hr>

<!--- TREES ------------------------------------------------------------------>

### Trees

[Series: Core Trees (video)](https://www.coursera.org/learn/data-structures-optimizing-performance/lecture/ovovP/core-trees)

[Series: Trees (video)](https://www.coursera.org/learn/data-structures/lecture/95qda/trees)

<details>
<summary>Examples</summary>

##### decision trees

<img src="images/decision_tree.png" width="400">

##### expression trees

<img src="images/expression_tree.png" width="400">

Evaluate: `45 / (3 + 6)`

##### file systems

<img src="images/file_system_tree.png" width="400">

`/users/porter/` --> hierarchical data structure - great for file systems

</details>

#### Terminology

- root
  - start at the root node
  - only node that doesn't have any parents
- leaf
  - nodes without children

#### What defines a tree

- single root
- each node can have only one parent (except root)
- no cycles in a tree

#### Binary Tree

![](images/binary_tree.jpg)

This is the most basic basic from of tree structure. Where each node can have **at two children**.

A binary tree is made of nodes, where each node contains a "left" pointer, a "right" pointer, and a data element. The "root" pointer points to the topmost node in the tree. The left and right pointers recursively point to smaller "subtrees" on either side. A null pointer represents a binary tree with no elements -- the empty tree. The formal recursive definition is: a binary tree is either empty (represented by a null pointer), or is made of a single node, where the left and right pointers (recursive definition ahead) each point to a **binary tree**.

The nodes at the bottom edge of the tree have empty subtrees and are called "leaf" nodes (F, G, H, I, J) while the others are "internal" nodes (A, B, C, D, E).

#### Binary Search Tree Niche

Basically, binary search trees are fast at insert and lookup. The next section presents the code for these two algorithms. On average, a binary search tree algorithm can locate a node in an N node tree in order lg(N) time (log base 2). Therefore, binary search trees are good for "dictionary" problems where the code inserts and looks up information indexed by some key. The lg(N) behavior is the average case -- it's possible for a particular tree to be much slower depending on its shape.

#### Terminology

- The depth of a node is the number of edges from the root to the node.
- The height of a node is the number of edges from the node to the deepest leaf.
- The height of a tree is a height of the root.
- A full binary tree is a binary tree in which each node has exactly zero or two children.
- A complete binary tree is a binary tree, which is completely filled, with the possible exception of the bottom level, which is filled from left to right.

#### Complete binary tree

A complete binary tree is very special tree, it provides the best possible ratio between the number of nodes and the height. The height h of a complete binary tree with N nodes is at most O(log N). We can easily prove this by counting nodes on each level, starting with the root, assuming that each level has the maximum number of nodes:

`n = 1 + 2 + 4 + ... + 2h-1 + 2h = 2h+1 - 1`

Solving this with respect to h, we obtain

`h = O(log n)`

where the big-O notation hides some superfluous details.

#### Traversals

- Depth-first traversal
  - PreOrder traversal - visit the parent first and then left and right children;
  - InOrder traversal - visit the left child, then the parent and the right child;
  - PostOrder traversal - visit left child, then the right child and then the parent;
- Breadth-first traversal
  - There is only one kind of breadth-first traversal--the level order traversal. This traversal visits nodes by levels from top to bottom and from left to right.

#### Implementation

<img src="images/binary_tree_traversals.png" width="400">

- each node needs:
  1. a value
  2. a parent
  3. a left child
  4. a right child
- to implement a generic tree, would just have a list instead of left/right children
  - because we don't know how many leaf nodes the tree might have

#### DFS

- preOrder Traversal
- postOrder Traversal

#### BFS

Visit: `A B C D E F G`

- levelOrder Traversal
- challenging - when finish with `B`, how do we know to know to `C`
  - keep two lists:
    - _list_ of nodes starting with root
    - _visited_ nodes
      - while at root `A`
      - add `A` to `list`
      - remove `A` from `list` and add `A`'s children to `list`
        - add `A` to `visited`
      - remove next node from `list` --> `B` and add its children to `list`
        - remove `B` from `list` and add it to `visited`
      - etc...
  - end up using tree like a `Queue`

<details>
<summary>Implementation</summary>

```java
public class BinaryTree<E> {
  TreeNode<e> root;

  /*
      preOrder Traversal
      ------------------
      Visit current root
      Visit left subtree
      Visit right subtree
  */
  private void preOrder(TreeNode<E> node){
    if(node != null){
      node.visit();
      preOrder(node.getLeftChild());
      preOrder(node.getRightChild());
    }
  }
  // runs preOrder on root
  public void preOrder() {
    this.preOrder(root);
  }

  /*
      postOrder Traversal
      ------------------
      Visit left subtree
      Visit right subtree
      Visit current root
  */
  private void postOrder(TreeNode<E> node){
    if(node != null){
      preOrder(node.getLeftChild());
      preOrder(node.getRightChild());
      node.visit();
    }
  }

  // run postOrder on root
  public void postOrder() {
    this.postOrder(root);
  }

  /*
      inOrder Traversal
      ------------------
      Visit left subtree
      Visit current root
      Visit right subtree
  */
  private void inOrder(TreeNode<E> node){
    if(node != null){
      preOrder(node.getLeftChild());
      node.visit();
      preOrder(node.getRightChild());
    }
  }

  // run inOrder on root
  public void inOrder() {
    this.inOrder(root);
  }

  /*
    levelOrder Traversal (BFS)
    --------------------------
    Using LinkedLists, because LinkedLists implement Heap
  */
  public void levelOrder() {
    Queue< TreeNode<E> > q = new LinkedList < TreeNode<E> > ();
    q.add(root);
    while(!q.isEmpty()) {
      TreeNode<E> curr = q.remove();
      if(curr != null) {
        // could check for null children before adding
        curr.visit();
        q.add(curr.getLeftChild());
        q.add(curr.getRightChild());
      }
    }
  }
}

public class TreeNode<E> {
  private E value;
  private TreeNode<E> parent;
  private TreeNode<E> left;
  private TreeNode<E> right;

  // Constructor
  public TreeNode(E val, TreeNode<E> par) {
    this.value = val;
    this.parent = par;
    this.left = null;
    this.right = null;
  }

  // Setter for left child
  public TreeNode<E> addLeftChild(E val) {
    // 'this' is passed as the parent
    this.left = new TreeNode<E>(val, this);
    return this.left;
  }

  // Setter for right child
  public TreeNode<E> addRightChild(E val) {
    // 'this' is passed as the parent
    this.right = new TreeNode<E>(val, this);
    return this.right;
  }
}
```

</details>

#### Binary Search Tree

![](images/binary_search_tree.jpg)

The basic idea behind this data structure is to have such a storing repository that provides the efficient way of data sorting, searching and retriving.

A BST is a binary tree where nodes are ordered in the following way:

- each node contains one key (also known as data)
- the keys in the left subtree are less then the key in its parent node, in short L < P;
- the keys in the right subtree are greater the key in its parent node, in short P < R;
- duplicate keys are not allowed.

#### Implementation

##### Insertion

The insertion procedure is quite similar to searching. We start at the root and recursively go down the tree searching for a location in a BST to insert a new node. If the element to be inserted is already in the tree, we are done (we do not insert duplicates). The new node will always replace a NULL reference.

##### Searching

Searching in a BST always starts at the root. We compare a data stored at the root with the key we are searching for (let us call it as toSearch). If the node does not contain the key we proceed either to the left or right child depending upon comparison. If the result of comparison is negative we go to the left child, otherwise - to the right child. The recursive structure of a BST yields a recursive algorithm.

Searching in a BST has O(h) worst-case runtime complexity, where h is the height of the tree. Since s binary search tree with n nodes has a minimum of O(log n) levels, it takes at least O(log n) comparisons to find a particular node. Unfortunately, a binary search tree can degenerate to a linked list, reducing the search time to O(n).

##### Deletion

Deletion is somewhat more tricky than insertion. There are several cases to consider. A node to be deleted (let us call it as toDelete)

- is not in a tree;
- is a leaf;
- as only one child;
- has two children.

If toDelete is not in the tree, there is nothing to delete. If toDelete node has only one child the procedure of deletion is identical to deleting a node from a linked list - we just bypass that node being deleted

#### AVL Tree

#### Red-Black Tree

<hr>

<!--- HEAPS ------------------------------------------------------------------>

### Heaps

A Heap is a **specialized tree-based data structure**. Therefore it’s composed of nodes. We assign the elements to nodes: every node contains exactly one element.

Also, nodes can have children. **If a node doesn’t have any children, we call it leaf**.

What makes Heaps special:

1. every node’s value must be **less or equal to all values stored in its children**
2. it’s a **complete tree**, which means it has the least possible height

Because of #1, **the least element always will be in the root of the tree**.

How we enforce these rules is implementation-dependent.

Heaps are usually used to implement priority queues because Heaps are a very efficient implementation of extracting the least (or greatest) element.

#### Heap Variants

Heap has many variants, all of them differ in some implementation details.

For example, what is described above is a **Min-Heap**, because a parent is always less than all of its children. Alternatively, in a **Max-Heap**, the parent is always greater than it’s children. Hence, the greatest element will be in the root node.

We can choose from many tree implementations. The most straightforward is a Binary Tree. **In a Binary Tree, every node can have at most two children. We call them left child and right child**.

The easiest way to enforce #2 is to use a Full Binary Tree. A Full Binary Tree follows some simple rules:

1.  if a node has only one child, that should be its left child
2.  only the rightmost node on the deepest level can have exactly one child
3.  leaves can only be on the deepest level

Some examples:

```
1        2      3        4        5        6         7         8        9       10
()       ()     ()       ()       ()       ()        ()        ()       ()       ()
        /         \     /  \     /  \     /  \      /  \      /        /        /  \
       ()         ()   ()  ()   ()  ()   ()  ()    ()  ()    ()       ()       ()  ()
                               /          \       /  \      /  \     /        /  \
                              ()          ()     ()  ()    ()  ()   ()       ()  ()
                                                                            /
                                                                           ()

```

The trees 1, 2, 4, 5 and 7 follow the rules.

Tree 3 and 6 violate the 1st rule, 8 and 9 the 2nd rule, and 10 violate the 3rd rule.

In this tutorial, we’ll focus on **Min-Heap with a Binary Tree** implementation.

#### Inserting Elements

We should implement all operations in a way, that keeps the Heap invariants. This way, we can **build the Heap with repeated insertions**, so we’ll focus on the single insert operation.

We can insert an element with the following steps:

1.  create a new leaf which is the rightmost available slot on the deepest level and store the item in that node
2.  if the element is less than it’s parent, we swap them
3.  continue with step 2, until the element is less than it’s parent or it becomes the new root

Note, that step 2 won’t violate the Heap rule, because if we replace a node’s value with a less one, it still will be less than it’s children.

Let’s see an example! We want to insert 4 into this Heap:

```
     2
    / \
   /   \
  3     6
 / \
5   7
```

The first step is to create a new leaf which stores 4:

```
     2
    / \
   /   \
  3     6
 / \   /
5   7 4
```

Since 4 is less than it’s parent, 6, we swap them:

```
     2
    / \
   /   \
  3     4
 / \   /
5   7 6
```

Now we check whether 4 is less than it’s parent or not. Since its parent is 2, we stop. The Heap is still valid, and we inserted number 4.

Let’s insert 1:

```
     2
    / \
   /   \
  3     4
 / \   / \
5   7 6   1
```

We have to swap 1 and 4:

```
     2
    / \
   /   \
  3     1
 / \   / \
5   7 6   4
```

Now we should swap 1 and 2:

```
     1
    / \
   /   \
  3     2
 / \   / \
5   7 6   4
```

Since 1 is the new root, we stop.

#### Heap Implementation in Java

Since we use a **Full Binary Tree, we can implement it with an array**: an element in the array will be a node in the tree. We mark every node with the array indices from left-to-right, from top-to-bottom the following way:

```
     0
    / \
   /   \
  1     2
 / \   /
3   4 5
```

The only thing we need is to keep track of how many elements we store in the tree. This way the index of the next element we want to insert will be the size of the array.

Using this indexing, we can calculate the index of the parent and child nodes:

- parent: (index – 1) / 2
- left child: 2 \* index + 1
- right child: 2 \* index + 2

Since we don’t want to bother with array reallocating, we’ll simplify the implementation even more and use an _ArrayList_.

A basic Binary Tree implementation looks like this:

<details>
<summary>Imlementation</summary>

```java
class BinaryTree<E> {

    List<E> elements = new ArrayList<>();

    void add(E e) {
        elements.add(e);
    }

    boolean isEmpty() {
        return elements.isEmpty();
    }

    E elementAt(int index) {
        return elements.get(index);
    }

    int parentIndex(int index) {
        return (index - 1) / 2;
    }

    int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    int rightChildIndex(int index) {
        return 2 * index + 2;
    }
}
```

> The code above only adds the new element to the end of the tree. Therefore, we need to traverse the new element up if necessary. We can do it with the following code:

```java
class Heap<E extends Comparable<E>> {

    // ...

    void add(E e) {
        elements.add(e);
        int elementIndex = elements.size() - 1;
        while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
            int parentIndex = parentIndex(elementIndex);
            swap(elementIndex, parentIndex);
            elementIndex = parentIndex;
        }
    }

    boolean isRoot(int index) {
        return index == 0;
    }

    boolean isCorrectChild(int index) {
        return isCorrect(parentIndex(index), index);
    }

    boolean isCorrect(int parentIndex, int childIndex) {
        if (!isValidIndex(parentIndex) || !isValidIndex(childIndex)) {
            return true;
        }

        return elementAt(parentIndex).compareTo(elementAt(childIndex)) < 0;
    }

    boolean isValidIndex(int index) {
        return index < elements.size();
    }

    void swap(int index1, int index2) {
        E element1 = elementAt(index1);
        E element2 = elementAt(index2);
        elements.set(index1, element2);
        elements.set(index2, element1);
    }

    // ...

}
```

> Note, that since we need to compare the elements, they need to implement java.util.Comparable.

</details>

<hr>
<!--- GRAPH ------------------------------------------------------------------>

### Graphs

<hr>
<!--- SORTING ----------------------------------------------------------------->

## Sorting

### Selection Sort

[An Algorithmic Analysis of Selection Sort: Best, Worst, & Average Case (video)](https://www.youtube.com/watch?v=TNRRoYCzlFw)

#### How it works

> Consider a pile of numbers to be sorted

- Steps: - Scan input pile (I) and select the smallest number. - Swap minimum element with value in first position - Swap next minimum element with value in second position

#### Pseudocode

```
for i = n down to 2 do
	k <- 1									// front of array
	for j = 2 to i do				// next position after front
		if A[j] > A[k] then 	// comparison
			k <- j
		end if
	end for
	A[k] <-> A[i] 					// swap
end for
```

<hr>
<!--- Insertion sort ---------------------------------------------------------->

### Insertion sort

#### How it works

> Consider a pile of numbers to be sorted

- Make two arbitrary piles - I: Input pile - O: Output pile
- Steps: 1. take the first item from input pile (I) and place into output pile (O) 2. take next item from I - if lower than the first item
- When to stop: - I is empty - O has all numbers in order
