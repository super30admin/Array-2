// Time Complexity :O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
#include <vector>
#include <iostream>
using namespace std;
class Solution {
//0-->2
//1-->3 if change be
private:
    vector<vector<int>> dir{
        {0,1},
        {0,-1},
        {-1,0},
        {1,0},
        {-1,1},
        {1,1},
        {1,-1},
        {-1,-1} 
    };
    int countOnes(vector<vector<int>>& board,int i,int j)
    {
        int count = 0;
        int nr;
        int nc;
        for(auto e:dir)
        {
            nr = i+e[0];
            nc = j + e[1];
            if(nr>=0 && nc>=0 && nr<board.size() && nc < board[nr].size())
            {
                if(board[nr][nc]==1 || board[nr][nc]==3)
                {
                    count++;
                }
            }
        }
        return count;

    }
public:
    void gameOfLife(vector<vector<int>>& board) {

        for(int i = 0; i< board.size();i++)
        {
            for(int j=0; j<board[i].size() ; j++)
            {
                int count = countOnes(board,i,j);

                if(count<2 && board[i][j]==1)
                {
                    board[i][j] = 3;
                }
                else if(count>3 && board[i][j]==1)
                {
                    board[i][j] = 3;
                }
                else if(count==3 && board[i][j]==0)
                {
                    board[i][j] = 2;
                }

            }
        }
        for(int i = 0; i< board.size();i++)
        {
            for(int j=0; j<board[i].size() ; j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j] = 1;
                }
                else if(board[i][j]==3)
                {
                    board[i][j] = 0;
                }
            }
        }
    }
};