/*
 * 289. Game of Life
 * 
 * Time Complexity : O()
 * Space Complexity :O()
 * Board:
 * 		2 stands for uninitialized
 * 		1 for live
 * 		0 for dead
 * 
 * */
import java.util.*;
public class GameOfLife {

	public static int[][] gameOfLife(int[][] nums) {
		int [][] newBoard = {
				{2,2,2},
				{2,2,2},
				{2,2,2},
				{2,2,2}
				};
	
		

		/*Any live cell with fewer than two live neighbors dies as if caused by under-population. */
		
		
		
		
		/* Any live cell with two or three live neighbors lives on to the next generation. */
		
		
		
		
		/* Any live cell with more than three live neighbors dies, as if by over-population.*/
		
		
		
		
		/*Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.*/
		
		
		
		
		return newBoard;

	}
	
	
	/*Helper Functions*/
	//check Vertical
	public static int vertical(int[][] top) {
		int count = 0;
		for(int i =0 ; i < top.length; i++) {
			for(int j =0 ; j < top[i].length; j++) {
				if(top[i-1][j] == 1) {
					count++;
				}
				if(top[i+1][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}
	
	//check Horizontal
	public static int horizontal(int[][] top) {
		int count = 0;
		for(int i =0 ; i < top.length; i++) {
			for(int j =0 ; j < top[i].length; j++) {
				if(top[i][j-1] == 1) {
					count++;
				}
				if(top[i][j+1] == 1) {
					count++;
				}
			}
		}
		return count;
	}
	
	//check LeftDiagonal
	public static int leftdiagonal(int[][] top) {
		int count = 0;
		for(int i =0 ; i < top.length; i++) {
			for(int j =0 ; j < top[i].length; j++) {
				if(top[i-1][j-1] == 1) {
					count++;
				}
				if(top[i+1][j+1] == 1) {
					count++;
				}
			}
		}
		return count;
	}
	
	//check rightDiagonal
		public static int rightdiagonal(int[][] top) {
			int count = 0;
			for(int i =0 ; i < top.length; i++) {
				for(int j =0 ; j < top[i].length; j++) {
					if(top[i-1][j+1] == 1) {
						count++;
					}
					if(top[i+1][j-1] == 1) {
						count++;
					}
				}
			}
			return count;
		}
	
	
	
	public static void main(String[] args) {
		
		
		
		int [][] board = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}};
		
		System.out.println("result : " + gameOfLife(board));
		
	}
	

	
	
	
}












