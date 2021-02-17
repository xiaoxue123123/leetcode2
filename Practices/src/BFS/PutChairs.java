package BFS;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PutChairs {
    private static final char EQUIP = 'E';
    private static final char OBS = 'O';
    int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<Integer> putChair(char[][] gym) {
        // Write your solution here
        /**
         use breadth first search to find distance from each equipment to each C
         add those distance to same matrix
         return the spot with smallest total distance

         special cases:
         if there is an equipment that can't be reached by any cell, is equivalent to,
         two equipments can't be reached from each other
         **/
        int m = gym.length;
        int n = gym[0].length;
        int[][] cost = new int[m][n];

        // calculate total shortest dist from every cell to every equip
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == EQUIP) {
                    boolean reachable = BFS(gym, i, j, cost);
                    if (!reachable) {
                        return null;
                    }
                }
            }
        }

        // find the smallest
        List<Integer> result = null;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] != OBS && gym[i][j] != EQUIP) {
                    if (result == null) {
                        result = Arrays.asList(i,j);
                    } else {
                        if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
                            result.set(0,i);
                            result.set(1,j);
                        }
                    }
                }

            }
        }
        return result == null ? Arrays.asList(-1,-1) : result;


    }

    //
    private boolean BFS(char[][] gym, int i, int j, int[][] cost) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(i,j,0));
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int size = q.size();
            for (int[] dir: DIRS) {
                int r = cur.i + dir[0];
                int c = cur.j + dir[1];
                if ( r < 0 || r > gym.length - 1 || c < 0 || c > gym[0].length - 1 ||gym[r][c] == OBS || visited[r][c]) {
                    continue;
                }
                cost[r][c] = cost[r][c] + cur.dist + 1;
                visited[r][c] = true;
                q.offer(new Pair(r, c, cur.dist + 1));
            }
        }

        for (int l = 0; l < gym.length; l++) {
            for (int m = 0; m < gym[0].length; m++) {
                if (!visited[l][m] && gym[l][m] != OBS) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Pair {
        int i;
        int j;
        int dist;
        Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        PutChairs s = new PutChairs();
        char[][] gym = {{'E','C','E','O','C'},
                {'E','O','C','C','E'},
                {'O','O','E','C','C'},
                {'C','O','C','E','E'},
                {'E','C','C','C','C'}};




        List<Integer> l = s.putChair(gym);
        System.out.println(l);
    }

}
