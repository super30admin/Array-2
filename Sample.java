// Time Complexity : O(n) as we will be iterating over whole array.
// Space Complexity : O(1) as we are not using extra space to store anything other than input and output.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// In this problem we have given that array has only positive numbers in it. So, what we can do here is we will check the first number in array and we will go to 
// that index and multiply number stored there by -1. If we keep on doing that then all the numbers in the array will be negative except the indices which are
// missing as an element in the array. Then we can again loop through the array and if the number is less than 0 then we will again multiply it with -1 to 
// restore the original array otherwise we will store those indices in our output array.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (nums == null || n == 0) {
            return result;
        }

        for(int i = 0; i < n; i++) {
            int currNum = Math.abs(nums[i]);
            int idx = currNum - 1;

            if(nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                nums[i] = nums[i] * -1;
            } else {
                result.add(i+1);
            }
        }

        return result;
    }
}



// Time Complexity : O(n) as we are iterating through all the elements in the array.
// Space Complexity : O(1) as we are not using extra space to store anything other than input and output.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Here we can solve this example by simple brute-force solution and comparing the stored minimum and maximum values but the main challenge is we need to do it 
// in less than n*2 comaprisions. For that we can do is hop the list 2 elements at a time. We will keep the pointer index on one element and check which element 
// among these two is largest and then check the largest element with max and smallest element with min. In this way we will need 3 comparisions per 2 elements.
// So we reduced comparisions from 2*n to 1.5*n. If the list has odd number of element we can make the final element comparision at the end.
class Solution {
    public Pair<Long, Long> getMinMax(int[] arr) {
        // Code Here
        
        if(arr == null || arr.length == 0) {
            return new Pair<>((long)0, (long)0);
        }
        
        if(arr.length == 1) {
            return new Pair<>((long)arr[0], (long)arr[0]);
        }

        int n = arr.length;
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n - 1; i = i + 2) {
            // System.out.println(i);
            if(arr[i] > arr[i+1]) {
                // System.out.println("First element larger");
                if(arr[i] > max) {
                    max = arr[i];
                }
                if(arr[i+1] < min) {
                    min = arr[i+1];
                }
            } else {
                // System.out.println("Second element larger");
                if(arr[i+1] > max) {
                    max = arr[i+1];
                }
                if(arr[i] < min) {
                    min = arr[i];
                }
            }
        }
        
        if (n%2 != 0) {
            if(arr[n-1] > max) {
                max = arr[n-1];
            }
            if (arr[n-1] < min) {
                min = arr[n-1];
            }
        }
        
        return new Pair<>(min, max);
    }
}



// Time Complexity : O(m*n) as we will be traversing through all elements in the matrix.
// Space Complexity : O(1) as we are not using extra space to store anything other than input and output.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// The main idea here is we know that the elements in the matrix are either 0 or 1. We know that we have to check 8 cells in the neighbourhood. So, to go to that 
// cell from current cell we can store directions array where we can store the row and column indices that needs to be increased or decreased. Now to calculate
// alive cells around each cell we can have a separate function in which we will pass the current cell and go through directions array and check if that cell is 
// 1 or 4. The idea behind checking 4 is we want in-place modification. So, we whenever we want to change 1 to 0 we will assign it to 4 to remember that this 
// element was previously 1 and now it's 0 and for 0 to 1 we will store 3. While counting alives we will keep track of boundary conditions as well. Then in the 
// nested for loop we will simply check if the current cell is 1 and if the number of alives around it is more than 3 (over-crowded) or less than 2 (under-crowded)
// then to make it 0 we will change it to 4. Otherwise if current cell is 0 and neighbourhood alives are 3 then we will change it to 3. At the end we will again 
// run nested for loop and make all 3s as 1 and all 4s as 0.
class Solution {
    public void gameOfLife(int[][] board) {
        // 0 --> 1 - 3
        // 1 --> 0 - 4

        if(board == null) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][] 
        {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int alives = countAlives(board, i, j, dirs, m, n);
                
                if(board[i][j] == 1) {
                    if (alives > 3 || alives < 2) {
                        board[i][j] = 4;
                    }
                } else {
                    if (alives == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                } 
                if (board[i][j] == 4){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countAlives(int[][] board, int r, int c, int[][] dirs, int m, int n) {
        int count = 0;
        
        for(int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && 
            (board[nr][nc] == 1 || board[nr][nc] == 4)){
                count = count + 1;
            }
        }

        return count;
    }
}
