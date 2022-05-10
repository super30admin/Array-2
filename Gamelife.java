//Time complexity O(M*N);
//Space complexity O(M*N);
//Suucceffully run in the leetcode code






class Solution {
    public void gameOfLife(int[][] board) {
        int sum=0,M=board.length,N=board[0].length;
        int[][] result = new int[M][N];
        for(int i=0;i<M;i++){                               //Traverse the whole 2D array
            for(int j=0;j<N;j++){                                 
                sum=0;                                     //Initialise the total sum at every index to 0
                if(i-1 >= 0){                                //check all the boundary conditions where the index crosses its lower and upper limits

                    sum = sum + board[i-1][j];                     //add only those elements that are inside the boundary.
                    if(j-1 >= 0) sum= sum + board[i-1][j-1];
                    if(j+1 < N) sum = sum + board[i-1][j+1];
                }
                if(i <  M){
                    if(j+1 < N) sum = sum + board[i][j+1];
                    
                    if(j-1 >= 0) sum=sum+board[i][j-1];
                }
                if(i+1 < M){
                    sum = sum + board[i+1][j]; 
                    if(j-1 >= 0) sum=sum+board[i+1][j-1];
                    if(j+1 < N)  sum = sum+board[i+1][j+1];
                }
            
                if(board[i][j] == 1){                      //check the element at current index is live or dead
                    if(sum < 2) result[i][j] = 0;                  //If live and sum < 2 make it dead i.e 0
                    else if(sum == 2 || sum ==3) result[i][j] = 1;  //If live and sum=2 or 3 make it live i.2 1
                    else result[i][j] = 0;                           //If live and sum >3 make it dead i.e 0
                    
                }
                else{                                    //if the element at current index is dead then 
                    if(sum == 3) result[i][j] = 1;        //check if sum is exactly 3. if yes then make it live i.e 1
                    else result[i][j] = 0;                //else make it dead i.e 0
                }
                
            }
        }
        for(int i=0;i<M;i++){                           //as we have to return void. shift all the elements from result array to origin board array
            for(int j=0;j<N;j++){
                board[i][j] = result[i][j];
            }
        }
         return;                                       //return 
    }
}