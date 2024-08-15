import java.util.ArrayList;
import java.util.List;

public class DissapearedNum {
    public List<Integer> disapearedNum(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int currNum=Math.abs(nums[i]);
            int idx=currNum-1;
            if(nums[idx]>0){
                nums[idx]*=-1;

            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        DissapearedNum d=new DissapearedNum();
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> result=d.disapearedNum(nums);
        System.out.println(result);
    }
}
