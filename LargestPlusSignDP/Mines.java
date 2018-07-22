import java.util.Arrays;

public class Mines {

    public static void main(String[] args) {
        final Mines mines = new Mines();
        System.out.println(mines.orderOfLargestPlusSign(10, null));
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = buildGrid(N, mines);
        int result = _findSolution(grid);
        return result;
    }

    private int _findSolution(int[][] grid) {
        int[][] DP = new int[grid.length][grid.length];
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            DP[i][0] = grid[i][0];
            DP[i][grid.length - 1] = grid[i][grid.length - 1];
            DP[0][i] = grid[0][i];
            DP[grid.length - 1][i] = grid[grid.length - 1][i];
        }

        for (int i = 1; i < (grid.length - 1); i++) {
            for (int j = 1; j < (grid.length - 1); j++) {
                if (grid[i][j] == 0) {
                    DP[i][j] = 0;
                } else {
                    DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1]) + 1;
                }
            }

            for (int j = grid.length - 2; j <= 0 ; j--) {
                if (grid[i][j] == 0) {
                    DP[i][j] = 0;
                } else {
                    DP[i][j] = Math.min(DP[i - 1][j], DP[i][j + 1]) + 1;
                }
            }
        }

        for (int j = 1; j < (grid.length - 1); j++) {
            for (int i = 1; i < (grid.length - 1); i++) {
                if (grid[i][j] == 0) {
                    DP[i][j] = 0;
                } else {
                    DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1]) + 1;
                }
            }

            for (int i = grid.length - 2; i <= 0 ; i--) {
                if (grid[i][j] == 0) {
                    DP[i][j] = 0;
                } else {
                    DP[i][j] = Math.min(DP[i][j - 1], DP[i + 1][j]) + 1;
                }
            }
        }

        printArray(DP);

        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP.length; j++) {
                max = Math.max(DP[i][j], max);
            }
        }

        return max;
    }

    private static void printArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private static doesNotEqual(int compare, int... args) {
        boolean result = true;
        for(int curr : args) {
            result = compare != curr;  
        }
        return result;
    }

    private int[][] buildGrid(int N, int[][] mines) {
        final int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 1;
            }
        }

        if (mines == null) {
            return grid;
        }

        for (int i = 0; i < mines.length; i++) {
            int[] coord = mines[i];
            grid[coord[0]][coord[1]] = 0;
        }
        return grid;
    }
}