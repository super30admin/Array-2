//Time Complexity O(numberOfCoins*amount)
//Space Complexity O(numberOfCoins*amount)

// Problem successfully compiled on leetcode
// No Problems faced while figuring out the logic

#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    
    int FindNeighbours(vector<vector<int> >& board, int row, int col)
    {
        int search[8][2]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count=0;
        for(int i=0; i<8;i++)
        {
            int newRow= row + search[i][0];
            int newCol= col + search[i][1];
            
            if(newRow >= 0 && newCol >= 0 && newRow < board.size() && newCol < board[0].size() && (board[newRow][newCol]==1 || board[newRow][newCol]==2))
            {
                count++;
            }
        }
        return count;
    }
    
    void gameOfLife(vector<vector<int> >& board) {
        int rows=board.size();
        int cols=board[0].size();
        
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int noOfNeighbours= FindNeighbours(board,i,j);
                if(board[i][j]==1)
                {
                    if(noOfNeighbours < 2 || noOfNeighbours > 3)
                    {
                        board[i][j]=2;
                    }
                }
                else
                {
                    if(noOfNeighbours==3)
                    {
                        board[i][j]=3;
                    }
                }
            }
        }
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]==2)
                { 
                    board[i][j]=0;
                }
                
                if(board[i][j]==3)
                {
                    
                    board[i][j]=1;
                }
            }
        }
    }
};