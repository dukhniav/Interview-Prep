# Tree implementation

## Traversal implementation

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
