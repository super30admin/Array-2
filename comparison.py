#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 31 22:18:48 2021

@author: ameeshas11
"""


#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

def comparr(arr):
    
    minval = maxval = arr[0]
    i=1
    while i+1<len(arr):
        if arr[i]<arr[i+1]:
            if minval>arr[i]:
                minval = arr[i]
            if maxval<arr[i+1]:
                maxval = arr[i+1]
        else:
            if minval>arr[i+1]:
                minval = arr[i+1]
            if maxval<arr[i]:
                maxval = arr[i]
        i += 2
                
    if i+1 == len(arr):
        if minval>arr[i]:
            minval = arr[i]
        if maxval<arr[i]:
            maxval = arr[i]
            
    return minval, maxval

if __name__ == '__main__':
    
    arr = [2, -4, 5, 6, 7, -8, 3]
    minval, maxval = comparr(arr)
    print(minval, maxval)
   