# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No



class Solution:
    def findSum(self,A,N): 
        if(N==1):
            return(2*A[0])
        
        minn=A[0]
        maxx=A[1]
        for i in range(0,N,2):
            if(i+1!=N):
                if(A[i]<A[i+1]):
                    minn=min(minn,A[i])
                    maxx=max(maxx,A[i+1])
                else:
                    minn=min(minn,A[i+1])
                    maxx=max(maxx,A[i])
            else:
                minn=min(minn,A[i])
                maxx=max(maxx,A[i])
                
        return(minn+maxx)