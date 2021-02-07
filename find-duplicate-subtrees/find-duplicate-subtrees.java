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

//Preorder traversal and serialization,
//Save into map and check duplicates. Add to result list when appears twice
class Solution {
    Map<String, Integer> map;
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        preOrderSerialize(root);
        return result;
    }
    private String preOrderSerialize(TreeNode root){
        if(root == null)    //serialize
            return "foo";
        
        String serial = root.val + "," + preOrderSerialize(root.left) + "," + preOrderSerialize(root.right);
        
        map.put(serial, map.getOrDefault(serial, 0) +1);
        
        if(map.get(serial) == 2)
            result.add(root);
        
        return serial;
    }
}