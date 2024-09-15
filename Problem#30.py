# -*- coding: utf-8 -*-
"""
Created on Sun Dec  8 01:01:03 2019

@author: gunja
"""

#double for loop method
array=[4,3,2,7,8,2,3,1]
result=[]
for i in range(1,len(array)+1):
    if i not in array:
        print i
        result.append(i)
        
#TC=O(n^2)
#SC=O(1)
        
###############################################################################        
#Optimal Solution
# through array and if no is not at its position, 
#then make the no at its position as -ve


array=[4,3,2,7,8,2,3,1]
result=[]       
for i in range(1,len(array)+1):
    print i
    #print array[i]
    number=abs(array[i-1])
    if(number==i):
        continue
    else:
        array[number-1] = abs(array[number-1])*(-1)      
    print array   
    
#checking the positive indexes
for i in range(len(array)):
    if(array[i]>0):
        result.append(i+1)

#TC=O(n^2)
#SC=O(1)
        
###############################################################################