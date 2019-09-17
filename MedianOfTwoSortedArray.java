class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }

        PriorityQueue<Integer> nums = new PriorityQueue<>();
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        for (int i = 0; i < len1; i++) {
            nums.add(nums1[i]);
        }
        for (int i = 0; i < len2; i++) {
            nums.add(nums2[i]);
        }
        int len = nums.size();
        if (len == 1) {
            return nums.poll() + 0.0;
        }
        boolean isEven = len % 2 == 0;
        int mid = len/2;
        double res = 0.0;
        for (int i = 0; i < mid; i++) {
            res = nums.poll() + 0.0;
        }
        if (!isEven) {
            return nums.poll() + 0.0;
        } else {
            return (res + nums.poll())/2.0;
        }
    }
}