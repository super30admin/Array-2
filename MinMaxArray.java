// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinMaxArray {

    public static List<Integer> findMinAndMax(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
         int n=nums.length;


        int maxValue=nums[0];
        int minValue=nums[0];
        for(int i=1;i<n-1;i+=2){  //taking pairs -> reduced the no of comparisions
            if(nums[i]>nums[i+1]){
                maxValue=Integer.max(maxValue,nums[i]);
                minValue=Integer.min(minValue,nums[i+1]);
            }
            else{
                maxValue=Integer.max(maxValue,nums[i+1]);
                minValue=Integer.min(minValue,nums[i]);
            }
        }
        if(n%2==0){   
            maxValue=Integer.max(maxValue,nums[n-1]);
            minValue=Integer.min(minValue,nums[n-1]);
        }
        result.add(minValue);
        result.add(maxValue);

        return result;
    }
    public static void main(String[] args) {
        int[] arr1= new int[]{1,2,3,4,5};  //even
        int[] arr2 = new int[]{12,65,32,54,21,89,23,90}; //odd
        List<Integer> list1 = findMinAndMax(arr1);
        List<Integer> list2 = findMinAndMax(arr2);
        System.out.println("The minimum element of arr1 is: "+list1.get(0)
                            +" "+" and the maximum element of arr1 is: "+list1.get(1));
        System.out.println("The minimum element of arr2 is: "+list2.get(0)
                           +" "+" and the maximum element of arr1 is: "+list2.get(1));

    }
}