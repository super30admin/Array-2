import java.util.ArrayList;
import java.util.List;

//TC=O(n)
//SC=O(1)
public class MaxMinInArray {

    public List<Integer> findMaxMin(int[] nums){
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        int maxValue=nums[0];
        int minValue=nums[0];
        for(int i=1;i<n-1;i+=2){
            if(nums[i]>nums[i+1]){
                maxValue=Integer.max(maxValue,nums[i]);
                minValue=Integer.min(minValue,nums[i+1]);
            }
            else{
                maxValue=Integer.max(maxValue,nums[i+1]);
                minValue=Integer.min(minValue,nums[i]);
            }
        }
        if(n%2==0){
            maxValue=Integer.max(maxValue,nums[n-1]);
            minValue=Integer.min(minValue,nums[n-1]);
        }
        result.add(minValue);
        result.add(maxValue);

        return result;

    }

    public static void main(String[] args) {
        MaxMinInArray maxMinInArray=new MaxMinInArray();
        System.out.println(maxMinInArray.findMaxMin(new int[]{3, 5, 4, 1, 9}));
        System.out.println(maxMinInArray.findMaxMin(new int[]{3, 5, 4, 1, 9,11}));

    }
}
