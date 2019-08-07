# Stacks

A stack is a basic data structure that can be logically thought of as a linear structure represented by a real physical stack or pile, a structure where insertion and deletion of items takes place at one end called top of the stack.

At any given time, we can only access the top element of a stack.

This feature makes it **LIFO** data structure. LIFO stands for Last-in-first-out. Here, the element which is placed (inserted or added) last, is accessed first.

![](images/stack_representation.jpg)

A stack is a **recursive** data structure. Here is a structural definition of a Stack:
- a stack is either empty or
- it consists of a top and the rest which is a stack


### Basic Operations

There are basically three operations that can be performed on stacks:
1. inserting an item onto the stack (push)
2. removing an item from the stack (pop)
3. displaying the contents of the stack (peek)

>Note:
Depending on the language and implementation the data structure may share the name with an abstract data type that support all of the data structure characteristics.

### Implementation

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
