/*
The code iterates through each cell of the board and counts the number of live neighbors for each cell.
It then updates the cells based on the rules of the Game of Life, marking cells to die or be born.
Finally, it applies the updates to the original board.
Time Complexity:

The algorithm iterates through each cell once, and for each cell, it checks its neighbors.
Thus, the time complexity is O(m * n), where m is the number of rows and n is the number of columns.
Space Complexity:

The algorithm uses a constant amount of extra space, independent of the input size.
Therefore, the space complexity is O(1).*/

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
 vector<vector<int>> dirs;
    void gameOfLife(vector<vector<int>>& board) {
       dirs={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1}, {1,-1},{1,1}};
        int m=board.size();
        int n=board[0].size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               int count=findAliveneigh(board, i, j, n, m);
               if(board[i][j]==1 && (count<2||count>3)){
                board[i][j]=2;
               }else if(board[i][j]==0&&count==3){
                    board[i][j]=3;
               }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    int findAliveneigh(vector<vector<int>>& board, int i,int j,int n,int m){
        int count=0;
        for(auto dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && c>=0 && r<m&&c<n&& (board[r][c]==1||board[r][c]==2)) count++;
        }
        return count;
    }
};