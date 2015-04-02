class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        dict = {}
        for i in range(len(num)):
            n = target - num[i]
            if n in dict:
                return dict[n],i+1
            else:
                dict[num[i]] = i+1