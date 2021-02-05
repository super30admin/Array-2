import java.util.ArrayList;
import java.util.List;

class NumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> output= new ArrayList<>();

        for(int x : nums){
            int index = Math.abs(x)-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }

        for(int x=0;x<nums.length;x++){
            if(nums[x]>0){
                output.add(x+1);
            }
        }
        return output;
    }
}


//time complexity=  o(n)
//space complexity= o(1)