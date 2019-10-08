import java.util.Deque;
/*
862. Shortest Subarray with Sum at Least K
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.

 

Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3
 

Note:

1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9
*/
class ShortestSubarrayWithSumK {
    // sliding window
    /*
    We can rephrase this as a problem about the prefix sums of A. Let P[i] = A[0] + A[1] + ... + A[i-1]. 
    We want the smallest y-x such that y > x and P[y] - P[x] >= K.

    Motivated by that equation, let opt(y) be the largest x such that P[x] <= P[y] - K. We need two key observations:

    If x1 < x2 and P[x2] <= P[x1], then opt(y) can never be x1, 
    as if P[x1] <= P[y] - K, then P[x2] <= P[x1] <= P[y] - K but y - x2 is smaller. 
    This implies that our candidates x for opt(y) will have increasing values of P[x].

    If opt(y1) = x, then we do not need to consider this x again. 
    For if we find some y2 > y1 with opt(y2) = x, 
    then it represents an answer of y2 - x which is worse (larger) than y1 - x.

    */
    public int shortestSubarray(int[] nums, int K) {
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
        Deque<Integer> monoq = new LinkedList<>();
        for (int y = 0; y < pSum.length; y++) {
            while(!monoq.isEmpty() && pSum[y] <= pSum[monoq.getLast()]) {
                monoq.removeLast();
            }
            while(!monoq.isEmpty() && pSum[y] >= pSum[monoq.getFirst()] + K) {
                min = Math.min(min, y - monoq.removeFirst());
            }
            monoq.addLast(y);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}