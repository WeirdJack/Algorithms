/*----- treetester.cpp -----------------------------------------------------
                Program for testing BST.
 ------------------------------------------------------------------------*/
#include <iostream>
using namespace std;

#include "BST.h"

int main()
{
   // Testing Constructor and empty()
   BST intBST, intAVL;            // test the class constructor
   cout << "Constructing empty BST\n";
   cout << "BST " << (intBST.empty() ? "is" : "is not") << " empty\n";

   // Testing insert
   cout << "\nNow insert a bunch of integers into the BST."
           "\nTry items not in the BST and some that are in it:\n";
   int number;
   for (;;)
   {
      cout << "Item to insert (-999 to stop): ";
      cin >> number;
      if (number == -999) break;
      intBST.insert(number);
   }
   cout << "BST " << (intBST.empty() ? "is" : "is not") << " empty\n";

   // Testing search()
   cout << "\n\nNow testing the search() operation."
           "\nTry both items in the BST and some not in it:\n";
   for (;;)
   {
      cout << "Item to find (-999 to stop): ";
      cin >> number;
      if (number == -999) break;
      cout << (intBST.search(number) ? "Found" : "Not found") << endl;
   }

   // Testing Preorder()
   cout << "\nNow testing the Preorder() operation.\n";
   cout << "\nPreorder: ";
   intBST.printPreorderTraversal(intBST.getRoot());

   // Testing Inorder()
   cout << "\nNow testing the Inorder() operation.\n";
   cout << "\nInorder: ";
   intBST.printInorderTraversal(intBST.getRoot());

   // Testing Node Count()
   cout << "\nNow testing the node count.\n";
   cout << "\nCount: " << intBST.printNodeCount(intBST.getRoot()) << "\n";

   // Testing Delete()
   cout << "\nNow testing the delete() operation.\n";
   cout << "Item to delete: ";
   cin >> number;
   if(intBST.search(number)){

      cout << "\nItem Found\n";
      intBST.deleteNode(number);

   } else{

      cout << "\nItem Not Found\n";
   }

   cout << "Constructing empty AVL\n";
   cout << "AVL " << (intAVL.empty() ? "is" : "is not") << " empty\n";

   // Testing insert
   cout << "\nNow insert a bunch of integers into the AVL."
           "\nTry items not in the AVL and some that are in it:\n";
   for (;;)
   {
      cout << "Item to insert (-999 to stop): ";
      cin >> number;
      if (number == -999) break;
      intAVL.insertAVL(number);
   }
   cout << "AVL " << (intAVL.empty() ? "is" : "is not") << " empty\n";
   intAVL.printInorderTraversal(intAVL.getRoot());
   // Testing Delete()
   cout << "\nNow testing the delete() operation.\n";
   cout << "Item to delete: ";
   cin >> number;
   if(intAVL.search(number)){

      cout << "\nItem Found\n";
      intAVL.deleteAVLNode(number);

   } else{

      cout << "\nItem Not Found\n";
   }

}
