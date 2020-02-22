// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : COuldn't solve before class


// Your code here along with comments explaining your approach:

//Allocate the first element as max and min both if the array length is odd else
//take the combination of 0 and 1 index to find max and min.
//then for next 2 pairs computer max and min within themselves and with the max and min variables.

    private int[] computerMaxMix(int[] arr){
    //initializing max, min pointers.
        int min, max;
        int index; // initializing index
        
        n = arr.length;
        
        //compute odd or even to find initial max, min
        if(n%2 == 1){//odd case
            min = arr[0];
            max = arr[0];
            index = 1;
        }else{//even case
            min = Math.min(arr[0], arr[1]);
            max = Math.min(arr[0], arr[1]);
            index = 2;
        }
        
        //loop over array-1 elements to find next max, min from the next two pairs(Remember to increase i by 2)
        for(int i=index; i<arr.length-1; i+2){
            if(arr[i] > arr[i+1]){
                min = Math.min(min, arr[i+1]);
                max = Math.min(min, arr[i]);
            }else{
                min = Math.min(min, arr[i]);
                max = Math.min(max, arr[i+1]);
            }
        }
        
        return new int[]{max, min};
    }