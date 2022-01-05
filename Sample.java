// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    final int[][] cellNeighbors = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    private int getActiveNeighbors(int row,int column,int[][] board){
        int result = 0;
        for(int[] neighbors:cellNeighbors){
            int neighborX = neighbors[0] + row;
            int neighborY = neighbors[1] + column;
            if(neighborX < 0 || neighborX>board.length-1 || neighborY<0 || neighborY>board[0].length-1){
                continue;
            }
            if(board[neighborX][neighborY] == 1 || board[neighborX][neighborY] == 2){
                result += 1;
            }
        }
        return result;
    }
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        for(int row=0;row<rows;row++){
            for(int column=0;column<columns;column++){
                int activeNeighbors = getActiveNeighbors(row,column,board);
                //System.out.println("cell = "+row+", "+column+" = "+activeNeighbors);
                if(board[row][column] == 1){
                    if(activeNeighbors<2){
                        board[row][column] = 2; // 0 in final,1 current
                    }else if(activeNeighbors == 2 || activeNeighbors == 3){
                        board[row][column] = 1; // lives as it is
                    }else if(activeNeighbors>3){
                        board[row][column] = 2; // 0 in final,1 current
                    }
                }else{
                    if(activeNeighbors == 3){
                        board[row][column] = 3; // 1 in final
                    }
                }
            }
        }
        //System.out.println("board = "+Arrays.deepToString(board));
        for(int row = 0;row<rows;row++){
            for(int column = 0;column<columns;column++){
                if(board[row][column] == 2){
                    board[row][column] = 0;
                }else if(board[row][column] == 3){
                    board[row][column] = 1;
                }
            }
        }
    }
}




//time complexity : O(3n/2)


int[] findMinMax(int A[], int start, int end)
{
    int max;
    int min;
    if ( start == end )
    {
        max = A[start]
        min = A[start]
    }
    else if ( start + 1 == end )
    {
        if ( A[start] < A[end] )
        {
            max = A[end]
            min = A[start]
        }
        else
        {
            max = A[start]
            min = A[end]
        }
    }
    else
    {
        int mid = start + (end - start)/2
        int left[] = findMinMax(A, start, mid)
        int right[] = findMinMax(A, mid+1, end)
        if ( left[0] > right[0] )
            max = left[0]
        else
            max = right[0]
        if ( left[1] < right[1] )
            min = left[1]
        else
            min = right[1]
    }
    // By convention, we assume ans[0] as max and ans[1] as min
    int ans[2] = {max, min}
   return ans
}
