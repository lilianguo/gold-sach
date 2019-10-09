/*
407. Trapping Rain Water II
Hard

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
compute the volume of water it is able to trap after raining.

 

Note:

Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

 

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

*/


/*
What determines the amount of water can a bar can hold? It is the min height of the max heights along all paths to the boundary 
(not just 4 direction!!!, which was my first intuition) 
Look at the example below. If we add 2 units of water into the 1 in the center, it will overflow to 0.
0 0 3 0 0
0 0 2 0 0
3 2 1 2 3
0 0 2 0 0
0 0 3 0 0

Just like 1-D two pointer approach, we need to find some boundary. 
Because all boundary cells cannot hold any water for sure, we use them as the initial boundary naturally.

Then which bar to start? 
Find the min bar (let's call it A) on the boundary (heap is a natural choice), 
then do 1 BFS (4 directions).
Why BFS? 
Because we are sure that the amount of water that A's neighbors can hold is only determined by A now for the same reason in 1D two-pointer approach.

How to update the heap during BFS
Step 1. Remove the min bar A from the heap
Step 2. If A's neighbor B's height is higher, it cannot hold any water. Add it to the heap
Step 3. If B's height is lower, it can hold water and the amount of water should be height_A - height_B. Here comes the tricky part, 
we still add B's coordinate into the heap, BUT change its height to A's height because A is the max value along this path 
(for this reason we cannot just use heightMap and need a class/array to store it's coordinates and UPDATED height). 
And we can think of B as a replacement of A now and never worry about A again. Therefore a new boundary is formed and we can repeat this process again

*/
class TrappingRainWaterII {
    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heights[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
                }
            }
        }
        
        return res;
    }
}