from typing import List


class Solution:

    # 给你一个数组nums ，数组中有2n个元素，按[x1, x2, ..., xn, y1, y2, ..., yn]的格式排列。
    #
    # 请你将数组按[x1, y1, x2, y2, ..., xn, yn]
    # 格式重新排列，返回重排后的数组。
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        res = []
        for i in range(n):
            res.append(nums[i])
            res.append(nums[n + i])
        return res
