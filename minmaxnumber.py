#time complexity: O(n)
#no doubts
#was facing index out of error but resolved it

#explaination: the brute force method would be having two variables, maximum and minimum and comparing the lements with minimum and maxium
#they have asked us to reduce the comparisions
#so we will be pairing up the number and finding the minimum and maximum among the two numbers and comparing it with the actual minimum and maximum

def minmax(nums):
    min=nums[0]
    max=nums[0]
    n=len(nums)
    for i in range(1,len(nums),2):
        print(i,i+1)
        if i==n-1:  #this condition is when the i becomes the last index and to prevent index out of range
            if min > nums[i]:
                min=nums[i]
            if max < nums[i]:
                max=nums[i]

        elif nums[i] > nums[i+1]:
                if nums[i] > max:
                    max=nums[i]
                if nums[i+1] < min:
                    min=nums[i+1]
                print("second",min,max)
        else:
            if nums[i+1] > max:
                max=nums[i+1]
            if nums[i] < min:
                min=nums[i]
            print("third",min, max)
    return min,max


if __name__ == '__main__':

        nums=[-1,40,-2,9,90]
        print(minmax(nums))