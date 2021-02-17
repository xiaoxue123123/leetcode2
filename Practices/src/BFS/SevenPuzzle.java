//package BFS;
//
//import java.util.ArrayDeque;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Queue;
//
///**
// start: int[] values
// end goal: 0 1 2 3 4 5 6 7
// high level BFS
//
// mid level:
// expand each state, generate the next states, put the next states into a queue
// stop condition: we reach end goal.
// when expand: need to check if this state has been generated before. if so, continue.
// if not, put into queue.
// Data structure:
// hashmap: key board value steps. need to implement hashcode and equal
//
// low level:
// how to generate?
// x x x x
// x 0 x x
// **/
//
//
//public class SevenPuzzle {
//
//    static class Board {
//        final static int R = 2;
//        final static int C = 4;
//
//        private int[][] values = new int[R][C];
//
//        // constructor
//        Board(int[] values) {
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    this.values[i][j] = values[R * i + j];
//                }
//            }
//        }
//
//        // find zero
//        int[] findZero() {
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    if (this.values[i][j] == 0) {
//                        return new int[]{i,j};
//                    }
//                }
//            }
//            return new int[]{-1,-1};
//        }
//
//        // hashcode
//        @Override
//        public int hashCode() {
//            int code = 0;
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    code = code * 10 + this.values[i][j];
//                }
//            }
//            return code;
//        }
//
//
//        // equals
//        @Override
//        public boolean equals(Object o) {
//            if (!(o instanceof Board)) {
//                return false;
//            }
//            Board b = (Board) o;
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    if (this.values[i][j] != b.values[i][j]) {
//                        return false;
//                    };
//                }
//            }
//            return true;
//        }
//
//
//        // swap
//        void swap(int i1, int j1, int i2, int j2) {
//            int value = values[i1][j1];
//            values[i1][j1] = values[i2][j2];
//            values[i2][j2] = value;
//        }
//
//        // out of bound
//        boolean outOfBound(int i, int j) {
//            if (i < 0 || i > R - 1 || j < 0 || j > C - 1) {
//                return true;
//            }
//            return false;
//        }
//
//        @Override
//        public Board clone() {
//            Board res = new Board(new int[]{0,0,0,0,0,0,0,0});
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C;j++) {
//                    res.values[i][j] = values[i][j];
//                }
//            }
//            return res;
//        }
//    }
//
//    final static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
//
//    public int numOfSteps(int[] values) {
//        // initialize queue
//        Queue<Board> q = new ArrayDeque<>();
//        // initialize hashmap
//        Map<Board, Integer> map = new HashMap<>();
//
//        // insert starting point
//        Board start = new Board(new int[]{0,1,2,3,4,5,6,7});
//        q.offer(start);
//        map.put(start, 0);
//        // expand and generate until queue is empty, i.e. all states have been expanded and distance has been calculated
//        while (!q.isEmpty()) {
//            Board cur = q.poll();
//            int[] zeroPos = cur.findZero();
//            int curStep = map.get(cur);
//            for (int[] dir: dirs) {
//                int x = dir[0] + zeroPos[0];
//                int y = dir[1] + zeroPos[1];
//                System.out.println("x: " + x + " y: " + y);
//                System.out.println("cur.outOfBound(x,y)" + cur.outOfBound(x,y));
//                if (!cur.outOfBound(x,y)) {
//                    cur.swap(zeroPos[0], zeroPos[1], x, y);
//                    System.out.println("map size " + map.size());
//                    System.out.println("map.containsKey(cur)" + map.containsKey(cur));
//                    if (!map.containsKey(cur)) {
//                        Board child = cur.clone();
//                        q.offer(child);
//                        map.put(child, curStep + 1);
//                    }
//                    cur.swap(x, y, zeroPos[0], zeroPos[1]);
//                }
//            }
//        }
//
//        System.out.println("map size " + map.size());
//        return map.getOrDefault(new Board(values), -1);
//    }
//
//    public static void main(String[] args) {
//        SevenPuzzle s = new SevenPuzzle();
//        //System.out.println(s.numOfSteps(new int[]{6,7,3,5,4,2,1,0}));
//        System.out.println(s.numOfSteps(new int[]{1,0,2,3,4,5,6,7}));
//
//    }
//
//
//
//
//}


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class SevenPuzzle {

    private final static int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    static class Board {
        private int[][] board = new int[2][3];

        public Board(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    this.board[i][j] = board[i][j];
                }
            }
        }

        public void transit(int i1, int j1, int i2, int j2) {
            int tmp = board[i1][j1];
            board[i1][j1] = board[i2][j2];
            board[i2][j2] = tmp;
        }

        public Board clone(Board b) {
            return new Board(b.board);
        }

        public int[] getZero() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) {
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{-1,-1};
        }

        @Override
        public int hashCode() {
            int code = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    code = code * 10 + board[i][j];
                }
            }
            return code;
        }




        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Board)) {
                return false;
            }
            Board b = (Board) obj;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (this.board[i][j] != b.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public int slidingPuzzle(int[][] board) {
        Queue<Board> q = new ArrayDeque<>();
        HashMap<Board, Integer> map = new HashMap<>();
        Board init = new Board(new int[][]{{1,2,3},{4,5,0}});
        map.put(init, 0);
        q.offer(init);

        while (!q.isEmpty()) {
            Board seed = q.poll();
            int curDist = map.get(seed);
            int[] zeroPos = seed.getZero();
            for (int[] dir: DIRS) {
                int x = zeroPos[0] + dir[0];
                int y = zeroPos[1] + dir[1];
                if (x < 0 || x >= seed.board.length || y < 0 || y >= seed.board[0].length) {
                    continue;
                }
                Board child = new Board(seed.board);
                child.transit(zeroPos[0],zeroPos[1], x, y);
                if (!map.containsKey(child)) {
                    map.put(child, curDist + 1);
                    q.offer(child);
                }
            }
        }
        //System.out.println(board.equals(init));
        return map.getOrDefault(new Board(board), -1);

    }

    public static void main(String[] args) {
        SevenPuzzle s = new SevenPuzzle();
        int n = s.slidingPuzzle(new int[][]{{1,2,3}, {4,0,5}});
        System.out.print(n);
    }
}