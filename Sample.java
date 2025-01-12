/***************************PROBLEM-1*******************/
// Time Complexity : 0(n) n=length of array
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length,index=0;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            index=Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i]=nums[i]*-1;
            }
        }
        return result;
    }
}

/***************************PROBLEM-2*******************/
// Time Complexity : 0(m*n) , m=rows, n=cols
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no

class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countLiveNeighbors=countLiveNeighbors(i,j,board);
                //1->0 =2
                //0->1 =3
                if(board[i][j]==1){
                    if(countLiveNeighbors<2 || countLiveNeighbors>3){
                        board[i][j]=2;
                    }
                }else{
                    if(countLiveNeighbors==3){
                        board[i][j]=3;
                    }
                }

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }

    }

    private int countLiveNeighbors(int i,int j,int[][] board){
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}} ;//u d l r ul ur ll lr
        int count=0;
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}