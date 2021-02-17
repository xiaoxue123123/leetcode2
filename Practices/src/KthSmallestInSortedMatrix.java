import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    static class Cell {
        int row;
        int column;
        int value;
        Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int rows= matrix.length;
        int columns = matrix[0].length;

        /**
         * 如果是自定义的 class，需要pass进去一个Comparator
         * **/
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        /** ith iteration：
         * poll ith smallest number
         * add i + 1 th neigbors
         * --> so after k - 1 th iterations, 直接peek就可以得到 kth smallest number
         * **/
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column,
                        matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }

            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1,
                        matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;

    }
}
