#Time complexity : O(n) i.e. comparisions are made approximatelt 1.5n
#space complexity : O(1)
def minmax(num):
  #defining initailly maximum and minimum variable 
  maximum = 0
  minimum = 1
  #storing length of the list
  n = len(num)
  #if the length of the list is odd than directly comparing the last element of the array in the list with global minimuma and maximum
  if len(num) % 2 != 0:
    n = len(num)-1
    maximum = max(maximum, num[-1])
    minimum = min(minimum, num[-1])
  #processing the comparision by making pairs for all the elements expect the last element is length is odd
  for i in range(0,n,2):
    #if the first element of the pair is maximum in pair then compairing it with global maximum and comparing the minimum element of the pair with global minimum
    if num[i] > num[i+1]:
      maximum = max(maximum, num[i])
      minimum = min(minimum, num[i+1])
    else:
      maximum = max(maximum, num[i+1])
      minimum = min(minimum, num[i])
  return maximum, minimum
maximum1, minimum1 = minmax([1,2,4,-2,3,6,7])
print("Maximum", maximum1, "Minimum", minimum1)
