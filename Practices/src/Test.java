import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//        map.put(1, new HashMap<>());
//        map.get(1).put(2, 3);
//        map.get(1).put(3, 4);
//
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        //Create the graph from input edges
        int[][] edges = {{1,2,3}, {1,3,3}, {1,2,5}, {1,5,5}};
        for(int[] e : edges){
            graph.putIfAbsent(e[0], new HashMap<>());
            graph.putIfAbsent(e[1], new HashMap<>());
            graph.get(e[0]).put(e[1],e[2]);
            graph.get(e[1]).put(e[0],e[2]);

        }
        System.out.println(graph.get(1));



    }
}
