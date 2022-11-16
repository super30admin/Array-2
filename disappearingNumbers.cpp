// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes

/* 
Approach: 
[4,3,2,7,8,2,3,1]
Iterate over the array, use the nbumber as index and make it negative (using that as a marker of seen basically)

1. 
nums[0] = 4
abs(4)-1 = 3
nums[3] -> mkae it negative
[4,3,2,-7,8,2,3,1]

2. 
nums[1] = 3
abs(3)-1 = 2
nums[2] if positive, make negtaive 
[4,3,-2,-7,8,2,3,1]

3. 
nums[2] = -2
abs(-2)-1 = 1
nums[1] if positive, make negtaive 
[4,-3,-2,-7,8,2,3,1]

4. 
nums[3] = -7
abs(-7)-1 = 6
nums[6] if positive, make negtaive 
[4,-3,-2,-7,8,2,-3,1]

5. 
nums[4] = 8
abs(8)-1 = 7
nums[7] if positive, make negtaive 
[4,-3,-2,-7,8,2,-3,-1]

6. 
nums[5] = 2
abs(2)-1 = 1
nums[1] is negative, don't change
[4,-3,-2,-7,8,2,-3,-1]

7. 
nums[6] = -3
abs(-3)-1 = 2
nums[2] is negative, don't change
[4,-3,-2,-7,8,2,-3,-1]

8.
nums[7] = -1
abs(-1)-1 = 0
nums[0] is positive, make it negative
[-4,-3,-2,-7,8,2,-3,-1]

Now, if the number is negative, that means that index was in the array
We saw that index+1 in the array, came back to it and marked it -ve
If it's positive, that means we didn't see that index+1 and that should be our result
*/


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.size() == 0)
            return vector<int>();

        vector<int> result;
        for(int i=0; i<nums.size(); i++){
            if (nums[abs(nums[i])-1] > 0)
                nums[abs(nums[i])-1] *= -1;
        }

        for(int i=0; i<nums.size(); i++){
            if(nums[i] > 0)
                result.push_back(i+1);
        }
        return result;
    }
};