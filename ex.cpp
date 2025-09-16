#include <bits/stdc++.h>
using namespace std;

int main() {
  int size;
  cin >> size;
  int *myarray = new int[size];
  myarray[0] = 2;
  for (int i = 0; i < size; i++) {
    cout << *(myarray + i) << endl;
  }
  delete[] myarray;
  myarray = nullptr;
  return 0;
}
