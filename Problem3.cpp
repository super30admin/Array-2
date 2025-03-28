// Time Complexity : O(N*M) #of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Count all neighbouring ones and if it's changing state with
// following rules assign numbers -1 and -2. 
// 2. -1 means changed from 0 to 1 and -2 means 1 to 0.
// 3. at last just change -1 and -2 to 1 and 0 respectively to get next state.

class Solution {
public:
    int chkstate(int x,int k){
        if(k<2 && x==1){
            return -2;
        }else if((k==2 || k==3) && x==1){
            return 1;
        }else if((k>3) && x==1){
            return -2;
        }else if((k==3) && x==0){
            return -1;
        }
        return x;
    }
    void gameOfLife(vector<vector<int>>& board) {
        int n=board.size()-1,m=board[0].size()-1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                int t=0;
                if(i!=0 && (board[i-1][j]==-2 || board[i-1][j]==1) ){t++;}
                if (i!=0 && (j)!=m && (board[i-1][j+1]==-2 || board[i-1][j+1]==1) ){t++;}
                if(i!=0 && (j!=0) && (board[i-1][j-1]==-2 || board[i-1][j-1]==1) ){t++;}
                if(i!=n && (board[i+1][j]==-2 || board[i+1][j]==1) ){t++;}
                 if(i!=n && j!=0 && (board[i+1][j-1]==-2 || board[i+1][j-1]==1) ){t++;}
                 if(i!=n && j!=m && (board[i+1][j+1]==-2 || board[i+1][j+1]==1) ){t++;}
                 if(j!=0 && (board[i][j-1]==-2 || board[i][j-1]==1) ){t++;}
                 if(j!=m && (board[i][j+1]==-2 || board[i][j+1]==1) ){t++;}
                board[i][j]=chkstate(board[i][j],t);
                cout<<board[i][j]<<' ';
                //cout<<t<<' ';
            }
            cout<<'\n';
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(board[i][j]==-1){
                    board[i][j]=1;
                }
                if(board[i][j]==-2){
                    board[i][j]=0;
                }
            }
        }

    }
};