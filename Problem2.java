package Array2;

//Given an array of numbers of length N, find both the minimum and maximum.
//Follow up : Can you do it using less than 2 * (N - 2) comparison

public class Problem2 {
	
	public static int[] minmax(int[] nums) {
		int[] res=new int[2];
		
		
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int i=1;i<nums.length;i++) {
			if(nums[i-1]<nums[i]) {
				min=Math.min(min,nums[i-1]);
				max=Math.max(max,nums[i]);
			}else {
				min=Math.min(min,nums[i]);
				max=Math.max(max,nums[i-1]);
			}
			
			
		}
		res[0]=min;
		res[1]=max;
				
		return res;
	}

	public static void main(String[] args) {
		int [] nums= new int[] {2,93,19,5,8,73,10};
		int[] res= minmax(nums);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
