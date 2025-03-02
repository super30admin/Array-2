public class DissapearedNum {
    public List<Integer> disapearedNum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currNum = Math.abs(nums[i]);
            int idx = currNum - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;

            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
public class GameofLife {
    public void gameofLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(board, i, j, dirs);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }

                } else {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    public int countAlive(int[][] board, int i, int j, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}

public class MinMax {
    public static void main(String[] args) {
        int[] arr={4,-3,2,1,7,0,1,3,2};
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];

            }
        }
        System.out.println(min);
        System .out.println(max);

    }
}
