package DFS;


public class RandomMaze {
    public int[][] maze(int n) {
        // Write your solution here.
        // initialize maze

        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = 1;
            }
        }
        maze[0][0] = 0;
        generate(0,0,maze);
        return maze;
    }

    private void generate(int i, int j, int[][] maze) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir d: dirs) {
            int x = d.moveX(i, 1);
            int y = d.moveY(j, 1);
            if (x < 0 || x > maze.length - 1 || y < 0 || y > maze[0].length - 1 || maze[x][y] == 0) {
                continue;
            }
            //maze[d.moveX(i,1)][d.moveY(j,1)] = 0;
            maze[x][y] = 0;
            generate(x,y,maze);
        }
    }

    enum Dir {
        NORTH(-1, 0), SOUTH(1, 0), WEST(0, -1), EAST(0, 1);

        int deltaX;
        int deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        // move certain taims of deltaX
        public int moveX(int x, int times) {
            return x + times * deltaX;
        }

        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int) (Math.random() * (dirs.length - i));
            Dir tmp = dirs[i];
            dirs[i] = dirs[index + i];
            dirs[index + i] = tmp;
        }
    }

    public static void main(String[] args) {
        RandomMaze s = new RandomMaze();
        int[][] maze = s.maze(5);
        System.out.println(maze);
    }
}
