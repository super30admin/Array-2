//Time complexity: O(n) Number of comparsions will be 3n/2
//Space complexity: O(1)


public static void MinMax(int[] nums){
    int min=Integer.MAX_VALUE;;
    int max=Integer.MIN_VALUE;
    if(nums.length==1){
        min=nums[0];
        max=nums[1];
        System.out.println("min is " + min + "  and max is " + max);
    }

    if(nums[0]<nums[1]){
        max=nums[1];
        min=nums[0];
    }
    else{
        max=nums[0];
        min=nums[1];
    }
    int i=2;
    for(int i=2;i<=a.length-2;i=i+2){
        if (nums[i] > nums[i + 1]) {
			min = Math.min(min, nums[i + 1]);
			max = Math.max(max, nums[i]);
		} else {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i + 1]);
		}
    }
    if(nums.length%2==1){
        min=Math.min(min,nums[nums.length-1]);
        max=Math.max(max,nums[nums.length-1]);
    }
    System.out.println("min is " + min + "  and max is " + max);

}