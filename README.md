# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

## solution
class Solution {

   public List<Integer> findDisappearedNumbers(int[] nums) {

       List <Integer> result = new ArrayList<Integer>();

       for(int i = 0; i < nums.length; i++){

           int temp = nums[i];

           // If found index element is negative

           if(temp < 0){

               temp *= -1;

           }

           if(temp <= nums.length) {

              if(nums[temp - 1] > 0){

               nums[temp-1] *= -1;

              } 

           }

       }

       for(int i = 0; i < nums.length; i++){

           if(nums[i] > 0){

               result.add(i+1);

           }

       }

       return result;

   }

}

## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

## Problem3 (https://leetcode.com/problems/game-of-life/)

## solution
class Solution {

    int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};

    public void gameOfLife(int[][] board) {

        for(int i=0;i<board.length;i++){
              for(int j=0;j<board[0].length;j++){
                int live=0;

                for(int[] d:dir){
                    if((i+d[0])<0||(i+d[0])>=board.length||(j+d[1])<0||(j+d[1])>=board[0].length){
                        continue;

                    }
                    if(board[i+d[0]][j+d[1]]==1||board[i+d[0]][j+d[1]]==2){

                        live++;

                    }

                }

                if(board[i][j]==1&&(live<2||live>3)){

                    board[i][j]=2;

                }
                if(board[i][j]==0&&live==3){
                 board[i][j]=3;           


                }

            }
        }

        for(int i=0;i<board.length;i++){


            for(int j=0;j<board[0].length;j++){

                board[i][j]=board[i][j]%2;
            }
        }

    }

} 

