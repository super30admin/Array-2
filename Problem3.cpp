// Maximum and minimum of an array using minimum number of comparisons
// Time Complexity : O(n)
// Space Complexity : O(1)

// Approach
// we will take pairs and compare between them. Then we will consider the min & max.
// No. of comparisons when n is even: 1 + 3 * ((n-2)/2) = 1.5n-2
// No. of comparisons when n is odd: 1 + 3 * ((n-3)/2) + 2 = 1.5n

int minnum, maxnum;
void minmax(vector<int>& a)
{
        if (a.size() == 0)
                return;

        // if only one element
        if (a.size() == 1)
        {
                max = a[0];
                min = a[0];
                System.out.println("min: " + min + "\nmax: " + max);
        }

        if (a[0] > a[1])
        {
                max = a[0];
                min = a[1];
        }
        else
        {
                max = a[1];
                min = a[0];
        }

        for (int i = 2; i <= a.size() - 2; i += 2)
        {
                if (a[i] > a[i + 1])
                {
                        minnum = min(minnum, a[i + 1]);
                        maxnum = max(maxnum, a[i]);
                }
                else
                {
                        minnum = min(minnum, a[i]);
                        maxnum = max(maxnum, a[i + 1]);
                }
        }

        if (a.length % 2 == 1)
        {
                min = Math.min(min, a[a.length - 1]);
                max = Math.max(max, a[a.length - 1]);
        }

        cout << "min: " + min + "\nmax: " + max;
        return;
}