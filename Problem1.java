package Array2;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

	//4,3,2,7,8,2,3,1
    //1,2,2,3,3,4,7,8
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int ind=Math.abs(nums[i])-1;
            if(nums[ind]>0)
                nums[ind]*=-1;
        }
        
        for(int i=1;i<=nums.length;i++){
           if(nums[i-1]>0)
               res.add(i);
        }
        return res;
    }
	public static void main(String args[]) {
		int[] nums= new int[] {4,3,2,7,8,2,3,1};
		List<Integer> res= findDisappearedNumbers(nums);
		for(int c:res) {
			System.out.println(c);
		}
	}
}
