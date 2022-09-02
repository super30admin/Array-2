# Array-2

## Problem1: Find All Numbers Disappeared in an Array

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        //null check
        if(nums == null || nums.length == 0)
            return result;

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            else{
                nums[i] *= -1;
            }
        }
        return result;
    }
}
```

## Problem2 Find Minimum and Maximum 

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MinMax {

    /* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;
        /* If array has even number of elements then 
    initialize the first two elements as minimum and 
    maximum */
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
            /* set the starting index for loop */
        } /* If array has odd number of elements then 
    initialize the first element as minimum and 
    maximum */ else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
            /* set the starting index for loop */
        }
 
        /* In the while loop, pick elements in pair and 
     compare the pair with max and min so far */
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
            /* Increment the index by 2 as two 
               elements are processed in loop */
        }

        return minmax;
    }

    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }
}
```
## Problem3 Game of Life

```Java
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int m;
    int n;
    int[][] dir;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        if (board == null || board.length == 0)
            return;

        dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        //0->1->2
        //1->0->3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = countAlive(board, i, j);
                if (board[i][j] == 1 && (countAlive < 2 || countAlive < 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    private int countAlive(int[][] board, int i, int j) {
        int result = 0;
        for (int[] dirs : dir) {
            int newRow = i + dirs[0];
            int newCol = j + dirs[1];

            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n &&
                    (board[newRow][newCol] == 1 || board[newRow][newCol] == 3)) {
                result++;
            }
        }
        return result;
    }
}
```