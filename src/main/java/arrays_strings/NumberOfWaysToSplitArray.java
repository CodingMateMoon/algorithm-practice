package arrays_strings;
/*
https://leetcode.com/problems/number-of-ways-to-split-array/description/
You are given a 0-indexed integer array nums of length n.

nums contains a valid split at index i if the following are true:

The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
There is at least one element to the right of i. That is, 0 <= i < n - 1.
Return the number of valid splits in nums.



Example 1:

Input: nums = [10,4,-8,7]
Output: 2
Explanation:
There are three ways of splitting nums into two non-empty parts:
- Split nums at index 0. Then, the first part is [10], and its sum is 10. The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.
- Split nums at index 1. Then, the first part is [10,4], and its sum is 14. The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.
- Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6. The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
Thus, the number of valid splits in nums is 2.

sum of the first 0(i=0) + 1 elements is greater than the sum of the last 4 - 0(i = 0) - 1 = 3 elements.
0 <= i < 3
sums[0] > sums[3] - sums[0]
sums[1] > sums[3] - sums[1]
sums[2] < sums[3]  - sums[2]

Example 2:

Input: nums = [2,3,1,0]
Output: 2
Explanation:
There are two valid splits in nums:
- Split nums at index 1. Then, the first part is [2,3], and its sum is 5. The second part is [1,0], and its sum is 1. Since 5 >= 1, i = 1 is a valid split.
- Split nums at index 2. Then, the first part is [2,3,1], and its sum is 6. The second part is [0], and its sum is 0. Since 6 >= 0, i = 2 is a valid split.
sums[0] < sums[3] - sums[0]
sums[1] > sums[3] - sums[1]
sums[2] > sums[3] - sums[2]

nums = [0,0]
Output : 1
sums[0] = 0
sums[1] - sums[0] = 0

Constraints:

2 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

10^5 * 10^5 = 10^10  => 100억 이상. int 최대 범위 2^32 = (2^10)^3 * 4 = 10^9 * 4 = 40억을 초과.
*/
public class NumberOfWaysToSplitArray {
    public int waysToSplitArray_1(int[] nums) {
        int n = nums.length;
        long[] sums = new long[n];
        sums[0] = nums[0];
        int result = 0;

        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if (sums[i] >= (sums[n - 1] - sums[i])) {
                result++;
            }
        }
        return result;
    }
    public int waysToSplitArray(int[] nums) {
        long leftSum, rightSum;
        leftSum = rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if (leftSum >= rightSum) {
                result++;
            }
        }
        return result;
    }
}
