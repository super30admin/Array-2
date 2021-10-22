//Time: O(n)
//Space: O(1)
//Leetcode: https://leetcode.com/submissions/detail/575560434/
//1. If a value is found in an array, the value at the correct index of current element is negated.
//2. The array is traversed to see which index contains values that are not negated. They contain out actual values.

using System;
using System.Collections.Generic;

namespace numbersDisappearedInArray
{
    class Program
    {
        public static IList<int> FindDisappearedNumbers(int[] nums) {
        
            List<int> result = new List<int>();
            
            for(int i=0; i < nums.Length; i++){
                //taking absolute as it might contain negative value by the negation operation that we did.
                int currentElementIndex = Math.Abs(nums[i]) - 1;
                if(currentElementIndex < nums.Length) {
                    if(nums[currentElementIndex] > 0)
                        nums[currentElementIndex] = 0 - nums[currentElementIndex];
                }
            }
            
            for(int i=0; i< nums.Length; i++) {
                if(nums[i] > 0) {
                    result.Add(i+1);
                }
            }
            return result;
        }

        static void Main(string[] args)
        {
            int[] nums = new int[]{4,3,2,7,8,2,3,1};
            List<int> result = new List<int>(Program.FindDisappearedNumbers(nums));
            foreach(int i in result) {
                Console.Write(i + " ");
            }
        }
    }
}
