// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we modify the same matrix  and while modifying we change the values from 0 to 2 and from 1 to 3. And atlast we change them accordingly.



class Solution {
public:

    void gameOfLife(vector<vector<int>>& board) {
        if(board.empty() || board.size()==0){
            return;
        }
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                if(board[i][j]==0) // 0->2
                {
                    if(count(i,j,board)==3){
                        board[i][j] = 2;
                    }
                }
                else
                {
                    if(count(i,j,board)<2 || count(i,j,board)>3)
                        board[i][j] = 3;
                }     
            }
       }
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                if(board[i][j]==2) board[i][j] = 1;
                else if (board[i][j] == 3) board[i][j] = 0;
            }
        }
   }

    int count(int a, int b, vector<vector<int>> & board){
        vector<pair<int,int>>dir={{-1,-1},{-1,0},{-1,+1},{0,-1},{0,+1},{+1,-1},{+1,0},{+1,+1}};
        int count =0;
        int n = board.size();
        int m = board[0].size();
        for(int i = 0;i<dir.size();i++)
        {
            int p =a + dir[i].first;
            int q = b + dir[i].second;
            if((p>=0 && p<n) && (q>=0 && q<m) && (board[p][q]==1 || board[p][q]==3)) count++; 
        }
        return count;
                                 
     }

};