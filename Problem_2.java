
public class Problem_2 {

	public static void main (String[] args) {
		System.out.println("GfG!");
		
		int[] nums = {10, 23, 34, 45, 4, 89, 90};
		int min = nums[0];
		int max = nums[0];
		
		for(int i=1; i<nums.length; i++){
		    if(i == nums.length -1){
		        min = Math.min(min, nums[i]);
		        max = Math.max(max, nums[i]);
		    }else if(nums[i] < nums[i+1]){
		        min = Math.min(min, nums[i]);
		        max = Math.max(max, nums[i+1]);
		    }else{
		        min = Math.min(min, nums[i+1]);
		        max = Math.max(max, nums[i]);
		    }
		}
		
		System.out.println(min);
		System.out.println(max);
	}
}
