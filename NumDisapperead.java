class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len= nums.length;
        int arr[] = new int[len];
        ArrayList<Integer> result= new ArrayList<>();
        Arrays.sort(nums);
        for (int i =1; i<= len; i++){
            arr[i-1]= -1;
            
        }
        for (int i =0; i< len; i++){
            
            arr[nums[i]-1]= 0;
        }
        int j=1;
        for (int i =0; i< len; i++){
            if(arr[i]==-1){
               result.add(i+1); 
            }
        }
        return result;
    }
}