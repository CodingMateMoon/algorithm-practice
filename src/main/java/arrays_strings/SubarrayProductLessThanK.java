package arrays_strings;
// https://leetcode.com/problems/subarray-product-less-than-k/description/
/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

1 + 2 -> [10], [10, 5], [5]
right = 2 / product = 10, left = 1 -> +2 [5, 2], [2]
right = 3 / product = 60, left = 1 -> + 3  [5, 2, 6], [2,6], [6]

Example 2:

Input: nums = [1,2,3], k = 0
Output: 0

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106


1) k == 0인 경우 0
2) length == 1인 경우 sum, k 비교 후 sum < k일 때 1 리턴

 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int product = 1;
        int left = 0;
        int result = 0;


        for (int right = 0; right < nums.length; right++) {

            product *= nums[right];
            while (product >= k) {
               product /= nums[left];
               left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}
