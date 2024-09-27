#Problem 1: Find all numbers disappeared in a array
#Time complexity O(n)
#space complexity O(1)
#Worked on leetcode?: yes
'''
brute force would just be to check for each number if it's in the list.
Traversing until we find each time
'''
'''
main idea:
ideally we could use a hashmap, unfortunately we are not allowed to.
But, since we can use the index as a key for fast lookup (since we only want
the numbers from 1 to n), we could use the result array for that purpose.
At the end we could use a two pointer swapping scheme to get all the
ones that is in array to the end and pop one by one. Return what's left
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #edge case
        if not nums:
            return []
        n=len(nums)
        res=[ i for i in range(1,n+1) ]

        for num in nums:
            res[num-1]=None
        i,j=0,len(res)-1
        while i<=j:
            if res[i] is None:
                res[i],res[j]=res[j],res[i]
                res.pop()
                j-=1
            else:
                i+=1
        return res

#Problem 2: Find minimum and maximum
#Time complexity O(n)
#space complexity O(1)
def min_max(nums):
    #edge case
    if not nums:
        return []
    mini=float("inf")
    maxi=float("-inf")
    for num in nums:
        if num<mini:
            mini=num
        elif num>maxi:
            maxi=num
    return [mini,maxi]

#Problem 3: Game of life
#Time complexity O(n) , n number of elements in array
#space complexity O(1), inplace
#Worked on leetcode?: yes

'''
Brute force:
For each cell check all the neighbors and count them, if it dies in the next round put 2, if it doesn't put 3, if it's not live but becomes in the next, put -1.
Careful not to put 3 if it was dead before because the neighbors will count him as alive
So live state is any number >=1 (We want to update at the same time). Then go through the whole array and update the state

'''
'''
Main idea:
I don't think there's an obvious optimisation here since we cannot consider it graph
because what we count is neighbors and not connectedness. Since our brute force is
already O(n) time complexity, we should implement it
'''

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #edge case:
        if not board:
            return
        n=len(board)
        m=len(board[0])

        def count_neighbors(r,c):
            count=0
            #>=1 since even if they die, they die next round
            if c<m-1 and board[r][c+1]>=1:
                count+=1
            if c<m-1 and r>0 and board[r-1][c+1]>=1:
                count+=1
            if r>0 and board[r-1][c]>=1:
                count+=1
            if c>0 and r>0 and board[r-1][c-1]>=1:
                count+=1
            if c>0 and board[r][c-1]>=1:
                count+=1
            if c>0 and r<n-1 and board[r+1][c-1]>=1:
                count+=1
            if r<n-1 and board[r+1][c]>=1:
                count+=1
            if r<n-1 and c<m-1 and board[r+1][c+1]>=1:
                count+=1
            return count
        def update(board):
            for r in range(n):
                for c in range(m):
                    if board[r][c]==3:
                        board[r][c]=1
                    if board[r][c]==2:
                        board[r][c]=0
                    if board[r][c]==-1:
                        board[r][c]=1
        #starting the loop
        for r in range(n):
            for c in range(m):
                count=count_neighbors(r,c)
                if board[r][c]==1:
                    if 2<=count<=3:
                        board[r][c]=3
                    else:
                        board[r][c]=2
                if board[r][c]==0:
                    if count==3:
                        board[r][c]=-1
        update(board)
