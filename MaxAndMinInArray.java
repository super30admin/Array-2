// Time Complexity : O(1.5*n)
// Space Complexity : O(1)


// Approach:
// We take the elements in pairs. By iterating through the array we check if the current element is < the next element. 
// If so, then we compare the current element with current minimum and the next element with current maximum.
// Reverse this for the else condition. For iteration we use for loop and skip by 2 indices.
// Since we traverse in pairs, there might be an element which might be single at the end of the array.
// We handle that after the iteration.

class MaxAndMinInArray {
    private int[] search(int nums[]) 
    { 
	    int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i=0; //We need to keep i for later to check if a single element exists after the pairs
        for(i=0;i+1<nums.length;i=i+2){
            if(nums[i]<nums[i+1]){
                min=Math.min(min,nums[i]);
                max=Math.max(max,nums[i+1]);
            } 
            else {
                min=Math.min(min,nums[i+1]);
                max=Math.max(max,nums[i]);
            }
        }
        // if a single non-pair element remains
        if(i==nums.length-1){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        return new int[] {min,max};
        
    }

    public static void main(String args[]) 
    { 
        MaxAndMinInArray f = new MaxAndMinInArray(); 
        int nums[] = {1,2,-1,2,3,4,5,7,-8}; 
        int[] result = f.search(nums);
        System.out.println("Min: "+result[0]);
        System.out.println("Max: "+result[1]);
    } 
}
