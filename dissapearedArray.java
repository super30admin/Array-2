// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

import java.util.List;
import java.util.ArrayList;

class dissapearedArray {
       public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> result= new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]=nums[index] * -1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            else{
                nums[i]=nums[i] * -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    dissapearedArray rs = new dissapearedArray();
    int[] matrix1 = {4,3,2,7,8,2,3,1};
    int[] matrix2 = {1,1};
    System.out.println(rs.findDisappearedNumbers(matrix1));  // ans = [5,6]
    System.out.println(rs.findDisappearedNumbers(matrix2));  // ans = [2]
}

}