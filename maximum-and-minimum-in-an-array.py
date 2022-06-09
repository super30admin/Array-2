# Time Complexity: O(n) comparision are 3n/2
# Space Complexity: O(1)
def findminmax(l):
  n=len(l)
  start=0
  if n%2==0:
    mini=min(l[0],l[1])
    maxi=max(l[0],l[1])
    start=2
  else:
    start=1
    maxi,mini=l[0],l[0]
  for i in range(start,len(l)-1):
    if l[i]<l[i+1]:
      maxi=max(maxi,l[i+1])
      mini=min(mini,l[i])
    else:
      maxi=max(maxi,l[i])
      mini=min(mini,l[i+1])
    i+=2
  return mini,maxi
print(findminmax([1000, 11, 445, 1, 330, 3000]))