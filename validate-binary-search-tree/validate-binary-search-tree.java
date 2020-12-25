                root = root.left;
            }
            root = stack.pop();
​
​
            if(prev != null && prev.val >= root.val)    //If next element in inorder traversal is smaller than the previous one that's not BST.
                return false;
​
            prev = root;
            root = root.right;
        }
        return true;
    }
}
​
//Recursive inorder approach
    /*public class Validate_Binary_Search_Tree {
        static TreeNode prev = null;
        public static boolean isValidBST(TreeNode root) {
            if(root == null)
                return true;
            return inOrder(root);   
        }
        private static boolean inOrder(TreeNode root){
            if(root == null)
                return true;
​
            if(inOrder(root.left) == false) // if left subtree is not a BST
                return false;
​
            if(prev != null && prev.val >= root.val)
                return false;
​
            prev = root;
​
            return inOrder(root.right);
        }*/
​
