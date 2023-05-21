//1799. Maximize Score After N Operations

class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length / 2;
        int[][] dp = new int[n][1 << (2 * n)];
        
       
        for (int mask = 0; mask < (1 << (2 * n)); mask++) {
            int score = 0;
            for (int i = 0; i < 2 * n; i++) {
                if ((mask & (1 << i)) != 0) {
                    score++;
                }
            }
            if (score == 2) {
                for (int i = 0; i < 2 * n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        for (int j = i + 1; j < 2 * n; j++) {
                            if ((mask & (1 << j)) != 0) {
                                dp[0][mask] = Math.max(dp[0][mask], gcd(nums[i], nums[j]));
                            }
                        }
                    }
                }
            }
        }
        
       
        for (int i = 1; i < n; i++) {
            for (int mask = 0; mask < (1 << (2 * n)); mask++) {
                for (int x = 0; x < 2 * n; x++) {
                    if ((mask & (1 << x)) != 0) {
                        for (int y = x + 1; y < 2 * n; y++) {
                            if ((mask & (1 << y)) != 0) {
                                int k = i + 1;
                                dp[i][mask] = Math.max(dp[i][mask], dp[i - 1][mask ^ (1 << x) ^ (1 << y)] + k * gcd(nums[x], nums[y]));
                            }
                        }
                    }
                }
            }
        }
        
        
        int maxScore = 0;
        for (int mask = 0; mask < (1 << (2 * n)); mask++) {
            maxScore = Math.max(maxScore, dp[n - 1][mask]);
        }
        return maxScore;
    }
    
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
