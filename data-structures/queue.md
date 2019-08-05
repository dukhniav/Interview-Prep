# Queues
![alt text](https://github.com/dukhniav/prep/blob/master/data-structures/images/queue_example.jpg)

Queue is an abstract data structure, somewhat similar to Stacks. Unlike stacks, a queue is open at both its ends. One end is always used to insert data (enqueue) and the other is used to remove data (dequeue). Queue follows First-In-First-Out methodology, i.e., the data item stored first will be accessed first.

## Queue Representation
![](https://github.com/dukhniav/prep/blob/master/data-structures/images/queue_diagram.jpg)

As in stacks, a queue can also be implemented using Arrays, Linked-lists, Pointers and Structures.

## Basic Operations
Queue operations may involve initializing or defining the queue, utilizing it, and then completely erasing it from the memory.

### enqueue()
− add (store) an item to the queue.

### dequeue()
− remove (access) an item from the queue.

### peek()
− Gets the element at the front of the queue without removing it.

### isFull()
− Checks if the queue is full.

### isEmpty()
− Checks if the queue is empty.

In queue, we always dequeue (or access) data, pointed by front pointer and while enqueing (or storing) data in the queue we take help of rear pointer.

