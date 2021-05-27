import java.util.*;

public class no_of_employees_under_every_manager {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        scn.close();
        
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(scn.next(), scn.next());
        }
        
        findCount(map);
      }
      
      public static void findCount(HashMap<String, String> map) {
          HashMap<String, HashSet<String>> tree = new HashMap<>();
          
          String ceo = "";
          for(String emp: map.keySet()) {
              String manager = map.get(emp);
              
              if(manager.equals(emp))
                ceo = manager;
                
              else {
                  if(tree.containsKey(manager)) { // when the manager is already present in the tree
                      HashSet<String> emps = tree.get(manager);
                      emps.add(emp);
                  }
                  else {
                      HashSet<String> emps = new HashSet<>();
                      emps.add(emp);
                      tree.put(manager, emps); // for a new manager
                  }
              }
          }
          
          HashMap<String, Integer> result = new HashMap<>();
          getSize(tree, ceo, result);
          
          for(String emp : result.keySet())
            System.out.println(emp + " " + result.get(emp));
          
      }
      
      public static int getSize(HashMap<String, HashSet<String>> tree, String manager, HashMap<String, Integer> result) {
          if(!tree.containsKey(manager)) { // base condition
              result.put(manager, 0);
              return 1;
          }
          
          int size = 0;
          for(String emp : tree.get(manager)) 
              size += getSize(tree, emp, result); // counting the number of employees under each manager (Recursive Call)
          
          // Postorder 
          result.put(manager, size); // fills the result with the number of employees under curr manager
          return size + 1; // return the no of employees under the manager which made the recursive call 
      }
    
}