import java.util.ArrayList;
import java.util.List;

class DisappearedNumInArray {
    //TC will be O(n) as just going over array of n size
    //SC will be O(1), as return the arraylist and storing values in it.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();     //result arraylist
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]>0){
                nums[index] = nums[index] * -1;
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i]>0){
                result.add(i + 1);
            }
            else{
                nums[i] = nums[i] * -1;
            }
        }
        return result;
    }


    public static void main(String[] args){
        DisappearedNumInArray obj = new DisappearedNumInArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(obj.findDisappearedNumbers(nums));
    }
}