#   Problem Statement
#An array of numbers of length N is given ,
# you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons
#compare each element with max and min, and change max and min accordingly
# total comparison are 1+ 2(n-2) in worst case
class Solution:
    def maxmin(self,A):
        result=[]
        if len(A)==0:
            return "empty array"
        if len(A)==1:
            return A
        if A[1]>A[0]:
            max=A[1]
            min=A[0]
        else:
            min=A[1]
            max=A[0]
        for i in range(2,len(A)):
            if A[i]>max:
                max=A[i]
            elif A[i]<min:
                min=A[i]
        result.append(max)
        result.append(min)
        return result
if __name__ == "__main__":
    t=Solution()
    A=[-2,-4,-6,0]
    print(t.maxmin(A))