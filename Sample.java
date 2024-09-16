// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> result= new ArrayList();
        
        if(nums.length==0||nums==null)
          return result;
        for(int i=0;i<nums.length;i++)
        {
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0)
            {
                nums[idx]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
           }
        
        }
        return result;
    }
}
--------------------------------------------------------------------------------------------------------
// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :

class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0)
            return;
        m=board.length;
        n=board[0].length;
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            int livingCount= countlives(board,i,j);
            if(board[i][j]==1)
            {
               if(livingCount<2||livingCount>3){
                   board[i][j]=8;
               } 
            }
            else
            {
                if(livingCount==3)
                {
                    board[i][j]=7;
                }
            }
        }
    }
         for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(board[i][j]==7)
            {
                board[i][j]=1;
            }
            if(board[i][j]==8)
            {
                board[i][j]=0;
            }
            
        }
         }    
    }
    private int countlives(int[][]board,int i,int j)
    {
        int count=0;
        int [][]dirs={{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        for(int[]dir:dirs)
        {
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0&&c>=0&&r<m&&c<n&&(board[r][c]==1||board[r][c]==8))
            {
                count++;
            }
        }
       return count; 
        
    }
}

-------------------------------------------------------------------------------------------------------------------------------
// Space Complexity :O(1)
  
    static class Pair { 
  
        int min; 
        int max; 
    } 
  
    static Pair getMinMax(int arr[], int n) { 
        Pair minmax = new Pair(); 
        int i; 

        if (n % 2 == 0) { 
            if (arr[0] > arr[1]) { 
                minmax.max = arr[0]; 
                minmax.min = arr[1]; 
            } else { 
                minmax.min = arr[0]; 
                minmax.max = arr[1]; 
            } 
            i = 2; 
            else { 
            minmax.min = arr[0]; 
            minmax.max = arr[0]; 
            i = 1; 
            /* set the startung index for loop */
        } 
  
  
        while (i < n - 1) { 
            if (arr[i] > arr[i + 1]) { 
                if (arr[i] > minmax.max) { 
                    minmax.max = arr[i]; 
                } 
                if (arr[i + 1] < minmax.min) { 
                    minmax.min = arr[i + 1]; 
                } 
            } else { 
                if (arr[i + 1] > minmax.max) { 
                    minmax.max = arr[i + 1]; 
                } 
                if (arr[i] < minmax.min) { 
                    minmax.min = arr[i]; 
                } 
            } 
            i += 2; 
          
        } 
  
        return minmax; 
    } 