/*                                                                          Date: 22-July-2021
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
*/



public class serialize_deserialize_BT {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree into a string doing preorder traversal seperating by ','
    public void serialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(node.val + ",");
        
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); // here string builder is used instead of string to reduce time complexity
        serialize(root, sb);
        return sb.toString();
    }
    
    int i = 0;
    
    public TreeNode deserialize(String[] str) {
        if(i >= str.length || str[i].equals("null")) {
            i++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(str[i++]));
        node.left = deserialize(str);
        node.right = deserialize(str);
        
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        TreeNode root = deserialize(str);
        
        return root;
    }
}
