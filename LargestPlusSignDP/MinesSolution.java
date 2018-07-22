import java.util.HashSet;
import java.util.Set;

public class MinesSolution {

    public static void main(String[] args) {
        final Mines2 mines = new Mines2();
        System.out.println(mines.orderOfLargestPlusSign(10, null));
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> baned = new HashSet<>();
        int[][] dp = new int[N][N];

        for(int[] mine: mines) {
            baned.add(mine[0] * N + mine[1]);
        }

        int ans = 0, count;

        for(int r = 0; r < N; r++) {
            count = 0;
            for(int c = 0; c < N; c++) {
                count = baned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for(int c = N - 1; c >= 0; c --) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for(int c = 0; c < N; c++) {
            count = 0;
            for(int r = 0; r < N; r++) {
                count = baned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for(int r = N - 1; r >= 0; r--) {
                count = banned.contains(r * N +c) ? 0  : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }

        return ans;
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