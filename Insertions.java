  class Solution {
    int[][] dp;

    public int minInsertions(String s1) {
        int len = s1.length();
        dp = new int[len][len];

        // Initialize DP array with -1
        for (int[] row : dp) Arrays.fill(row, -1);

        String s2 = new StringBuilder(s1).reverse().toString();

        // Minimum insertions = total length - longest palindromic subsequence
        return len - getAnsFor(s1, s2, len - 1, len - 1);
    }

    // Top-down LCS computation
    int getAnsFor(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + getAnsFor(s1, s2, i - 1, j - 1);
        } else {
            return dp[i][j] = Math.max(getAnsFor(s1, s2, i - 1, j), getAnsFor(s1, s2, i, j - 1));
        }
    }
}