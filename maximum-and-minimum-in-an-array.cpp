//Time Complexity - O(n)
//Space complexity - O(1)

class Solutions {
	pair<int,int> minMax(vector<int> nums){
		int Min , Max;

		if(nums[0]>nums[1]){
			Min = nums[1];
			Max = nums[0];
		} else{
			Min = nums[0];
			Max = nums[1];
		}

		for(int i=2;i<nums.size()-1;i+2){
			if(nums[i]>nums[i+1]){
				Min = min(Min,nums[i+1]);
				Max = max(Max,nums[i]);
			} else {
				Min = min(Min,nums[i]);
				Max = max(Max,nums[i+1]);
			}
		}

		if(nums.size()%2==1){
			Min = min(Min,nums[nums.size()-1]);
			Max = max(Max,nums[nums.size()-1]);
		}

		return make_pair(Min,Max);
	}
}