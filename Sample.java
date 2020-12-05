Q1)
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// The code relies on visiting the array and marking it as negative a duplicate value will cause a cycle 
// and the make a disconnect. The disconnected ones will remain positive at the end of the interation
// we just add and return the result.

Q2)
// Time Complexity : O(3N/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not on leetcode Geeks for geeks
// Any problem you faced while coding this : Yes (could not come up with approach)


// Your code here along with comments explaining your approach
// The max min in a normal way will take 3 comparisions for a pair one between them, one with min and one with max
// this becomes equal to 3*(N/2) comparisions rather than 2(N-2) comparisions.


Q3)
// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// This is a state change problem we transform live cells and dead cells of next stage using some positive numbers
// this helps us count neighbours without copying the array resulting in inplace computation.
