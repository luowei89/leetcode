class Solution:
    # @param A a list of integers
    # @param target an integer
    # @return a boolean
    def search(self, A, target):
        B = self.sort_a(A)
        return self.search_recur(B,target,0,len(B)-1)
    
    def sort_a(self,A):
        if len(A) == 1:
            return A
        i = 0
        while i < len(A)-1 and A[i] <= A[i+1]:
            i += 1
        B = A[i+1:len(A)]
        for a in A[0:i+1]:
            B.append(a)
        return B
        
    def search_recur(self,A,target,start,end):
        if start == end or start == end - 1:
            return A[start] == target or A[end] == target
        else:
            mid = (start+end)/2
            if target == A[mid]:
                return True
            elif target < A[mid]:
                return self.search_recur(A,target,start,mid-1)
            elif target > A[mid]:
                return self.search_recur(A,target,mid+1,end)