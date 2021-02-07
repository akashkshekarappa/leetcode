/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Recursive Approach
//TC: O(N^2), (Not sure)
//SC: O(N)
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }
    private List<TreeNode> buildTree(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        
        if(start > end){    //base conditions
            result.add(null);
            return result;
        }
        
        if(start == end){   //base conditions
            result.add(new TreeNode(start));
            return result;
        }
        
        List<TreeNode> left, right;
        for(int i=start; i<=end; i++){
            left = buildTree(start, i-1);
            right = buildTree(i+1, end);
            
            for(TreeNode lnode: left){
                for(TreeNode rnode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}

/*
I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n. So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1), and the right subtree will contain elements (i+1) to n. I use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible ways with the root.
*/