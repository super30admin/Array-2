//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: no, didn't find the link
//Problems faced any: No


public class Problem31 {
    public int[] findMinMax(int[] nums){
        if(nums==null || nums.length==0)
            return new int[0];

        int min = nums[0];
        int max = nums[0];

        //This will do comparisions less than 2(n-1) because it is either checking max or min for each element
        for(int i=1; i<nums.length; i++){
            if(nums[i]>max)
                max = nums[i];
            else if(nums[i]<min)
                min = nums[i];
        }

        int[] arr = new int[2];
        arr[0] = max;
        arr[1] = min;
        return arr;
    }

    public static void main(String[] args){
        Problem31 p = new Problem31();
        int[] nums = {1,2,3,57,13};
        int[] result = p.findMinMax(nums);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
