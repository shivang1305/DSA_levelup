// Leetcode HARD (Que. 815)

import java.util.*;


public class bus_routes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // this will store buses number corresponding to each bus stop or buses number passing from each bus stop
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); 
        
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                int busStop = routes[i][j];
                
                ArrayList<Integer> buses = map.getOrDefault(busStop, new ArrayList<>());
                buses.add(i);
                
                map.put(busStop, buses);
            }
        }
        
        HashSet<Integer> visBusStops = new HashSet<>(); // visited bus stops
        HashSet<Integer> visBuses = new HashSet<>(); // visited bus numbers
        
        Queue<Integer> que = new ArrayDeque<>(); // it will contain the bus stops starting from source to target
        que.add(source);
        
        visBusStops.add(source); // mark the source bus stop
        int level = 0; // it resembles the number of buses changed while going from source to target
        // After each level of BFS we change the bus in the route
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            while(size-- > 0) { // level wise BFS
                int rem = que.remove();
                
                if(rem == target) // when we reach the destination stop
                    return level; 
                
                for(int bus : map.get(rem)) { // get that which buses are passing from the curr stop
                    if(!visBuses.contains(bus)) { // if that bus is not boarded already in past
                        visBuses.add(bus); // board that bus
                        
                        int[] busStops = routes[bus]; // get the route of currently boarded bus
                        
                        for(int b : busStops) {
                            if(!visBusStops.contains(b)) { // if that stop is not visited in our route
                                visBusStops.add(b); // visit that bus stop
                                que.add(b); // add into the queue
                            }
                        }
                    }
                }
            }
            level++; // change the bus
        }
        
        return -1;
    }
    
    // Time compleity = O(V + E) i.e. time of single BFS
    // Space complexity = O(4V) , map, 2 hashsets & queue
}