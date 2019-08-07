# Heaps

A Heap is a **specialized tree-based data structure**. Therefore it’s composed of nodes. We assign the elements to nodes: every node contains exactly one element.

Also, nodes can have children. **If a node doesn’t have any children, we call it leaf**.

What Heap makes special are two things:

1. every node’s value must be **less or equal to all values stored in its children**
2. it’s a **complete tree**, which means it has the least possible height

Because of the 1st rule, **the least element always will be in the root of the tree**.

How we enforce these rules is implementation-dependent.

Heaps are usually used to implement priority queues because Heap is a very efficient implementation of extracting the least (or greatest) element.

## Heap Variants

Heap has many variants, all of them differ in some implementation details.

For example, what we described above is a **Min-Heap, because a parent is always less than all of its children**. Alternatively, we could have defined Max-Heap, in which case a parent is always greater than it’s children. Hence, the greatest element will be in the root node.

We can choose from many tree implementations. The most straightforward is a Binary Tree. **In a Binary Tree, every node can have at most two children. We call them left child and right child**.

The easiest way to enforce the 2nd rule is to use a Full Binary Tree. A Full Binary Tree follows some simple rules:

1.    if a node has only one child, that should be its left child
2.    only the rightmost node on the deepest level can have exactly one child
3.    leaves can only be on the deepest level

Let’s see these rules with some examples:
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


## Inserting Elements

We should implement all operations in a way, that keeps the Heap invariants. This way, we can **build the Heap with repeated insertions**, so we’ll focus on the single insert operation.

We can insert an element with the following steps:

1.    create a new leaf which is the rightmost available slot on the deepest level and store the item in that node
2.    if the element is less than it’s parent, we swap them
3.    continue with step 2, until the element is less than it’s parent or it becomes the new root

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

## Heap Implementation in Java

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

-    parent: (index – 1) / 2
-    left child: 2 * index + 1
-    right child: 2 * index + 2

Since we don’t want to bother with array reallocating, we’ll simplify the implementation even more and use an *ArrayList*.

A basic Binary Tree implementation looks like this:
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

>The code above only adds the new element to the end of the tree. Therefore, we need to traverse the new element up if necessary. We can do it with the following code:

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
>Note, that since we need to compare the elements, they need to implement java.util.Comparable.
