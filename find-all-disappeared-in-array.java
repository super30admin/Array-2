// Time Complexity : O(N)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;
class Main{
	public static void main(String []args){
		int []nums={4,3,2,1,7,8,2,8};
		System.out.println("The missing numbers are :  " +findMissing(nums));	
}	
public  static List<Integer> findMissing(int []nums){
	if(nums==null || nums.length==0){
		return new ArrayList<>();
    }
ArrayList <Integer> al=new ArrayList<>();
for(int i=0;i<nums.length;i++){
	int index=Math.abs(nums[i])-1;
	if(nums[index] > 0){	
		nums[index] *= -1;
}
}
for(int i=0; i<nums.length; i++){
	if(nums[i]>0){
		al.add(i+1);
}
}
return al;
}
}
