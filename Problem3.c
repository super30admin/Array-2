/* Problem Statement:
WORKS ON LEETCODE

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


 *
 * Time Complexity : O(n*m)
 * Space Complexity : O(k*m) where k is 2 * number of columns
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>


/* Function definition for the program. See function details for understanding */

void gameOfLife(int** board, int boardSize, int* boardColSize){
    int *temp_array[2] = {NULL};
    int total_ones = 0;
    int row = 0, col = 0;
    int row_t = 0;
    
    /* Input Validations */
    if (!board || !boardColSize) {
        return;
    }
    if (!boardSize) {
        return;
    }
    /* Allocate 2 temp arrays in a 2D array for sliding window case */
    temp_array[0] = (int *)calloc(*boardColSize, sizeof(int));
    if (!temp_array[0]) {
        printf("Memory allocation failed for 1st temp array\n");
        return;
    }
    temp_array[1] = (int *)calloc(*boardColSize, sizeof(int));
    if (!temp_array[1]) {
        printf("Memory allocation failed for 2nd temp array\n");
        return;
    }
    /* row_t specifies row for temp array where we are storing the data 
     *row and col are used for iterating the 2d array
     * 
     */
    row_t = 1;
    for (row = 0; row < boardSize; row++) {
        /* Toggle between 0th and 1st index for temp array */
        row_t = !row_t;
        for (col = 0; col < *boardColSize; col++) {
            /* Count total number of 1s in the eight neighbors for the index */
            total_ones = 0;

            /* Eight Neighbors calculation */
            /* for previous columns */
            if (col - 1 >= 0) {
                total_ones += board[row][col - 1];
                
                if (row - 1 >= 0)
                    total_ones += board[row - 1][col - 1];
                
                if ((row + 1) < boardSize)
                    total_ones += board[row + 1][col - 1];
            }
            /* For columns */
            if ((col + 1) < *boardColSize) {
                total_ones += board[row][col + 1];
                
                if (row - 1 >= 0)
                    total_ones += board[row - 1][col + 1];
                
                if ((row + 1) < boardSize)
                    total_ones += board[row + 1][col + 1];
            }
            /* For previous and next rows */
            if (row - 1 >= 0)
                total_ones += board[row - 1][col];
            if (row + 1 < boardSize)
                total_ones += board[row + 1][col];


            /* Here comes the most important part of our program. Sliding window technique 
             *
             * Store results in temp_array for first 2 rows, then we can replace it in the original array
             * so that output data  is also not compromised 
             *  Input: 
                        [original
                          [0,1,0],     temp_array[0] = 0,0,0
                          [0,0,1],     temp_array[1] = 1,0,1
                          [1,1,1],    now original[0] overwritten by temp_array[0] and temp_array[0] gets new result
                                       ie 0,1,1
                          [0,0,0]  now original[1] overwritten by temp_array[1] and temp_array[1] gets new result
                                       ie 0,1,0
                        ]
             * When row becomes 2 then we start copying the data in the manner shown above
             *
             *
             */         
            if (row >= 2) {
                board[row - 2][col] = temp_array[row_t][col];
                //printf("b[%d][%d] = %d ", row -2,col,board[row-2][col]);
                temp_array[row_t][col] = 0;                      
            }
            /* Conditions for alive and die based on the question */
            if (board[row][col] == 1) {

                if (total_ones < 2 || total_ones > 3) {
                    /* Die now */
                    temp_array[row_t][col] = 0; 
                    //printf("[%d][%d]=%d   ",row_t,col, temp_array[row_t][col]);
                } else if (total_ones == 2 || total_ones == 3){
                    /* Still Alive */
                    temp_array[row_t][col] = 1;     
                }
            } else {
                if (total_ones == 3) {
                    /* Lives again */
                    temp_array[row_t][col] = 1; 
                    //printf("[%d][%d]=%d   ",row_t,col, temp_array[row_t][col]);                 
                } else {
                    /* Die */
                    temp_array[row_t][col] = 0;
                }

            }
           // printf("\n");
        }
       // printf("\n***\%d %d %d %d %d, %d %d %d %d %d\n***\n", temp_array[0][0], temp_array[0][1], temp_array[0][2],temp_array[0][3], temp_array[0][4], temp_array[0][5], temp_array[1][0], temp_array[1][1], temp_array[1][2], temp_array[1][3], temp_array[1][4], temp_array[1][5]);
        //printf("\n");
    }
    /* Corner case handling : if only 1 row is there then update row so that we copy the results */
    if (row == 1) {
        row = row - 1;
    } else {
        row = row - 2;        
    }
    /* If there exists some row, then copy the remaining temp_array output to the original array */
    if (row >= 0)
    {
    do {
        /* toggle temp array index to get the correct data order */
        row_t = !row_t;
        for (col = 0; col < *boardColSize; col++) {
            board[row][col] = temp_array[row_t][col];            
        }
    } while(++row < boardSize);        
    }
    /* free memory */
    for (row = 0; row < 2; row++) {
        free(temp_array[row]);
    }
   
}


/* Main routine function */
int main(int argc, char *argv[]) {
    int *matrix[4] = {NULL,NULL,NULL,NULL};
    int arr1[3] = {0,1,0};
    int arr2[3] = {0,0,1};
    int arr3[3] = {1,1,1};
    int arr4[3] = {0,0,0};
    matrix[0] = arr1;
    matrix[1] = arr2;
    matrix[2] = arr3;
    matrix[3] = arr4;

    int matrixSize = 4;
    int matrixColSize = 3;
    int idx = 0, idx2 = 0;

    gameOfLife(matrix, matrixSize, &matrixColSize);
    /* print final data */
    for (idx = 0; idx < matrixSize; idx++) {
        for (idx2 = 0; idx2 < matrixColSize; idx2++) {
            printf("%d ", matrix[idx][idx2]);            
        }
        printf("\n");

    }
    printf("\n");

    return 0;
}

