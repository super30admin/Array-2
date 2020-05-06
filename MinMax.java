// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    private int mainSearch(int l, int h, int[]nums, int target){
        if(l>h)
            return -1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target)
                return m;
            else if(nums[l]<=nums[m]){
                if(nums[l]<=target && nums[m]>=target)
                    h=m-1;
                else
                    l=m+1;
            }
            else{
                if(nums[m]<=target && nums[h]>=target)
                    l=m+1;
                else
                    h=m-1;
            }
        }
        return mainSearch(l,h,nums,target);
    }
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int l=0,h=nums.length-1;
        if(nums[l]>target && nums[h]<target)
            return -1;
        if(nums[l]==target)
            return l;
        if(nums[h]==target)
            return h;
        return mainSearch(l,h,nums,target);
    }
}






Snehal(opens in new tab)  11:10 PM
package com.company;
public class Main {
    static int min,max;
    private static void findMain(int[] arr){
        int index=0;
        int len = arr.length;
        if(len%2==0){
            if(arr[0]>arr[1]){
                min=arr[0];
                max=arr[1];
            }else{
                min=arr[1];
                max=arr[0];
            }
                index=2;
        }else{
            min=max=arr[0];
            index=1;
        }
        while(index<len){
            if(arr[index]>arr[index+1]){
                if(arr[index]>max)
                    max=arr[index];
                if(arr[index+1]<min)
                    min=arr[index+1];
            }else{
                if(arr[index+1]>max)
                    max=arr[index+1];
                if(arr[index]<min)
                    min=arr[index];
            }
            index+=2;
        }
    }
    public static void main(String[] args) {
	// write your code here
        int[] arr = {8,7,6,5,4};
        findMain(arr);
        System.out.println(min +" : "+max);
        int[] arr1 = {3,4,5,6,7};
        findMain(arr1);
        System.out.println(min +" : "+max);
        int[] arr2 = {-1,-2,-3,-4,-5,-6,-7};
        findMain(arr2);
        System.out.println(min +" : "+max);
    }
}