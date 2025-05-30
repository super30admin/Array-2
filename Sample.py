# Time Complexity : 0(N)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# MARK THE INDEXES FOUND WITH -1 and then return all positive indexes that means they werent found 

  def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1

        return [i + 1 for i in range(len(nums)) if nums[i] > 0]


# Time Complexity : 
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# use pairwise comparison for every 2 elements to find max and min

def find_min_max(arr: List[int]) -> Optional[Tuple[int, int]]:
 
    n = len(arr)
    if n == 0:
      return None
    if n == 1:
      return arr[0], arr[0]

    if n % 2 == 0:
      minval = min(arr[0], arr[1])
      maxval = max(arr[0], arr[1])
      startidx = 2

    else:
      minval, maxval = arr[0],arr[0]
      startidx = 1

    for i in range(startidx,n-1,2):

      lo = min(arr[i],arr[i+1])
      hi = max(arr[i],arr[i+1])

      minval = min(minval,lo)
      maxval = max(maxval,hi)
    return minval, maxval
    
    

# Time Complexity : O(MN)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Your code here along with comments explaining your approach modify the elements in place in array by converting live cells that become dead to -1 and dead cells that become live to 2 

def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        neighbours = [(1,0),(-1,0),(0,1),(0,-1),(1,1),(-1,-1),(1,-1),(-1,1)]

        for i in range(len(board)):
            for j in range(len(board[0])):

                nei = self.calculateNeighbours(i,j,board,neighbours)

                if board[i][j] == 1 and (nei < 2 or nei > 3):
                    board[i][j] = -1
                if board[i][j] == 0 and nei == 3:
                    board[i][j] = 2
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0

    def calculateNeighbours(self,i,j,board,neighbours):

        nei = 0

        for n in neighbours:
            myrow = i + n[0]
            mycol = j + n[1]

            if myrow >= 0 and myrow < len(board) and mycol >= 0 and mycol < len(board[0]) and abs(board[myrow][mycol])==1:
                nei+=1
        return nei