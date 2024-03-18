//Time Complexity O(N) and space O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {


        //mark the numbers as negative
        for(int i=0;i<nums.length;i++){        
            int l = Math.abs(nums[i])-1;
            if(nums[l]>0){
                nums[l]*=-1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0){
                list.add(i);
            }
        }

        return list;
        
    }
}

//Game of life
//time complexity O(M X N) and space complexity O(1)
class Solution {

    int[][] dirs;

    public void gameOfLife(int[][] board) {

        //make direction array
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int m = board.length;
        int n = board[0].length;

        //converting the array into -1 and 2
                            for(int i=0;i<m;i++){
                                for(int j=0;j<n;j++){

                                    int countlive = countlive(board,i,j);
                                    if(board[i][j]==1 && (countlive<2 || countlive >3)){
                                        board[i][j] =-1;
                                    }else if(board[i][j]==0 && countlive==3){
                                        board[i][j]=2;
                                    }
                                }
                            }

    // re-converting the array back to new gen
                                for(int i = 0;i<m;i++){
                                    for (int j = 0; j < n; j++){
                                        if (board[i][j] == -1) {
                                            board[i][j] = 0;
                                        } else if (board[i][j] == 2) {
                                            board[i][j] = 1;
                                        }
                                    }
                                }

    }

    // function to count live cells

    public int countlive(int[][]board,int r,int c){
        int count =0;
        for(int[] dir:dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length&& (board[nr][nc]==-1|| board[nr][nc]==1) ){
                count++;
            }
        }

        return count;
        
    }

}
