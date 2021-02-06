/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//DFS + HashMap
//TC: O(N)
//SC: O(N)
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>(); //store the value of distance in hashamp from the all nodes in that path to target
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), result);
        return result;
    }
    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target){
        if(root == null)//base case
            return -1;
        
        if(root == target){ // if root is target, then insert that node and distance as 0 in map
            map.put(root, 0);
            return 0;
        }
        
        int left = find(root.left, target); //recurse on left side, and store the height in map
        if(left >= 0){
            map.put(root, left+1);
            return left+1;
        }
        
        int right = find(root.right, target);//recurse on right side, and store the height in map
        if(right >= 0){
            map.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    
    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res){
        if(root == null)//base case
            return;
        if(map.containsKey(root))
            length = map.get(root);
        if(length == K)
            res.add(root.val);
        
        dfs(root.left, target, K, length+1, res);
        dfs(root.right, target, K, length+1, res);
    }
}