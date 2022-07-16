package DP.ZeroOnePackage;

/*
    dp[i][j + sum] = dp[i - 1][j + sum - nums[i]] + dp[i - 1][j + sum + nums[i]]
 */

public class TargetSum_494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays_1(nums, target));
    }

    public static int findTargetSumWays_1(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int range = 2 * sum + 1;
        int[][] dp = new int[length][range];
        //init
        dp[0][sum - nums[0]] += 1;
        dp[0][sum + nums[0]] += 1;

        for (int i = 1; i < length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j + nums[i] > sum) {
                    dp[i][j + sum] = dp[i - 1][j + sum - nums[i]];
                } else if (j - nums[i] < -sum) {
                    dp[i][j + sum] = dp[i - 1][j + sum + nums[i]];
                } else {
                    dp[i][j + sum] = dp[i - 1][j + sum - nums[i]] + dp[i - 1][j + sum + nums[i]];
                }
            }
        }

        return dp[length - 1][sum + target];
    }
}
