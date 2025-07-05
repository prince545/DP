import java.util.Arrays;

class Solution {
    public int matrixChainMemoized(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Initialize all entries with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, 1, n - 1, dp); // Start from index 1 to n-1
    }

    private int solve(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int left = solve(arr, i, k, dp);
            int right = solve(arr, k + 1, j, dp);
            int cost = arr[i - 1] * arr[k] * arr[j] + left + right;

            min = Math.min(min, cost);
        }

        dp[i][j] = min;
        return min;
    }
}
