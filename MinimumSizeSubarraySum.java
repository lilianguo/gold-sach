class MinimumSizeSubarraySum {
    // 209. Minimum Size Subarray Sum
    // prefix sum
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] pSum = new int[nums.length + 1];
        pSum[0] = 0;
        pSum[1] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            pSum[i] = pSum[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            if (pSum[i] < s) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                int currSum = pSum[i] - pSum[j];
                if (currSum >= s) {
                    min = Math.min(min, i - j);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // two pointers + binary search
    public int minSubArrayLenII(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int res = Integer.MAX_VALUE;
        // 双闭区间
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while(sum >= s) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}