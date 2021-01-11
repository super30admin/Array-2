// time complexity : O(n)
// space complexity : O(n)
package ThirdWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0) return new ArrayList<>();
        int idx = 0;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) -1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }


System.out.println(Arrays.toString(nums));


        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                li.add(i+1);
            } else{
                nums[i]*=-1;
            }

        }
        return li;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,3,2,7,8,2,3,1};

        List<Integer> li = findDisappearedNumbers(arr);
        System.out.println(li.toString());
    }

}
