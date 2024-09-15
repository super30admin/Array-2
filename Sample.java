import java.util.*;

class Sample {

    
    // Time Complexity : O(N) where N is size of the array
    // Space Complexity : O(1) 
    // Any problem you faced while coding this : No

    // Problem 1
    /**
     * 1. Since all the numbers are present in sequence, mark the element nums[nums[i] - 1] as negative.
     * 2. Then traverse through the array again and the numbers which are positive, their (index + 1) is missing.
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }
        
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] > 0)
                list.add(i+1);
        }
        
        return list;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Any problem you faced while coding this : No

    // Problem 2
    /**
     * 1. Number of comparisons : 3*N/2
     * 2. Compare between the pairs.
     * 3. Value which is greater in the pair, compare that with max value and update max value.
     * Similarly check for min value.
     */

    public static void findMinMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // for(int n : nums) {
        //     min = Math.min(min, n);
        //     max = Math.max(max, n);
        // }

        int size = nums.length;

        if(size == 1) {
            min = nums[0];
            max = nums[0];
            System.out.println("Minimum is :" + min);
            System.out.println("Maximum is :" + max);
            return;
        }

        int i = 0;

        if(size % 2 == 0) {
            if(nums[0] > nums[1]) {
                min = nums[1];
                max = nums[0];
            }
            else {
                min = nums[0];
                max = nums[1];
            }
            i = 2;
        }
        else {
            min = nums[0];
            max = nums[0];

            i = 1;
        }

        while(i < size-1){
            if(nums[i] > nums[i+1]) {
                if(nums[i] > max) {
                    max = nums[i];
                }
                if(nums[i-1] < min) {
                    min = nums[i-1];
                }
            }
            else {
                if(nums[i-1] > max) {
                    max = nums[i-1];
                }
                if(nums[i] < min) {
                    min = nums[i];
                }
            }
            i += 2;
        }

        System.out.println("Minimum is :" + min);
        System.out.println("Maximum is :" + max);
    }

    // Time Complexity : O(R*C)  
    // Space Complexity : O(1) 
    // Any problem you faced while coding this : No

    // Problem 3
    /**
     * Track the change of element (live or dead) in matrix.
     * 1. For example here: if cell changes from live to dead (1 -> 0), change value to 7.
     * and if cell changes from dead to live (0 -> 1), change value to 8.
     * 2. Use the changed values while calulating number of live neightbours.
     * 3. At the end, revert the values to 1 or 0, based on its values 7 or 8. For example if it's 8, its new values 
     * is 1 and if it's 7, new value is 0.
     */

    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int columns = board[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                int liveCount = getLiveNeighbour(board, i, j);
                
                if(board[i][j] == 1) {
                    if(liveCount < 2 || liveCount > 3) {
                        board[i][j] = 7;
                    }
                }
                else {
                    if(liveCount == 3) {
                        board[i][j] = 8;
                    }
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j] == 7)
                    board[i][j] = 0;
                if(board[i][j] == 8)
                    board[i][j] = 1;
            }
        }
        
    }
    
    private int getLiveNeighbour(int[][] board, int i, int j) {
        
        int count = 0;
        int rows = board.length;
        int columns = board[0].length;  
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        
        for(int[] d: dirs) {
            int r = i + d[0];
            int c = j + d[1];
             
            if(r >= 0 && c >= 0 && r < rows && c < columns && (board[r][c] == 1 || board[r][c] == 7)) {
                count++;
            }
        }
        
        return count;
        
    }


    public static void main(String args[]) {
        findMinMax(new int[]{4,6,2,7,8,9,0,2});
    }

}

