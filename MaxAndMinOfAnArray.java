//Approach - 1: Compare by pairs
//Time Complexity : O(n)
//Space Complexity : O(1)

public class Main {
    public static void main(String[] args) {
        int [] nums = new int[] {1,-3,4,6,8,-7,1,2};
        int max = 0; int min = 0;
        for(int i=0; i<nums.length-1; i++){
          if(nums[i] > nums[i+1]){
              max = Math.max(max, nums[i]);
              min = Math.min(min, nums[i+1]);
          }
      else{
          max = Math.max(max, nums[i+1]);
          min = Math.min(min, nums[i]);     
      }
    }
    System.out.println(max);
    System.out.println(min); 
    }
}
