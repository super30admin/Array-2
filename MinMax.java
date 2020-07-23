//Time Complexity :O(n)
//Space Complexity:O(1)
/*Approach
-Taking pairs of nuumbers
-if even length initializing min and max as first two numbers
-if odd initializing min and max both as first number
-forming pairs of rest and comparing smallest out of them with min if more smaller updating min
-similarily comparing larger out of them to max if more larger updating max
 */
import java.util.ArrayList;
import java.util.List;

public class MinMax {
    public static List<Integer> findMinMax(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        int min, max;
        int i = 0;
        if(nums.length%2 ==0){
            if(nums[0]>nums[1]){
                max= nums[0];
                min= nums[1];
            }
            else{
                max= nums[1];
                min = nums[0];
            }
            i = 2;
        }
        else{
            max = nums[0];
            min = nums[0];
            i = 1;
        }
        
        for(int j=i; j < nums.length - 1; j+=2){
            if(nums[j]<nums[j+1]){
                if(nums[j]<min){
                    min = nums[i];
                }
                if(nums[j+1]>max){
                    max = nums[j+1];
                }
            }
            else{
                if(nums[j]>max){
                    max = nums[j];
                }
                if(nums[j+1]<min){
                    min = nums[j+1];
                }
            }
        }
        result.add(min);
        result.add(max);
        return result;

    }
    public static void main(String args[]){
        System.out.println(findMinMax(new int[]{5,4,3,2,1,8,9}));
        System.out.println(findMinMax(new int[]{}));
        System.out.println(findMinMax(new int[]{6,4,5,2,1}));

    }
}