#include <iostream>
//#include <iomanip>

using namespace std;

#include "BST.h"

//--- Definition of constructor
BST::BST()
: myRoot(0)
{}

bool BST::empty() const
{ return myRoot == 0; }


bool BST::search(const int & item) const
{
   BinNode * locptr = myRoot;
   bool found = false;
   while (!found && locptr != 0)
   {
      if (item < locptr->data)       // descend left
        locptr = locptr->left;
      else if (locptr->data < item)  // descend right
        locptr = locptr->right;
      else                           // item found
        found = true;
   }
   return found;
}

void BST::insert(const int & item)
{
   BinNode * locptr = myRoot;   // search pointer
   BinNode * parent = 0;        // pointer to parent of current node
   bool found = false;     // indicates if item already in BST
   while (!found && locptr != 0)
   {
      parent = locptr;
      if (item < locptr->data)       // descend left
         locptr = locptr->left;
      else if (locptr->data < item)  // descend right
         locptr = locptr->right;
      else                           // item found
         found = true;
   }
   if (!found)
   {                                 // construct node containing item
      locptr = new BinNode(item);  
      if (parent == 0)               // empty tree
         myRoot = locptr;
      else if (item < parent->data )  // insert to left of parent
         parent->left = locptr;
      else                           // insert to right of parent
         parent->right = locptr;
   }
   else
      cout << "Item already in the tree\n";
}

void BST::printPreorderTraversal(BinNode * locptr)
{

   if (locptr == NULL) 
        return;

   // first print the current node 
   cout << locptr->data << " ";
  
   // then recur on left subtree
   printPreorderTraversal(locptr->left); 
  
   // next recur on right subtree 
   printPreorderTraversal(locptr->right);
}

void BST::printInorderTraversal(BinNode * locptr)
{
   
   if (locptr == NULL) 
        return;
  
   // first recur on left subtree 
   printInorderTraversal(locptr->left);

   // then print the current node 
   cout << locptr->data << " ";
  
   // then recur on right subtree 
   printInorderTraversal(locptr->right);
}

int BST::printNodeCount(BinNode * locptr)
{
	int count = 0;

   if(locptr == NULL) 
       return 0;
    
   if(locptr || locptr->left || locptr->right){

      count++;

   }       
   
   count += (printNodeCount(locptr->left) +  printNodeCount(locptr->right));

   return count; 
}

void BST::deleteNode(const int & item) 
{
	BinNode * locptr = myRoot;
	BinNode * parent = 0;

	if(item == locptr->data){

		myRoot = NULL;
	}

	while(item != locptr->data){

      	if (item < locptr->data){

      		parent = locptr;
			locptr = locptr->left;

      	}else if(item > locptr->data){

      		parent = locptr;
			locptr = locptr->right;
      	}
    }

    if(locptr->left == NULL && locptr->right == NULL){

      removeLeaf(locptr, parent);
      printInorderTraversal(myRoot); 
    }

    else if(locptr->left == NULL || locptr->right == NULL){

        shortCircuit(locptr, parent);
        printInorderTraversal(myRoot); 
    }
    else{

    	promotion(locptr);
    	printInorderTraversal(myRoot);
    } 
}

void BST::shortCircuit(BinNode * locptr, BinNode * parent){

  if(locptr == myRoot){
    
    if(locptr->left != NULL){

        myRoot = locptr->left;
        delete locptr;

    }else{

        myRoot = locptr->right;
        delete locptr;
    }

  }

  if(locptr == parent->right){

    if(locptr->left != NULL){

      parent->right = locptr->left;
    }else{

      parent->right = locptr->right;
    }

    delete locptr;

  }

  if(locptr == parent->left){

    if(locptr->left != NULL){

      parent->left = locptr->left;
    }else{

      parent->left = locptr->right;
    }

    delete locptr;
  } 
}

void BST::removeLeaf(BinNode * locptr, BinNode * parent){

  if(locptr == myRoot){
      
      locptr = NULL;
  }

  if(locptr == parent->right){

      parent->right = NULL;

  }else {

      parent->left = NULL;
  }

  delete locptr;
}

void BST::promotion(BinNode * locptr){

  if(locptr->right == NULL)
  {
    return;
  }
  
  BinNode * min_right_node = locptr->right;
  BinNode * parent = min_right_node;
    
  while(min_right_node->left != NULL){

  	parent = min_right_node;
    min_right_node = min_right_node->left;
  }

  locptr->data = min_right_node->data;

  if(parent == min_right_node){

  	(min_right_node->left == NULL && min_right_node->right == NULL)? removeLeaf(min_right_node, locptr):shortCircuit(min_right_node, locptr);

  } else{

  	(min_right_node->left == NULL && min_right_node->right == NULL)? removeLeaf(min_right_node, parent):shortCircuit(min_right_node, parent);
  }
}

