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
//TC: O(n logn)
//S: O(n)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //base case
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(root);    //initially adding root in queue
        col.add(0); //initially adding root in queue and min and max will be 0
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int colValue = col.poll();
            
            if(!map.containsKey(colValue)){
                map.put(colValue, new ArrayList<>());
            }
            map.get(colValue).add(curr.val);
            
            
            if(curr.left != null){
                q.add(curr.left);
                col.add(colValue -1);
                min = Math.min(min, colValue -1);
            }
            
            if(curr.right != null){
                q.add(curr.right);
                col.add(colValue +1);
                max = Math.max(max, colValue +1);
            }
        }
        for(int i= min; i<=max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}