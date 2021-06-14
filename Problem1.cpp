 //Time complexity: O(n)
 //Space Complexity: O(1)
 
 void sortColors(vector<int>& nums) {
        int l = 0;
        int m = 0;
        int h = nums.size()-1;
        
        while(m<=h){
            if(nums[m]==0)swap(nums[l++], nums[m++]);
            else if(nums[m]==1)m++;
            else if(nums[m]==2)swap(nums[m], nums[h--]);
        } 
    }