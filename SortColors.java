class SortColors {
    // 75. Sort Colors
    // https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0; 
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0) {
                swap(nums, i, start++);
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, end--);
                i--;
                continue;
            }
        }
        return;
    }
    
    private void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        return;
    }
}