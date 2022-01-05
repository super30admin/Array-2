

// Time Complexity : O(m*n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes


// approach :  I'm changing state of any changed value, if it changes from dead to alive I'll make that cell as -1 and if it changes from alive to dead I'll make it as 2. While counting 1's I'll count the updated value 2 also as 1.


class Solution {
    public void gameOfLife(int[][] board) {
        
        if(board == null)
            return;
        
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlives = countOfAlivesAround(board,dir,i,j);
                
                if(board[i][j] == 1 && (countAlives <2 || countAlives >3)){
                    board[i][j] = 2;
                }
                
                if(board[i][j] == 0 && countAlives ==3){
                    board[i][j] = -1;
                }
                
            }
        }
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlives = countOfAlivesAround(board,dir,i,j);
                
                if(board[i][j] == 2 ){
                    board[i][j] = 0;
                }
                
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }
                
            }
        }
        
    }
    
    private int countOfAlivesAround(int[][] board,int[][] dir,int i,int j){
        int count =0;
        
        for(int[] d : dir){
            int r = d[0];
            int c = d[1];
            
            if((i+r) >=0 && (i+r) <board.length && (j+c) >=0 && (j+c) < board[0].length && (board[i+r][j+c] ==1 || board[i+r][j+c] ==2))
                count++;
        }
        
        
        return count;
    }
}