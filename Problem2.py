#T.C. O(nlogn). as I used sorting function to sort the array
#S.C. O(n). A new sorted array is created. the size of this array is based on the original array

arr = [4,1,2,5,6,7,8]

s_arr = sorted(arr)

min_ele = s_arr[0]
max_ele = s_arr[-1]
print(min_ele)
print(max_ele)
