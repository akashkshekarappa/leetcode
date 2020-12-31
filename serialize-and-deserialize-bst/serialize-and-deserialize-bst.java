/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
​
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //base case
        if(root == null)
            return "Fun,";   //, is a delimiter, distinguisg between "123" where boundary is confusing and "1,2,3" where 1 is root 2 is left child and 3 is right child
        
        //logic
        //return preorder traversal
        return root.val + "," + serialize(root.left) + serialize(root.right);
   
    }
​
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String encoded = data.substring(0, data.length() -1);   //ignores the last 
        String[] nodes = encoded.split(",");
        Queue<String> unprocessesNodes = new LinkedList<>(Arrays.asList(nodes));    //using a queue coz of preorder
        return deserializeUtil(unprocessesNodes);
    }
    
    private TreeNode deserializeUtil(Queue<String> unprocessesNodes){
        String front = unprocessesNodes.poll();
        //base case
        if(front.equals("Fun"))
            return null;
        
        //logic
        //build root which is the 1st element in q as it has preorder
        TreeNode root = new TreeNode(Integer.valueOf(front));
        
        //recurse
        root.left = deserializeUtil(unprocessesNodes);
        root.right = deserializeUtil(unprocessesNodes);
        
        return root;
    }
}
​
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
