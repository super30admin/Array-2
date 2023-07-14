// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
1->0 = 2
0->1 = 3

we would first iterate over the elements of the matrix and find the number of alive neighbors
then we check if the element is alive and the less than 2 neigbors are alive or more than 3 neighbors are alive
if thats the case, then 1 dies(becomes 2). Else, if the element is 0 and count of alive neighbors
is 3, the 0 lives (becomes 3). 

Later we again iterate over the elements of the matrix and find the elements which were first alive
but died(2->0) or which were first dead then became alive(3->1) and turn the matrix into our resulting matrix.

To find the number of alive neighbors, we use the direction array, we iterate over the direction array
and we update the row and column to find the number. if the neighbors are in bounds and are alive, we increment count.


*/

#include <iostream>

#include <vector>

using namespace std;


class Solution {
public:

    int countAlive(vector<vector<int>>& board, int i, int j,int m, int n){
        int count = 0;
        

        vector<vector<int>> dirs ={
            {0,1},
            {0,-1},
            {-1,0},
            {1,0},
            {-1,-1},
            {-1,1},
            {1,-1},
            {1,1}
        };

        for(auto dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];

            if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1||board[r][c]==2)){
                count++;
            }


        }

        return count;
        

    }
    void gameOfLife(vector<vector<int>>& board) {

        

        int m = board.size();
        int n= board[0].size();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt = countAlive(board,i,j,m,n);
                if(board[i][j]==1 && (cnt < 2||cnt >3)){
                    board[i][j] = 2;

                }

                if(board[i][j]==0 && cnt == 3){
                    board[i][j] = 3;


                }
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }

                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }

        
        
    }
};