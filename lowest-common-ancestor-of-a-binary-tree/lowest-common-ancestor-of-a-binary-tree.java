        //action
        if(root != null){
            path.add(root);
            //recurse
            backtrack(root.left, p, path);
            if(path.get(path.size()-1) == p)
                return;
​
            backtrack(root.right, p, path);
            if(path.get(path.size()-1) == p)
                return;
​
            //backtrack
            path.remove(path.size()-1);
        }
    }
}
​
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root== null || root == p || root == q)
            return root;
        
        //recursively calling inorder traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        
        if(left==null) return right;
        if(right==null) return left;
        
        return root;
        
    }
​
*/
