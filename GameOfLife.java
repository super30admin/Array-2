//Time - O(m*n)
//Space - O(1)
class GameOfLife {
    public void gameOfLife(int[][] nums) {
        if(nums==null || nums.length==0) return;
        int nr = nums.length;
        int nc = nums[0].length;

        for(int i=0; i<nr; i++){
            for(int j=0; j<nc; j++){
                int lives = countLiveNeighbors(nums, i, j);
                if(nums[i][j]==1){
                    if(lives!=2 && lives!=3){
                        //Live to Dead = 1 to 2
                        nums[i][j] = 2;
                    }
                } else if(nums[i][j]==0){
                    if(lives==3){
                        //Dead to live = 0 to 3
                        nums[i][j] = 3;
                    }
                }
            }
        }

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[0].length; j++) {
                if(nums[i][j] == 2) {
                    nums[i][j] = 0;
                } else if(nums[i][j] == 3) {
                    nums[i][j] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] nums, int row, int col){
        int[][] dirs = new int[][]{{0,1},{1,0},{1,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1}};
        int nr = nums.length, nc = nums[0].length;
        int count = 0;
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];

            if(r<nr && c<nc && r>=0 && c>=0 && (nums[r][c]==1 || nums[r][c]==2)){
                count++;
            }
        }

        return count;

    }
}