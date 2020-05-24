#include <iostream>
using namespace std;  

#ifndef BINARY_SEARCH_TREE
#define BINARY_SEARCH_TREE

class BST
{
  
 private:
  /***** Node class *****/
  class BinNode 
  {
   public:
    int data;
    BinNode * left;
    BinNode * right;
    BinNode * parent;
    int height;

    // BinNode constructors
    // Default -- data part is default int value; both links are null.
    BinNode()
    : left(0), right(0)
    {}

    // Explicit Value -- data part contains item; both links are null.
    BinNode(int item)
    : data(item), left(0), right(0)
    {}
 
  };// end of class BinNode declaration
  
  /***** Data Members *****/
  BinNode * myRoot;
  public:
  /***** Function Members *****/
  BST();
  bool empty() const;
  bool search(const int & item) const; 
  void insert(const int & item);
  void insertAVL(const int & item);
  void printTraversals();
  void printPreorderTraversal(BinNode *);
  void printInorderTraversal(BinNode *);
  int printNodeCount(BinNode *);
  void deleteNode(const int & item);
  void deleteAVLNode(const int & item);
  void shortCircuit(BinNode *, BinNode *);
  void removeLeaf(BinNode *, BinNode *);
  void getSmallestRightNode(BinNode *);
  BinNode * getRoot(){

    return myRoot;
  }
  void promotion(BinNode *);
  BinNode * leftRotate(BinNode *);
  BinNode * leftRightRotate(BinNode *);
  BinNode * rightRotate(BinNode *);
  BinNode * rightLeftRotate(BinNode *);
  int getHeight(BinNode *);


}; // end of class declaration

#endif
