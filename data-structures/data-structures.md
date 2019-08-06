# Data Structures Interview


## Linked Lists
A linked list consists of nodes where each node contains a data field and a reference(link) to the next node in the list.
![alt text](https://github.com/dukhniav/prep/blob/master/data-structures/images/linked_list.jpg)

### Singly linked list
Item navigation is forward only.

### Doubly linked list
Items can be navigated forward and backward.

### Circular linked list
Last item contains link of the first element as next and the first element has a link to the last element as previous.

### Basic Operations
#### Insertion − Adds an element at the beginning of the list.
#### Deletion − Deletes an element at the beginning of the list.
#### Display − Displays the complete list.
#### Search − Searches an element using the given key.
#### Delete − Deletes an element using the given key.

## Stacks
A stack is an Abstract Data Type (ADT), commonly used in most programming languages. It is named stack as it behaves like a real-world stack, for example – a deck of cards or a pile of plates, etc.

At any given time, we can only access the top element of a stack.

This feature makes it **LIFO** data structure. LIFO stands for Last-in-first-out. Here, the element which is placed (inserted or added) last, is accessed first. In stack terminology, insertion operation is called PUSH operation and removal operation is called POP operation.

A stack can be implemented by means of Array, Structure, Pointer, and Linked List. Stack can either be a fixed size one or it may have a sense of dynamic resizing. Here, we are going to implement stack using arrays, which makes it a fixed size stack implementation.

![alt text](https://github.com/dukhniav/prep/blob/master/data-structures/images/stack_representation.jpg)

### Basic Operations
#### push()
- Pushing (storing) an element on the stack.

The process of putting a new data element onto stack is known as a Push Operation. Push operation involves a series of steps −
1. Checks if the stack is full.
2. If the stack is full, produces an error and exit.
3. If the stack is not full, increments top to point next empty space.
4. Adds data element to the stack location, where top is pointing.
5. Returns success.

![alt text](https://github.com/dukhniav/prep/blob/master/data-structures/images/stack_push_operation.jpg)

##### Algorithm
```
begin procedure push: stack, data

   if stack is full
      return null
   endif
   
   top ← top + 1
   stack[top] ← data

end procedure
```

#### pop()
− Removing (accessing) an element from the stack.

Accessing the content while removing it from the stack, is known as a Pop Operation. In an array implementation of pop() operation, the data element is not actually removed, instead top is decremented to a lower position in the stack to point to the next value. But in linked-list implementation, pop() actually removes data element and deallocates memory space.

A Pop operation may involve the following steps −
1. Checks if the stack is empty.
2. If the stack is empty, produces an error and exit.
3. If the stack is not empty, accesses the data element at which top is pointing.
4. Decreases the value of top by 1.
5. Returns success.

##### Algorithm
```
begin procedure pop: stack

   if stack is empty
      return null
   endif
   
   data ← stack[top]
   top ← top - 1
   return data

end procedure
```

#### peek()
− get the top data element of the stack, without removing it.
```
int peek() {
   return stack[top];
}
```

#### isFull()
− check if stack is full.
```
bool isfull() {
   if(top == MAXSIZE)
      return true;
   else
      return false;
}
```

#### isEmpty()
− check if stack is empty.


## Hash Table
## Trees
## Heaps
## Graphs
![alt text](https://github.com/dukhniav/prep/blob/master/data-structures/images/graph.jpg)
