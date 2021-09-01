import java.util.List;
import java.util.ArrayList;
public class Array {
    //time complexity : N
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    //448. Find All Numbers Disappeared in an Array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i : nums){
            if(nums[Math.abs(i)-1] > 0){
                nums[Math.abs(i)-1]=nums[Math.abs(i)-1]*(-1);
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i]=nums[i]*(-1);
            }
        }
        return result;

    }
    // time complexity : MN
    // space complexity : 1
    // did it run on leetcode: yes
    // any doubts : no 
    //https://leetcode.com/problems/game-of-life/
    //289. Game of Life
    //live -- <2 neighbour -- dead 
    //live -- >3 neighbour -- dead
    // dead -- 3 neighbour -- alive
    // live (1) -- dead (0) -- 3
    // dead(0) -- live (1)  -- 2
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                int alive = countalive(board,i,j);
                if(board[i][j] == 1 && (alive <2 || alive >3)){
                    board[i][j]=3;
                
                }
                if(board[i][j] == 0 && alive ==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]==3){
                    board[i][j]=0;
                }
                if(board[i][j]==2){
                    board[i][j]=1;
                }
            }
        }


    }
    private int countalive(int[][] board,int i,int j){
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        int nr=0;
        int nc = 0;
        for(int[] k : dir){
            nr = i + k[0];
            nc = j + k[1];
            if(nr >=0 && nc >=0 && nr<m && nc <n && (board[nr][nc]==1 || board[nr][nc]==3 )){
                count++;
            }
        }
        return count ;
    }
    // time complexity : N
    // space complexity : 1
    // any doubts : no
    // number of comparisons: 1.5N -2 < 2*(N-2)
   // https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
   //Maximum and minimum of an array using minimum number of comparisons
   public static int[] getminmax(int[] arr){
       if(arr== null || arr.length ==0) return new int[]{};
       int min = arr[0];
       int max = arr[0];
        if(arr.length %2 ==0){
            for(int i =1;i<arr.length-1;i=i+2){
                if(arr[i]>arr[i+1]){
                    min= Math.min(min,arr[i+1]);
                    max =Math.max(arr[i],max);
                }else{
                    min= Math.min(min,arr[i]);
                    max =Math.max(arr[i+1],max);
                }
                min= Math.min(min,arr[arr.length-1]);
                max =Math.max(arr[arr.length-1],max);
            }
            
        }else{
            for(int i =1;i<arr.length;i=i+2){
                if(arr[i]>arr[i+1]){
                    min= Math.min(min,arr[i+1]);
                    max =Math.max(arr[i],max);
                }else{
                    min= Math.min(min,arr[i]);
                    max =Math.max(arr[i+1],max);
                }
            }
        }
    
           
        
        return new int[]{min,max};
   }

   public static void main(String[] args){
    int [] arr = {1,6,3,4,5};
    int [] result = getminmax(arr);
    System.out.println(result[0]+" "+ result[1]);
   }

}
