// Time Complexity :o(mn)
// Space Complexity :0(m+n)
// Did this code successfully run on Leetcode :yes did for only case because of my time constraint and ran successfully
// Any problem you faced while coding this : figured all the cases but as i did n't run all don't know whether this approach is universal or not.


// Your code here along with comments explaining your approach: there will be 9 cases where 4 are 4 corners of matrix and their neighbourhood changes. two are when element is not corner but at top most row and at bottom most row.2 are when they are at left most and right most columns but not corners.last 1 case is at middle.
//S0 based on these cases checking 0s and 1s. If there is a 0 count0 will be updated or if there is 1 count1 will be updated. based on counts another 4given conditions inside every case is checked for particular cell change.
//after one cell change count0,count1 are changed t0 0 and iterated.

class Solution {
    public void gameOfLife(int[][] board) {
        int count0=0;
        int count1=0;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0)&&(j==0)){
                    if(board[i][j+1]==0){
                        count0=count0+1;
                    }
                    else{
                        count1=count1+1;
                    }
                    if(board[i+1][j]==0){
                        count0=count0+1;
                    }
                    else{
                        count1=count1+1;
                    }
                    if(board[i+1][j+1]==0){
                        count0=count0+1;
                    }
                    else{
                        count1=count1+1;
                    }
                    if(count1<2){
                        board[i][j]=0;
                    }
                    else if((count1==2)||(count1==3)){
                        board[i][j]=1;
                    }
                    else if((count1>3)){
                        board[i][j]=0;
                    }
                    else if(count1==3){
                        board[i][j]=1;
                    }
                }
                count0=0;
                count1=0;
                