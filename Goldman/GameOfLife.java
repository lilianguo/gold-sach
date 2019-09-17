class GameOfLife {
    // 289. Game of Life
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = getLiveCount(i, j, tmp);
                if (tmp[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                } else {
                    if (liveCount == 2 || liveCount == 3) {
                        board[i][j] = 1;
                        continue;
                    }
                    board[i][j] = 0;
                }
            }
        }
        return;
    }

    private int getLiveCount(int x, int y, int[][] board) {
        int[] dx = new int[] {1,1,0,-1,-1,-1,0,1};
        int[] dy = new int[] {0,1,1,1,0,-1,-1,-1};
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && board[xx][yy] == 1) {
                count++;
            }
        }
        return count;
    }
}