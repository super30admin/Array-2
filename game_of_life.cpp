// Time complexity-O(n*m)
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// we are trying to leverage the state change technique
// iterate over the matrix
// for each element go check the number of lives around it
// if the live dies,set the element at that position to 2
// if the dead comes to life set the element at that position to 3


#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        if(board.size()==0 || board[0].size()==0){
            return;
        }
        int m= board.size();int n =board[0].size();
        for(int i=0;i <m;i++){
            for(int j=0;j<n;j++){
                 int lives= countlives(board,i,j,m, n);
                if (board[i][j] ==1 && (lives <2 || lives > 3)){
                    board[i][j]= 3;
                }
                
                if(board[i][j] ==0 && lives==3){
                    board[i][j] =2;
                }
            }
        }
        // restore the new state 
        for(int i=0;i <m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] ==3){
                    board[i][j]= 0;
                }
                
                if(board[i][j] ==2){
                    board[i][j] =1;
                }
            }
        }
        
        
    }
    
    int countlives(vector<vector<int>> board,int i,int j,int m,int n){
        int result=0;
        vector<vector<int>> dirs= {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1},};
        for (auto dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            // bound and live check
            if(r>=0 && r <m  && c>=0 && c < n && 
               (board[r][c]==1 || board[r][c]==3)){
                result++;
            }
        
        }
        return result;
        
    }
    
};