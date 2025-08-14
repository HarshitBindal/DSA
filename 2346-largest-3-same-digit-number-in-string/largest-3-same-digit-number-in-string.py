class Solution:
    def largestGoodInteger(self, num: str) -> str:
        count = 0
        maxi = ' '
        prev = ' '
        for c in num:
            if c==prev: count += 1
            else: count = 1 
            if count==3:
                maxi = max(c,maxi)
            prev = c
        if maxi==' ': return ""
        return maxi*3