from typing import List


class Solution:

    # 给定一个二进制数组nums ， 计算其中最大连续1的个数。
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        pre_sum = 0
        max_sum = 0
        for i in range(len(nums)):
            res = pre_sum + nums[i]
            if res == pre_sum:
                max_sum = max(max_sum, res)
                pre_sum = 0
            else:
                pre_sum += nums[i]
        return max(max_sum, pre_sum)
