class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0; 
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 2) {
                swap(nums, end--, i);
                i--;
                continue;
            }
            if (nums[i] == 0) {
                swap(nums, start++, i);
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