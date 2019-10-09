/*
238. Product of Array Except Self
Medium

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/
class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int num : nums) {
            product *= num;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[i] = product / nums[i];
            } else {
                int tmp = 1;
                for (int j = 0; j < i; j++) {
                    tmp *= nums[j];
                }
                for (int j = i + 1; j < nums.length; j++) {
                    tmp *= nums[j];
                }
                res[i] = tmp;
            }
        }
        return res;
    }
}