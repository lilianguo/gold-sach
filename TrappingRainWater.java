public class TrappingRainWater {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;
        while (left < right) {
            // a right wall exist to trap water from left
            if (height[left] < height[right]) {
                if (height[left] > left_max ) {
                    left_max = height[left];
                } else {
                    res += left_max - height[left];
                }
                ++left;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    res += right_max - height[right];
                }
                --right;
            }
        }
        return res;
    }
}