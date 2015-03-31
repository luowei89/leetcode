class Solution:
    # @return a string
    def convertToTitle(self, num):
        str = "";
        base = ord('A');
        while(num > 0):
            str = chr(base+(num-1)%26)+str;
            if(num%26 == 0):
                num = (num-1)/26;
            else:
                num = num/26;
        return str;