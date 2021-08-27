public class verify_preorder_serialization {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int vacancy = 1; // initially vacancy is because of root element 
        
        for(String node : nodes) {
            vacancy--;
            
            if(vacancy < 0) // if at anytime vacancy reaches negative value that means tree is not possible
                return false;
            
            if(!node.equals("#")) // for non null nodes, it creates 2 vacancies in BT left and right
                vacancy +=2;
        }
        
        return (vacancy == 0); // for a valid tree vacancy must be zero in the end
    }
    
    // Time complexity = O(n)
    // Space complexity = O(1)
}