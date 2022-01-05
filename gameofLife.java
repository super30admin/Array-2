
Time complexity : O(m*n);
Space Complexity :O(m*n);



class Solution {
    public void gameOfLife(int[][] board) {

        if (board.length == 1 && board[0].length == 1) {
            board[0][0] = 0;
            return;
        }

        int[][] b2 = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int neighbours = countNeighbours(board, row, col);
                if (board[row][col] == 1 && neighbours < 2) {
                    b2[row][col] = 0;
                }else if (board[row][col] == 1 && neighbours == 2 || neighbours == 3){
                    b2[row][col] = 1;
                } else if (board[row][col] == 1 && neighbours > 3) {
                    b2[row][col] = 0;
                } else if (board[row][col] == 0 && neighbours == 3) {
                    b2[row][col] = 1;
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = b2[row][col];
            }
        }
    }

    public int countNeighbours(int[][] board, int row, int col) {
        int number = 0;
        if (row - 1 < 0) {
            number += 0;
        } else if (board[row - 1][col] == 1) {
            number += board[row - 1][col];
        }

        if (row + 1 >= board.length) {
            number += 0;
        } else if (board[row + 1][col] == 1) {
            number += board[row + 1][col];
        }

        if (col - 1 < 0) {
            number += 0;
        } else if (board[row][col - 1] == 1){
            number += board[row][col - 1];
        }

        if (col + 1 >= board[row].length) {
            number += 0;
        } else if (board[row][col + 1] == 1) {
            number += board[row][col + 1];
        }

        //right-below
        if (col + 1 >= board[row].length || row + 1 >= board.length) {
            number += 0;
        } else if (col + 1 < board[row].length && row + 1 < board.length && board[row + 1][col + 1] == 1)  {
            number += board[row + 1][col + 1];
        }

        //right-top
        if (col + 1 >= board[row].length || row - 1 < 0) {
            number += 0;
        } else if (col + 1 < board[row].length && row - 1 >= 0 && board[row - 1][col + 1] == 1)  {
            number += board[row - 1][col + 1];
        }

        //left-bottom
        if (col - 1 < 0 || row + 1 >= board.length) {
            number += 0;
        } else if (col - 1 >= 0 && row + 1 < board.length && board[row + 1][col - 1] == 1)  {
            number += board[row + 1][col - 1];
        }

        //left-top
        if (col - 1 < 0 || row - 1 < 0) {
            number += 0;
        } else if (col - 1 >= 0 || row - 1 >= 0 && board[row - 1][col - 1] == 1)  {
            number += board[row - 1][col - 1];
        }

        return number;
    }
}