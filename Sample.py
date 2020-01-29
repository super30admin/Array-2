# Problem 1:
# 
# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
'''
Traversing through the list and taking each element at a time, taking the element as the index
going to index -1 and multiplying the elment at index-1 with -1. this way all the elements in the 
list wll become -1 except the position of the elemets that are not present in the array.
'''

class Solution:
    def findDisappearedNumbers(self, nums) :
        list1= []
        for i in range(len(nums)):
            temp = abs(nums[i])-1
            
            if(nums[temp]>0):
                nums[temp] = nums[temp]*-1
        for i in range(len(nums)):
            if(nums[i]>0):
                list1.append(i+1)
        return(list1)

#************************************************************************************

#Problem2:

# Problem 1:
# 
# Time Complexity :O(n)
# Space Complexity :O(1)
#number of comparison: 3*O(n/2)
# Did this code successfully run on Leetcode : Yes



# Your code here along with comments explaining your approach
'''
Taking the pair of elements and comparing between the to find the max and min between the pair
then comparing the max of the pair with max value stored and replacing accordingly
similarly min of the pair with the min value stored

'''


a = [2,8,6,2,11,5,70]

min= a[0]
max= a[0]

for i in range(1,len(a),2):
    if(a[i]> a[i+1]): # comparing between the pairs
        if(a[i]> max): #comparing with the max
            max = a[i]
        if(a[i+1]<min): # comparing with the min
            min= a[i+1]

        
    if(a[i]<a[i+1]): # comparing between the pairs
        if(a[i]< min): # comparing with the min
            min= a[i]
        if(a[i+1]>max):  #comparing with the max
            max= a[i+1]


print(max)
print(min)


#************************************************************************************

#Problem 3:

# Time Complexity :O(n^2)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes



# Your code here along with comments explaining your approach
'''
if the live cell dies then replacing 1 -> 0 = -1
if the dead cell becomes alive replacing 0 ->1 = 2

Using direction array to count the neighbouring elements

in the end replacing all the -1 with 0 and all 2's with 1

'''

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        
        if(rows==0 and cols==0):
            return
        
        neighbours = [[0,1],[0,-1],[-1,0],[1,0],[-1,1],[1,-1],[-1,-1],[1,1]] # creatinh direction array
        
        for i in range(rows):
            for j in range(cols):
                abc = self.liveneigh(board, i, j,neighbours)
                if(board[i][j]==1 and abc<2):
                    board[i][j] = -1 # if a cell dies then replace with -1
                if(board[i][j] ==1 and abc> 3):
                    board[i][j] = -1 # if a cell dies then replace with -1
                if(board[i][j] == 0 and abc ==3):
                    board[i][j] = 2 # if a cellbecomes alive then replace with 2
                    
        for i in range(rows):
            for j in range(cols):
                if(board[i][j] ==-1):
                    board[i][j] = 0
                if(board[i][j] ==2):
                    board[i][j] = 1
                    
        
        #function to traverse the direction array and count the number of neiwghbouring elements
    def liveneigh(self, board, i, j,neighbours):
        count = 0
        for neighbour in neighbours:
            r= neighbour[0] + i
            c = neighbour[1] + j
                
            if((r>=0 and r<len(board)) and (c>=0 and c<len(board[0]))):
                if(board[r][c] == 1 or board[r][c] == -1):
                    count = count+1
        return count
        
        