/*
Time complexity:
If n is odd  3(n-1)/2. If n is even there is 1 comparison for initializing the 
value sof minimum and maximum and 3(n-2)/2 comparisons will be for the rest of
the elements 
*/

/*
Space Complexity:
The space complexity is O(1) as we are not creating any extra space.
*/

/*
Approach:
We are comapring the elements in pairs. There will be two cases dependinng on
the number of elements in the array. If they are odd then we have to initialize
the min and max as first elements, otherwise they will be set as min the first element
and the max as the second element of the array. Now for the rest of the elements, we keep
on comapring them with the running max and minimum so far. The advantage of this method
is that in the loop in one iteration we are checking two indexes which makes a considerable
difference.
*/

// The code ran perfectly.


class Solution{

public:
vector<int> minMax(vector<int> nums){
    vector<int> result;
    int n = nums.size();
    int min =0;
    int max = 0;
    int i = 0;
    if(n%2 == 0){
        if(nums[0]>nums[1]){
            min = nums[1];
            max = nums[0];

        } else {
            min = nums[0];
            max = nums[1];
        }
        i = 2;
    } else {
        min = nums[0];
        max = nums[0];
        i = 1;
    }

    while(i <n-1){
        if(nums[i]>nums[i+1]){
            if(nums[i]>max) max = nums[i];
            if(nums[i+1]<min) min = nums[i+1];
        } else {
            if(nums[i+1]>max) max = nums[i+1];
            if(nums[i]<min) min = nums[i];
        }
        i+=2;    
    }

    result.push_back(min);
    result.push_back(max);
    return result;
}
};