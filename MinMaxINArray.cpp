//Find Min and Max in an array

//Linear Search - O(N) time and 4 comparisions per pair => 2N comparisions

//Two pointers:
Therefore only 3 comparisions for every pair
This means n/2 * 3 = 1.5 N comparisions totally 


vector<int> minMax(vector<int>& nums){
  int max = INT_MIN;
  int min = INT_MAX;
  for(int i=0;i<nums.size();i=i+2){
      if(nums[i]< nums[i+1]){
          max = max(nums[i+1],max);
          min = min(nums[i],min);
      }else{
           max = max(nums[i],max);
           min = min(nums[i+1],min);
      }
  }
  return {min,max};
}

//If odd number of elements, we can handle that last one seperately
