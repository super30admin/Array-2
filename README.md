# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

//Time Complexity: O(N)
//Space Complexity: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i< nums.length; i++)
        {
            int index = Math.abs(nums[i]) -1;
            if(nums[index] >0)
            {
                nums[index] *= -1;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i< nums.length ; i++)
        {
            if(nums[i] >0)
            {
                result.add(i+1);
            }
        }
        
        return result;
    }
}

## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
//Time Complexity: O(N)
//Space Complexity: O(1)
//1.5N comparisons 

class Solution
{
    private static void findMinMax(int[] arr)
    {
        int min, max;
        int i;
        if(arr.length % 2 ==0 && arr.length!=0)
            {
                
                if(arr[0]> arr[1])
                {
                    min = arr[1];
                    max = arr[0];
                }
                else
                {
                    min = arr[0];
                    max = arr[1];
                }

                i= 2;
            }
            else
            {
                min = arr[0];
                max = arr[0];
                i=1;

            }
        for(; i<arr.length-1; i+=2 )
        {
            
            if(arr[i]>arr[i+1])
            {
                min = Math.min(min, arr[i+1]);
                max= Math.max(max, arr[i]);
            }
            else
            {
                min = Math.min(min, arr[i]);
                max= Math.max(max, arr[i+1]);
            }
        }
        System.out.println("The minimum value is:" + min);
        System.out.println("The maximum value is:" + max);
    }

    public static void main(String args[])
    {
        int[] arr1 ={5,8,3,18,4,7,12};
        int[] arr2 ={ 5,8,3,18,4,7,12,2};

        findMinMax(arr1);
        findMinMax(arr2);

    }
}




## Problem3 (https://leetcode.com/problems/game-of-life/)
//Time Complexity: O(M*N)
//Space Complexity: O(1)
class Solution {
    
    private int aliveNeighbours(int[][] matrix, int i, int j)
    {
        int count =0;
        int dirs[][]= {{-1,-1}, {-1,0}, {-1,1}, {1, -1}, {1, 0}, {1,1}, {0, -1}, {0, 1}};
        for(int[] dir : dirs)
        {
            int row = i + dir[0];
            int col = j+ dir[1];
            
            if( row >= 0 && row < matrix.length && col>=0 && col < matrix[0].length)
            {
                 if(matrix[row][col] == 1 || matrix[row][col] == 2)
                    count++;
            }
           
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i< m ; i++)
        {
            for(int j=0; j<n; j++)
            {
                int numberAliveNeigbours = aliveNeighbours(board, i, j);
                //transition from alive to dead -> marked by the digit 2 
                if(board[i][j] == 1 && (numberAliveNeigbours< 2 || numberAliveNeigbours > 3))
                {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && numberAliveNeigbours == 3)
                {
                     board[i][j] = 3;
                }
            } 
        }
        
         for(int i=0; i< m ; i++)
        {
            for(int j=0; j<n; j++)
            {
                 if(board[i][j] == 2)
                     board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
             
         }
        
        
    }
}