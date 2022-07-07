//tc-O(n*m)
//sc-O(1)
class Solution {
public:
    int countLives(vector<vector<int>>&board,int &i,int &j){
     int m=board.size();
     int n=board[0].size();
     int count=0;
        vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        for(vector<int>arr:dir){
            int dx=i+arr[0];
            int dy=j+arr[1];
            if(dx>=0&&dx<m&&dy>=0&&dy<n&&(board[dx][dy]==1||board[dx][dy]==3)){
                count++;
            }
        }
        return count;
    }
    
    void gameOfLife(vector<vector<int>>& board) {
       int m=board.size();
       int n=board[0].size();
        //0->1 then 2
        //1->0 then 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countLives(board,i,j);
                if(board[i][j]==0){
                    if(count==3)board[i][j]=2;
                }
                else{
                    if(count>3||count<2)board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
   
    }
};