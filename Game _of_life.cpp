Time Complexity-O(n*m)
Space Complexity-O(1)
Did the code run on Leetcode? Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    
    int countarr(vector<vector<int>>& board,int x,int y)
    {
        int var=0;
        vector<vector<int>>m={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i=0;i<m.size();i++)
        {
            int a=x+m[i][0];
            int b=y+m[i][1];
            if(a>=0 && a<board.size() && b>=0 && b<board[0].size())
            {
                if(board[a][b]==1|| board[a][b]==-1)
                {
                    var++;
                }
            }
        }
        return var;
    }
    
    void gameOfLife(vector<vector<int>>& board) {
        if(board.size()==0)
        {
            return;
        }
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                if(board[i][j]==1 && (countarr(board,i,j)<2 || countarr(board,i,j)>3))
                {
                    board[i][j]=-1;
                }
                if(board[i][j]==0 && countarr(board,i,j)==3)
                {
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                if(board[i][j]==-1)
                {
                    board[i][j]=0;
                }
                if(board[i][j]==2)
                {
                    board[i][j]=1;
                }
            }
        }
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                cout<<board[i][j]<<" ";
            }
            cout<<"\n";
        }
        
    }
};

int main() {
	vector<vector<int>>arr={
                             {0,1,0},
                             {0,0,1},
                             {1,1,1},
                             {0,0,0}
	                        };
	Solution soln;
	soln.gameOfLife(arr);
	return 0;
}