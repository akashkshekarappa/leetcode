            return null;
        
        if(key > root.val)// delete from the right subtree
            root.right = deleteNode(root.right, key);
        
        else if(key < root.val) // delete from the left subtree
            root.left = deleteNode(root.left, key);
        
        else{   //delete the current node
            if(root.left == null && root.right == null)//the node is a leaf
                root = null;
            
            else if(root.right != null){// the node is not a leaf and has a right child
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            
            else{// the node is not a leaf, has no right child, and has a left child 
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    private int successor(TreeNode root){
        root = root.right;
        while(root.left != null)
            root = root.left;
        return root.val;
    }
    
    private int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null)
            root = root.right;
        return root.val;
    }
}
