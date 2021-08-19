import java.util.*;


public class serialize_deserialize_generic_tree {
    static class Node {
        public int val;
        public ArrayList<Node> children;
    
        public Node() {
          children = new ArrayList<Node>();
        }
    
        public Node(int _val) {
          val = _val;
          children = new ArrayList<Node>();
        }
    
        public Node(int _val, ArrayList<Node> _children) {
          val = _val;
          children = _children;
        }
    }
    
      // Encodes a tree into a string doing preorder traversal seperating by ','
        public static void serialize(Node node, StringBuilder sb) {
            
            sb.append(node.val + ",");
            
            for(Node child : node.children)
                serialize(child, sb);
                
            sb.append("null,");
        }
    
        // Encodes a tree to a single string.
        public static String serialize(Node root) {
            StringBuilder sb = new StringBuilder(); // here string builder is used instead of string to reduce time complexity
            serialize(root, sb);
            return sb.toString();
        }
    
        // Decodes your encoded data to tree.
        public static Node deserialize(String data) {
            if(data.length() == 0)
                return null;
            
            String[] str = data.split(",");
            Stack<Node> st = new Stack<>();
            
            for(int i = 0; i < str.length - 1; i++) {
                String s = str[i];
                if(s.equals("null")) {
                    Node node = st.pop();
                    st.peek().children.add(node);
                }
                
                else {
                    Node node = new Node(Integer.parseInt(s));
                    st.push(node);
                }
            }
            
            return st.pop();
        }
}
