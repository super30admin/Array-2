//time complexity:O(m*n)
//space complexity:O(m*n)
//executed on leetcode: yes
//approach:using a copy 2D vector
//any issues faced? yes, I saw the leetcode solution. 
//I couldnt come up with my approach. Still not clear with the liveneighbors part.
class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int rows=board.size();
        int cols=board[0].size();
        if(board.size()==0)
            return;
        vector<vector<int>>copy=board;
        int neighbors[]={0,1,-1};
        for(int row=0; row<rows; row++)
        {
            for(int col=0; col<cols; col++)
            {
                int liveneighbors=0;
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(!(neighbors[i]==0 && neighbors[j]==0))
                        {
                            int r=row+neighbors[i];
                            int c=col+neighbors[j];
                            if((r<rows && r>=0)&&(c<cols && c>=0)&&(copy[r][c]==1))
                            {
                                liveneighbors++;
                            }
                        }
                    }
                }
                if((copy[row][col]==1)&&(liveneighbors<2 || liveneighbors>3))
                {
                    board[row][col]=0;
                }
                if((copy[row][col]==0)&&liveneighbors==3)
                {
                    board[row][col]=1;
                }
            }
        }
        
    }

};
