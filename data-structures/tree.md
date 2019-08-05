# Trees

Trees represent nodes connected by edges.

Unlike Arrays, Linked Lists, Stack and queues, which are linear data structures, trees are hierarchical data structures.

## Binary Tree
![](https://github.com/dukhniav/prep/blob/master/data-structures/images/binary_tree.jpg)

This is the most basic basic from of tree structure. Where each node can have utmost two children.

A binary tree is made of nodes, where each node contains a "left" pointer, a "right" pointer, and a data element. The "root" pointer points to the topmost node in the tree. The left and right pointers recursively point to smaller "subtrees" on either side. A null pointer represents a binary tree with no elements -- the empty tree. The formal recursive definition is: a binary tree is either empty (represented by a null pointer), or is made of a single node, where the left and right pointers (recursive definition ahead) each point to a **binary tree**. 

The nodes at the bottom edge of the tree have empty subtrees and are called "leaf" nodes (F, G, H, I, J) while the others are "internal" nodes (A, B, C, D, E). 

###  Binary Search Tree Niche
Basically, binary search trees are fast at insert and lookup. The next section presents the code for these two algorithms. On average, a binary search tree algorithm can locate a node in an N node tree in order lg(N) time (log base 2). Therefore, binary search trees are good for "dictionary" problems where the code inserts and looks up information indexed by some key. The lg(N) behavior is the average case -- it's possible for a particular tree to be much slower depending on its shape. 

### Terminology
- The depth of a node is the number of edges from the root to the node.
- The height of a node is the number of edges from the node to the deepest leaf.
- The height of a tree is a height of the root.
- A full binary tree.is a binary tree in which each node has exactly zero or two children.
- A complete binary tree is a binary tree, which is completely filled, with the possible exception of the bottom level, which is filled from left to right. 

#### Complete binary tree
A complete binary tree is very special tree, it provides the best possible ratio between the number of nodes and the height. The height h of a complete binary tree with N nodes is at most O(log N). We can easily prove this by counting nodes on each level, starting with the root, assuming that each level has the maximum number of nodes:

```n = 1 + 2 + 4 + ... + 2h-1 + 2h = 2h+1 - 1```

Solving this with respect to h, we obtain

```h = O(log n)```

where the big-O notation hides some superfluous details. 

### Traversals
- Depth-first traversal
  * PreOrder traversal - visit the parent first and then left and right children;
  * InOrder traversal - visit the left child, then the parent and the right child;
  * PostOrder traversal - visit left child, then the right child and then the parent; 
- Breadth-first traversal
  * There is only one kind of breadth-first traversal--the level order traversal. This traversal visits nodes by levels from top to bottom and from left to right. 

## Binary Search Tree
![](https://github.com/dukhniav/prep/blob/master/data-structures/images/binary_search_tree.jpg)

## AVL Tree/ Height Balanced Binary Tree

## Red-Black Tree
