class ShortestSubarrayWithSumK {
    // TLE
    public int shortestSubarray(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] pSum = new int[nums.length + 1];
        pSum[0] = 0;
        pSum[1] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            pSum[i] = pSum[i - 1] + nums[i - 1];
            //System.out.println("pSum[i] : " + pSum[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int currSum = pSum[i] - pSum[j];
                if (currSum >= s) {
                    min = Math.min(min, i - j);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}