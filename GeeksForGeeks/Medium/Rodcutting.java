class Solution {
    int[] dp;

    public int cutRod(int price[]) {
        int n = price.length;
        dp = new int[n + 1];
        return solve(price, n);
    }

    private int solve(int[] price, int n) {
        if (n == 0) return 0;

        if (dp[n] != 0) return dp[n];

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, price[i - 1] + solve(price, n - i));
        }

        return dp[n] = max;
    }
}
