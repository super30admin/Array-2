//Time: O(n), Space:O(1)
function min_max(nums){
    let min= Number.POSITIVE_INFINITY;
    let max = Number.NEGATIVE_INFINITY;
    if(nums.length == 0) return 0;
    for(let i=0;i<nums.length;i++){
        if(nums[i] > nums[i+1]){
            min = Math.min(min,nums[i+1])
            max = Math.max(max,nums[i])
        }else{
            min = Math.min(min,nums[i])
            max = Math.max(max,nums[i+1])
        }
    }
    return [min,max]
}