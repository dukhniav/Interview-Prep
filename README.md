# Interview Prep Guide

[Google Tech Dev Guide](https://techdevguide.withgoogle.com/?_ga=2.205844115.1466422996.1565078662-1599821486.1565078662)

- [Data Structures](#data-structures)
	- [Arrays](#arrays)
	- [Linked Lists](#linked-lists)
	- [Stacks](#stacks)
	- [Queues](#queues)
	- [Hash Tables](#hash-tables)
	- [Trees](https://github.com/dukhniav/prep/blob/master/data-structures/tree.md)
	- [Heaps](https://github.com/dukhniav/Interview-Prep/blob/master/data-structures/heap.md)
	- [Graphs](https://github.com/dukhniav/Interview-Prep/blob/master/data-structures/graph.md)

## Data Structures
<hr>

<!--- ARRAYS ------------------------------------------------------------------>
### Arrays
![](images/array.gif)
#### Definition
Contiguous area of memory consisiting of equal-size elements indexed by contiguous integers.

- Fixed size (immutable)
- Specific data type
   * Can make an array of a generic `object` data-type, however, the more specific, the better.
   * **Flexibility introduces overhead**.

#### Arrays in Java
[GeeksForGeeks article](https://www.geeksforgeeks.org/arrays-in-java/)

- In Java all arrays are dynamically allocated.
- A Java array variable can also be declared like other variables with [] after the data type.
- The variables in the array are ordered and each have an index beginning from 0.
- Java array can be also be used as a static field, a local variable or a method parameter.
- The size of an array must be specified by an int value and not long or short.
- The direct superclass of an array type is Object.
- Every array type implements the interfaces Cloneable and java.io.Serializable.


- *Memory representation* - when `new` is used to create an array, Java reserves space in memory for it ( and initializes the values). Called *memory allocation*.

#### Java Array Literals
Java contains a shortcut for instantiating array of primitive types and strings. If you already know what values to insert into the array, you can use the array literal:
```java
int[] ints2 = new int[]{ 1,2,3,4,5,6,7,8 };
===
int[] ints2 = { 1,2,3,4,5,6,7,8 };
```

Notice how the values to be inserted into the array are listed inside the `{ ... }` block. The *length* of this also determines the length of the created array.

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
   * Just about grouping information together

#### ArrayList
- Resizable array (mutable) - Java
- Can be created empty, or some initial value.

- Adding new elements: Location?
    - `myArray.add(999);` - will be added to the end of the array, in constant time.
    - `myArray.add(999, 2);` - will be added to index 2, which means that all other indices will need to be moved.
    * Just because resizable arrays do the "shuffling" under the hood, doesn't mean we don't need to think about these details.

#### Appending items at end of array
| Lang | Code |
| --- | --- |
| Java | `add(value)` |
| Objective-C | `addObject:Value` |
| JavaScript | `push(value)` |
| Ruby | `push(value)` |
| Python | `append(value)` |

#### Inserting items at specific index
| Lang | Code |
| --- | --- |
| Java | `add(index,value)` |
| Objective-C | `addObject:Value atIndex:index` |
| JavaScript | `splice(index,items_to_remove,items_to_insert)` |
| Ruby | `insert(index,value)` |
| Python | `insert(index,value)` |

#### Removing items from an array
| Lang | Code |
| --- | --- |
| Java | `remove(index)` |
| Objective-C | `removeObjectAtIndex:index` |
| JavaScript | `pop / slice` |
| Ruby | `pop / delete_at` |
| Python | `pop / remove` |

\* pop -> always refers to removing the last item.


```java
// need to import
import java.util.*;

// create ArrayList of Strings
List<String> resizable = new ArrayList<String>();

// add to it
resizable.add("Hello World");
```

<hr>

<!--- LINKED LISTS ------------------------------------------------------------>
### Linked Lists

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

#### Disadvantages
* It does not allow direct access to the individual elements. If you want to access a particular item then you have to start at the head and follow the references until you get to that item. (*Random access*)
* Uses more memory compared to an array - extra 4 bytes (on 32-bit CPU) to store a reference to the next node.

#### Types of Linked Lists
##### Singly Linked List
(described above)

##### Doubly Linked List
<img src="images/doubly_linked_list.bmp">
Linked list which has two references, one to the *next* node, and another to the *previous* node.

##### Circular Linked List
Linked list where last node of the list points back to the first node (or the head) of the list.

#### Implementing LinkedList from scratch
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

<hr>
<!--- STACKS ------------------------------------------------------------------>

### Stacks

A stack is a basic data structure that can be logically thought of as a linear structure represented by a real physical stack or pile, a structure where insertion and deletion of items takes place at one end called top of the stack.

At any given time, we can only access the top element of a stack.

This feature makes it **LIFO** data structure. LIFO stands for Last-in-first-out. Here, the element which is placed (inserted or added) last, is accessed first.

![](images/stack_representation.jpg)

A stack is a **recursive** data structure. Here is a structural definition of a Stack:
- a stack is either empty or
- it consists of a top and the rest which is a stack


#### Basic Operations

There are basically three operations that can be performed on stacks:
1. inserting an item onto the stack (push)
2. removing an item from the stack (pop)
3. displaying the contents of the stack (peek)

>Note:
Depending on the language and implementation the data structure may share the name with an abstract data type that support all of the data structure characteristics.

#### Implementation

In the standard library of classes, the data type stack is an adapter class, meaning that a stack is built on top of other data structures. The underlying structure for a stack could be:
-  an array,
- a vector,
- an ArrayList,
- a linked list, or
- any other collection.

Regardless of the type of the underlying data structure, a Stack must implement the same functionality. This is achieved by providing a unique interface:

```java
public interface StackInterface<AnyType>
{
   public void push(AnyType e);

   public AnyType pop();

   public AnyType peek();

   public boolean isEmpty();
}
```

The following picture demonstrates the idea of implementation by *composition*.
![](images/stack_abstraction.bmp)

Another implementation requirement (in addition to the above interface) is that all stack operations must run in **constant time O(1)**. Constant time means that there is some constant k such that an operation takes k nanoseconds of computational time regardless of the stack size.


#### Example
```java
import java.util.*;

class StackDemo {
  public static void main(String[]args) {
    Stack<String> stack = new Stack<String>();
    stack.push("A");    // Insert "A" in the stack
    stack.push("B");    // Insert "B" in the stack
    stack.push("C");    // Insert "C" in the stack
    stack.push("D");    // Insert "D" in the stack
    System.out.println(stack.peek());    // Prints the top of the stack ("D")
    stack.pop();    // removing the top ("D")
    stack.pop();    // removing the next top ("C")
  }
}
```

<hr>

<!--- QUEUES ------------------------------------------------------------------>
### Queues

![alt text](images/queue_example.jpg)

Queue is an abstract data structure, somewhat similar to Stacks. Unlike stacks, a queue is open at both its ends. One end is always used to insert data (enqueue) and the other is used to remove data (dequeue). Queue follows First-In-First-Out methodology, i.e., the data item stored first will be accessed first.

#### Queue Representation
![](images/queue_diagram.jpg)
>As in stacks, a queue can also be implemented using Arrays, Linked-lists, Pointers and Structures.

#### Basic Operations
Queue operations may involve initializing or defining the queue, utilizing it, and then completely erasing it from the memory.

##### enqueue()
− add (store) an item to the queue.

##### dequeue()
− remove (access) an item from the queue.

##### peek()
− Gets the element at the front of the queue without removing it.

##### isFull()
− Checks if the queue is full.

##### isEmpty()
− Checks if the queue is empty.

In queue, we always dequeue (or access) data, pointed by front pointer and while enqueing (or storing) data in the queue we take help of rear pointer.

<hr>

<!--- HASH ------------------------------------------------------------------>
### Hash Tables

A.K.A. *hash, hash map, map, unordered map, dictionary*

#### Strengths:
- **Fast lookups** - Lookups take *O(1)* time on *average*.
- **Flexible keys** - Most data types can be used for keys, as long as they're hashable.

#### Weaknesses:
- **Slow worst-case lookups** - Lookups take *O(n)* time in the worst case.
- **Unordered** - Keys aren't stored in a special order. If you're looking for the smallest key, the largest key, or all the keys in a range, you'll need to look through every key to find it.
- **Single-directional lookups** - While you can look up the value for a given key in *O(1)* time, looking up the keys for a given value requires looping through the whole dataset—*O(n)* time.
- **Not cache-friendly** - Many hash table implementations use linked lists, which don't put data next to each other in memory.

| . | Average | Worst Case |
| --- | --- | --- |
| space 	| O(n) | O(n) |
| insert |	O(1) | O(n) |
| lookup |	O(1) | O(n) |
| delete |	O(1) | O(n) |

#### Compared to other data structures
|  | LinkedList | Array | Dynamic Array | Balanced Tree | Random Access List | Hashed Array Tree |
|---------------------------|--------------------------------------------------------------------|-------|----------------|---------------|--------------------|-------------------|
| Indexing | Θ(n) | Θ(1) | Θ(1) | Θ(log n) | Θ(log n) | Θ(1) |
| Insert/delete @ beginning | Θ(1) | N/A | Θ(n) | Θ(log n) | Θ(1) | Θ(n) |
| Insert/delete @ end | Θ(1) when last element is known; Θ(n) when last element is unknown | N/A | Θ(1) amortized | Θ(log n) | Θ(log n) updating | Θ(1) amortized |
| Insert/delete in middle | search time + Θ(1 | N/A | Θ(n) | Θ(log n) | Θ(log n) updating | Θ(n) |
| Wasted space (average) | Θ(n) | 0 | Θ(n) | Θ(n) | Θ(n) | Θ(√n) |

#### In Java
 In Java, hash tables are called hash maps.
```
HashMap<String, Integer> lightBulbToHoursOfLight = new HashMap<>();

lightBulbToHoursOfLight.put("incandescent", 1200);
lightBulbToHoursOfLight.put("compact fluorescent", 10000);
lightBulbToHoursOfLight.put("LED", 50000);
```

### When hash table operations cost *O(n)* time
#### Hash collisions
If all our keys caused hash collisions, we'd be at risk of having to walk through all of our values for a single lookup (in the example above, we'd have one big linked list). This is unlikely, but it could happen. That's the worst case.

#### Dynamic array resizing
Suppose we keep adding more items to our hash map. As the number of keys and values in our hash map exceeds the number of indices in the underlying array, hash collisions become inevitable.

To mitigate this, we could expand our underlying array whenever things start to get crowded. That requires allocating a larger array and rehashing all of our existing keys to figure out their new position—*O(n)* time.


#### Basic Operations
##### Search
Searches an element in a hash table.

##### Insert
Inserts an element in a hash table.

##### Delete
Deletes an element from a hash table.

##### Methods & Descriptions
`void clear( )` - Resets and empties the hash table.

`Object clone( )` - Returns a duplicate of the invoking object.

`boolean contains(Object value)` - Returns true if some value equal to the value exists within the hash table. Returns false if the value isn't found.

`boolean containsKey(Object key)` - Returns true if some key equal to the key exists within the hash table. Returns false if the key isn't found.

`boolean containsValue(Object value)` - Returns true if some value equal to the value exists within the hash table. Returns false if the value isn't found.

`Enumeration elements( )` - Returns an enumeration of the values contained in the hash table.

`Object get(Object key)` - Returns the object that contains the value associated with the key. If the key is not in the hash table, a null object is returned.

`boolean isEmpty( )` - Returns true if the hash table is empty; returns false if it contains at least one key.

`Enumeration keys( )` - Returns an enumeration of the keys contained in the hash table.

`Object put(Object key, Object value)` - Inserts a key and a value into the hash table. Returns null if the key isn't already in the hash table; returns the previous value associated with the key if the key is already in the hash table.

`void rehash( )` - Increases the size of the hash table and rehashes all of its keys.

`Object remove(Object key)` - Removes the key and its value. Returns the value associated with the key. If the key is not in the hash table, a null object is returned.

`int size( )` - Returns the number of entries in the hash table.

`String toString( )` - Returns the string equivalent of a hash table.

#### Example
```java
import java.util.*;
public class HashTableDemo {

   public static void main(String args[]) {
      // Create a hash map
      Hashtable balance = new Hashtable();
      Enumeration names;
      String str;
      double bal;

      balance.put("Zara", new Double(3434.34));
      balance.put("Mahnaz", new Double(123.22));
      balance.put("Ayan", new Double(1378.00));
      balance.put("Daisy", new Double(99.22));
      balance.put("Qadir", new Double(-19.08));

      // Show all balances in hash table.
      names = balance.keys();

      while(names.hasMoreElements()) {
         str = (String) names.nextElement();
         System.out.println(str + ": " + balance.get(str));
      }        
      System.out.println();

      // Deposit 1,000 into Zara's account
      bal = ((Double)balance.get("Zara")).doubleValue();
      balance.put("Zara", new Double(bal + 1000));
      System.out.println("Zara's new balance: " + balance.get("Zara"));
   }
}
```
##### Output
```
Qadir: -19.08
Zara: 3434.34
Mahnaz: 123.22
Daisy: 99.22
Ayan: 1378.0

Zara's new balance: 4434.34
```
