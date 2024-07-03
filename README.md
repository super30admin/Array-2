# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

In this problem we have given that array has only positive numbers in it. So, what we can do here is we will check the first number in array and we will go to that index and multiply number stored there by -1. If we keep on doing that then all the numbers in the array will be negative except the indices which are missing as an element in the array. Then we can again loop through the array and if the number is less than 0 then we will again multiply it with -1 to restore the original array otherwise we will store those indices in our output array.



## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
Here we can solve this example by simple brute-force solution and comparing the stored minimum and maximum values but the main challenge is we need to do it in less than n*2 comaprisions. For that we can do is hop the list 2 elements at a time. We will keep the pointer index on one element and check which element among these two is largest and then check the largest element with max and smallest element with min. In this way we will need 3 comparisions per 2 elements.So we reduced comparisions from 2*n to 1.5*n. If the list has odd number of element we can make the final element comparision at the end.



## Problem3 (https://leetcode.com/problems/game-of-life/)
The main idea here is we know that the elements in the matrix are either 0 or 1. We know that we have to check 8 cells in the neighbourhood. So, to go to that cell from current cell we can store directions array where we can store the row and column indices that needs to be increased or decreased. Now to calculate alive cells around each cell we can have a separate function in which we will pass the current cell and go through directions array and check if that cell is 1 or 4. The idea behind checking 4 is we want in-place modification. So, we whenever we want to change 1 to 0 we will assign it to 4 to remember that this element was previously 1 and now it's 0 and for 0 to 1 we will store 3. While counting alives we will keep track of boundary conditions as well. Then in the nested for loop we will simply check if the current cell is 1 and if the number of alives around it is more than 3 (over-crowded) or less than 2 (under-crowded) then to make it 0 we will change it to 4. Otherwise if current cell is 0 and neighbourhood alives are 3 then we will change it to 3. At the end we will again run nested for loop and make all 3s as 1 and all 4s as 0.


