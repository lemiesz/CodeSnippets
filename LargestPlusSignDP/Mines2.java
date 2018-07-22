import java.util.Arrays;

import javax.management.MBeanOperationInfo;

public class Mines2 {

    public static void main(String[] args) {
        final Mines2 mines = new Mines2();
        System.out.println(mines.orderOfLargestPlusSign(5, null));
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = buildGrid(N, mines);
        Integer[][] memo = new Integer[grid.length][grid.length];
        int result = _findSolution(1, 1, grid, memo);
        return result;
    }

    private int _findSolution(int i, int j, int[][] grid, Integer[][] memo) {
        if (i == 0 || i == grid.length - 1) {
            return grid[i][j];
        }

        if (j == 0 || j == grid.length - 1) {
            return grid[i][j];
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        memo[i + 1][j] = memo[i + 1][j] == null ? _findSolution(i + 1, j, grid, memo) : memo[i + 1][j];
        memo[i][j + 1] = memo[i][j + 1] == null ? _findSolution(i, j + 1, grid, memo) : memo[i][j + 1];
        memo[i - 1][j] = memo[i - 1][j] == null ? _findSolution(i - 1, j, grid, memo) : memo[i - 1][j];
        memo[i][j - 1] = memo[i][j - 1] == null ? _findSolution(i, j - 1, grid, memo) : memo[i][j - 1];

        return min(memo[i + 1][j], memo[i][j + 1], memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
    }

    private static Integer min(int... args) {
        int result = args[0];
        for (Integer item : args) {
            result = Math.min(result, item);
        }
        return result;
    }

    private static void printArray(Integer[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
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