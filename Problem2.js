// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not available on Leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach ß

function getMinMax(arr){
    let mx,mn,i;
     
    // If array has even number of elements then
    // initialize the first two elements as minimum
    // and maximum
    if(arr.length % 2 == 0){
        mx = Math.max(arr[0], arr[1]);
        mn = Math.min(arr[0], arr[1]);
         
        // set the starting index for loop
        i = 2;
    }
         
    // If array has odd number of elements then
    // initialize the first element as minimum
    // and maximum
    else{
        mx = mn = arr[0];
        // set the starting index for loop
        i = 1;
    }
         
    // In the while loop, pick elements in pair and
    // compare the pair with max and min so far
    while(i < arr.length - 1){
        if(arr[i] < arr[i + 1]){
            mx = Math.max(mx, arr[i + 1]);
            mn = Math.min(mn, arr[i]);
        }
        else{
            mx = Math.max(mx, arr[i]);
            mn = Math.min(mn, arr[i + 1]);
        }
             
        // Increment the index by 2 as two
        // elements are processed in loop
        i += 2
    }
     
    return [mx, mn];
}
     
// Driver Code
     
let arr = [1000, 11, 445, 1, 330, 3000]
console.log("Minimum Element is", getMinMax(arr)[1]);
console.log("Maximum Element is", getMinMax(arr)[0]);

