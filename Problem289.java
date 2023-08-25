import java.util.ArrayList;
import java.util.List;

public class Problem289 {
//TC=O(n)
//SC=O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int indx=Math.abs(nums[i])-1;
            if(nums[indx]>0)
                nums[indx]*=-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            else
                nums[i]*=-1;
        }

        return result;

    }
    public static void main(String[] args) {
        Problem289 problem = new Problem289();
        System.out.println(problem.findDisappearedNumbers(new int[]{7,5,3,9,7,10,2,2,4,3}));
    }
}
