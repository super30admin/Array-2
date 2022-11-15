/*
    Time Complexity = O(m*n)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */


package com.madhurima;

import java.util.Arrays;

public class GameOfLife {
}

class SolutionB {

    public int m, n;

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }

        m = board.length;
        n = board[0].length;

        // live to dead i.e. 1 -> 0, will replace 1 with 2
        //dead to live i.e 0 -> 1, will replace 0 with 3

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLive(board, i, j);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 2;
                    }
                }else{
                    if(count == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countLive(int[][] board, int r, int c){
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        SolutionB s = new SolutionB();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        for(int[] row: board){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("After Game...");
        s.gameOfLife(board);
        for(int[] row: board){
            System.out.println(Arrays.toString(row));
        }

    }
}
