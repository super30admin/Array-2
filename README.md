# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
* nums that are not there need to be return
* Bruteforce - boolean array. Whichever element is present, value is True, else it is False. But it is taking additional space. To avoid that use optimal approach.
* Optimal - Use Temporaray state pattern, whichever element is present, at what index that element would be present make it -ve. If it was already -ve take absolute value of that, then change to -ve. If its duplicate element, don't do anything,  Let the -ve be -ve only.

## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
* Bruteforce - check every element, it will have 2n comparisons.
* Optimal consider pair, from that pair choose min & max. Do it for N/2 pairs. it will have N-2 comparison for min  & N-2 for max


## Problem3 (https://leetcode.com/problems/game-of-life/)
* Bruteforce - we need to maintain extra apace for original state.
* Optimal - 1st & 4th condition where states are changing use  Temporaray state pattern. Ex- 1-> <2 -> 0 ---2, 1-> >3 -> 0 --2, 0-> ==3 -> 1 ---3
* func countLives - to count 1s in all 8 directions


