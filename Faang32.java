//time complexity = o(n)
//space complexity=o(n)

package leetcode;

import java.util.ArrayList;
import java.util.List;

class Faang32 {
    public List<Integer> findMinMax(int[] nums){
        List<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int k=0;
        if(!(nums.length%2==0)){
            k=1;
            min=nums[0];
        }
        for(int i=k;i<nums.length;i+=2){
            if(nums[i]>nums[i+1]){
                max=Math.max(max,nums[i]);
                min=Math.min(min,nums[i+1]);
            }else{
                max=Math.max(max,nums[i+1]);
                min=Math.min(min,nums[i]);
            }
        }
        list.add(min);
        list.add(max);
        return list;
    }

    public static void main(String[] args) {
        int[] nums ={12,3,4,5,2,1,81,2,1};
        Faang32 obj = new Faang32();
        System.out.println(obj.findMinMax(nums));

    }
}