void BST::insertAVL(const int & item)
{
   BinNode * locptr = myRoot;   // search pointer
   BinNode * parent = 0;        // pointer to parent of current node
   bool found = false;     // indicates if item already in AVL
   while (!found && locptr != 0)
   {
      parent = locptr;
      if (item < locptr->data)       // descend left
         locptr = locptr->left;
      else if (locptr->data < item)  // descend right
         locptr = locptr->right;
      else                           // item found
         found = true;
   }
   if (!found)
   {                                 // construct node containing item
      locptr = new BinNode(item);
      locptr->height = 0; 

      if (parent == 0)               // empty tree
        myRoot = locptr;
      else if (item < parent->data) {	// insert to left of parent

      	parent->left = locptr;
     	if(getHeight(parent->left) - getHeight(parent->right) == 2)
        {
            if(item < parent->left->data){

            	parent = rightRotate(parent);
            }
            else{

            	parent = leftRightRotate(parent);
            }
        }

        parent->height = 1 + (getHeight(parent->left) > getHeight(parent->right)? getHeight(parent->left) : getHeight(parent->right));
      } 
        
      else  {											// insert to right of parent

      		parent->right = locptr;
    	if(getHeight(parent->left) - getHeight(parent->right) == 2)
        {
            if(item < parent->right->data){

            	parent = rightLeftRotate(parent);
            }
            else{

            	parent = leftRotate(parent);
            }
        }

        parent->height = 1 + (getHeight(parent->left) > getHeight(parent->right)? getHeight(parent->left) : getHeight(parent->right));
      }                         
   }
   else
      cout << "Item already in the tree\n";
}

BST::BinNode * BST::rightRotate(BinNode * node){

	BinNode* temp = node->left;
    node->left = temp->right;
    temp->right = node;
    node->height = 1 + (getHeight(node->left) > getHeight(node->right)? getHeight(node->left) : getHeight(node->right));
    temp->height = 1 + (getHeight(temp->left) > getHeight(temp->right)? getHeight(temp->left) : getHeight(temp->right));
    return temp;
}

BST::BinNode* BST::leftRightRotate(BinNode * node){

	node->left = leftRotate(node->left);  
    return rightRotate(node);
}

BST::BinNode * BST::leftRotate(BinNode * node){

	BinNode* temp = node->right;
    node->right = temp->left;
    temp->left = node;
    node->height = 1 + (getHeight(node->left) > getHeight(node->right)? getHeight(node->left) : getHeight(node->right));
    temp->height = 1 + (getHeight(temp->left) > getHeight(temp->right)? getHeight(temp->left) : getHeight(temp->right));
    return temp;
}

BST::BinNode * BST::rightLeftRotate(BinNode * node){

	node->right = rightRotate(node->right);  
    return leftRotate(node);
}

int BST::getHeight(BinNode * node){

	return (node != NULL)? node->height : -1;
}

void BST::deleteAVLNode(const int & item) 
{
	BinNode * locptr = myRoot;
	BinNode * parent = 0;

	if(item == locptr->data){

		myRoot = NULL;
	}

	while(item != locptr->data){

      	if (item < locptr->data){

      		parent = locptr;
			locptr = locptr->left;

      	}else if(item > locptr->data){

      		parent = locptr;
			locptr = locptr->right;
      	}
    }

    if(locptr->left == NULL && locptr->right == NULL){

      removeLeaf(locptr, parent);
      //printInorderTraversal(myRoot); 
    }

    else if(locptr->left == NULL || locptr->right == NULL){

        shortCircuit(locptr, parent);
        //printInorderTraversal(myRoot); 
    }
    else{

    	promotion(locptr);
    	//printInorderTraversal(myRoot);
    }

    locptr->height = 1 + (getHeight(locptr->left) > getHeight(locptr->right)? getHeight(locptr->left) : getHeight(locptr->right));

    if(getHeight(locptr->left) - getHeight(locptr->right) == 2){
            
        if(getHeight(locptr->left->left) - getHeight(locptr->left->right) >= 0){

           	locptr = rightRotate(locptr);
        }
        else{

           	locptr = leftRightRotate(locptr);
        }
    } else if(getHeight(locptr->left) - getHeight(locptr->right) == -2){

    	if(getHeight(locptr->right->left) - getHeight(locptr->right->right) < 0){

           	locptr = leftRotate(locptr);
        }
        else{

           	locptr = rightLeftRotate(locptr);
        }
    }

    printInorderTraversal(myRoot);
}