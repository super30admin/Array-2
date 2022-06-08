//****448.FIND ALL NUMBERS DISAPPEARED IN ARRAY****
// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result=new ArrayList<>();
        int n= nums.length;
        if(nums.length==0 || nums==null) 
        {
            return result;
        }
        
        for(int i=0;i<n;i++)
        {
            int temp=Math.abs(nums[i])-1;
            
                if(nums[temp]>0)
                {
                    nums[temp] *= -1;
                }
                
        }
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }
    return result;
    }
    
}

//****GAME OF LIFE****
// Time Complexity :O(m*n)*8 i.e: o(m*n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N


class Solution {
    int m;
    int n;
    int[][] dir;
    
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        //              {right} {left} {down} {up}   {upleft}{upright}{downleft}{downright}//
        dir= new int[][]{{0,1},{0,-1},{1,0}, {-1,0}, {-1,-1}, {-1,1},  {1,-1}, {1,1}};
        
        
        //1..0  > 3
        //0..1  > 2
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countalive=countalive(board, i, j);
                if(board[i][j]==1 &&(countalive<2 || countalive>3) )
                {
                    board[i][j]=3;
                }
                if(board[i][j]==0 && countalive==3)
                {
                    board[i][j]=2;
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                {
                    board[i][j]=0;
                    
                }
                if(board[i][j]==2)
                {
                    board[i][j]=1;
                    
                }
                
            }
        }
        
    }
    
    private int countalive(int[][] board, int i, int j)
    {
        int res=0;
        
        for(int[] d: dir)
        {
            int nr=i+ d[0];
            int nc=j+ d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==3))
            {
                res++;
            }
        }
    return res;
    }
}
