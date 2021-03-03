//Time Complexity: O(n)
//Space: Constant O(1)
public class MinAndMax {
	
	public static void main(String []args)
	{
		int []nums = {4,5,1,6,3,10,2,15,21,12,-2,8, -4};
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length-1;i+=2)
		{
			if(nums[i]<nums[i+1])
			{
				if(min>nums[i])
					min = nums[i];		//first comparing i and i+1 values, if i is smaller comparing with min else max and vice versa.
				if(max<nums[i+1])		// So reducing comparisions by 0.5 times
					max= nums[i+1];
			}
			else
			{
				if(min>nums[i+1])
					min = nums[i+1];
				if(max<nums[i])
					max= nums[i];
			}
		}
		if(nums.length%2==1)
		{
			if(min>nums[nums.length-1])
				min = nums[nums.length-1];
			else if(max<nums[nums.length-1])
				max= nums[nums.length-1];
		}
		
		System.out.println(min);
		System.out.println(max);		
	}

}
