//Time Complexity: O(MN) where M is the number of rows and N is the number of columns in the matrix
//Space Complexity:O(1)
//In this problem , I'll be designing a direction list that includes all the 8 possible directions from an element. I'll then iterate through the direction list to find out the number of neighbors that are alive and increment the count. If that count is <2 or greater than three I'll make it 2, which I'll be making 0 later. And if my element was dead and if the live count of the neighbor is equal to 3, then I'll mark it as 3 which I'll later change to 1.I'll repeat this process for the entire matrix and at the end I'll update the value of each element by taking the modulo by 2. 
//This code was executed successfully and got accepted in leetcode.

class Solution {
    int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[0].length;j++){
                int live=0;
                for(int[] d:dir){
                    if((i+d[0])<0||(i+d[0])>=board.length||(j+d[1])<0||(j+d[1])>=board[0].length){
                        continue;
                    }
                    if(board[i+d[0]][j+d[1]]==1||board[i+d[0]][j+d[1]]==2){
                        live++;
                    }
                    
                }
                if(board[i][j]==1&&(live<2||live>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0&&live==3){
                    board[i][j]=3;                
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=board[i][j]%2;
            }
        }
    }
}