
//DisappearedNo Using Variable
// Time Complexity : O(nlogn) sorting and checking
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didnt run on all test cases


// Your code here along with comments explaining your approach

//I took a random variable which increment from 1 to N and start comparing with
//given array


///////////////////////////////////////////////////////////////////////////////

//DisappearedNo Using Index (State Change)
// Time Complexity : O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Taking absolute val of particular element i.e.nums[i] and subtract with 1 
// so will get that particular index and mark that negative indicating that element is present in that array
// if there is duplicate, and its already marked negative dont change anything
// after marking negative of particular index then whichever positive element is present in array
//take that particular index +1 and return it..
