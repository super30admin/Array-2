public class FindAllDisappearedNumbers {

// We use each number in the array to mark its corresponding index negative.
// If any index remains positive, it means that number was missing from the array.
// So we collect all those index+1 values as the result.

// Time Complexity:
// O(n)

// Space Complexity:
// O(1)
    public IList<int> FindDisappearedNumbers(int[] nums) {
        List<int> list = new List<int>();
        int n = nums.Length;
        for(int i=0;i<n;i++)
        {
            int index = Math.Abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i] > 0)
               list.Add(i+1);
        }
        return list;
    }
}
