## Binary Search Trees

### problem-definition

```
Consider the BST.h, BST.cpp and treetester.cpp files provided to you. 
These files only contain the insert, search and empty member functions. 
Please make any changes necessary to compile and run the code.

Problem 1: 

Write new member functions called
a. preOrder() that implements the preorder traversal algorithm of a binary search tree. 
Your member function should display each node’s data on the screen.
b. inOrder() that implements the inorder traversal algorithm of a binary search tree. 
Your member function should display each node’s data on the screen.
c. nodeCount() to count the number of nodes in a binary search tree. 
In this function, you should use a recursive function. You can’t just use a variable such as “mySize”.

Problem 2: 

In this problem, you will write the delete member function to delete a node from a BST. 
Recall that to delete a node from a BST you need to consider the three cases that we discussed in class.
a. The node has no children (easiest case) 
b. The node has only one child (easy case) 
c. The node has two children (hard case)

Problem 3:
Modify the provided files and write additional methods to the class and 
convert the Binary Search Tree to an AVL tree. 
Note that the tree should be balanced both after insertion and deletion.

```

## instructions to compile

```
g++ -g treetester.cpp BST.cpp BST.h
```
