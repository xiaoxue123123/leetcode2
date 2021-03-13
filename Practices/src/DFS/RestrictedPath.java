//package DFS;
//
//import BFS.PutChairs;
//
//import java.util.*;
//
//public class RestrictedPath {
//    Map<Integer, HashMap<Integer,Integer>> g;
//    Map<Integer, Integer> dist;
//    int ans = 0;
//
//    public int countRestrictedPaths(int n, int[][] edges) {
//
//        g = new HashMap<>();
//        dist = new HashMap<>();
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//
//        buildGraph(edges, g);
//        minDist(g, dist, n);
//        //System.out.println('1');
//        Set<Integer> set = new HashSet<>();
//        int ans = dfs(g, dist, n, 1, dp);
//        System.out.println(dp[1] + " " + dp[2] + " " + dp[3] + " " + dp[4]);
//        return ans;
//
//    }
//
//    private int dfs(Map<Integer, HashMap<Integer, Integer>> g, Map<Integer, Integer> dist, int start, int end, int[] dp) {
//
//        if (start == end) {
//            return 1;
//        }
//
//        if (dp[end] >= 0) {
//            return dp[end];
//        }
//
//        int ans = 0;
//        // System.out.println("end " + end + " dist.get(end) " + dist.get(end));
//        for (int nei: g.get(start).keySet()) {
//
//            if (dist.get(end) > dist.get(nei)) {
//                System.out.println(dist.get(end));
//                ans = (ans + dfs(g, dist, start, nei, dp));
//            }
//        }
//
//        dp[end] = ans;
//        return dp[end];
//    }
//
//    private void minDist(Map<Integer, HashMap<Integer, Integer>> g, Map<Integer, Integer> dist, int n) {
//        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
//        pq.offer(new Pair(n, 0));
//        Set<Integer> set = new HashSet<>();
//        while (!pq.isEmpty()) {
//            Pair<Integer, Integer> cur = pq.poll();
//            if (set.contains(cur.getKey())) {
//                continue;
//            }
//            set.add(cur.getKey());
//            Map<Integer, Integer> neighbors = g.get(cur.getKey());
//            for (int nei: neighbors.keySet()) {
//                int newDist = neighbors.get(nei) + cur.getValue();
//                pq.offer(new Pair(nei, newDist));
//                dist.putIfAbsent(nei, Integer.MAX_VALUE);
//                if (newDist < dist.get(nei)) {
//                    dist.put(nei, newDist);
//                }
//            }
//        }
//    }
//
//    private void buildGraph(int[][] edges, Map<Integer,HashMap<Integer,Integer>> g) {
//        for (int[] arr: edges) {
//            int one = arr[0];
//            int two = arr[1];
//            int d = arr[2];
//            g.putIfAbsent(one, new HashMap<>());
//            g.get(one).put(two, d);
//            g.putIfAbsent(two, new HashMap<>());
//            g.get(two).put(one, d);
//        }
//    }
//
//
//}
