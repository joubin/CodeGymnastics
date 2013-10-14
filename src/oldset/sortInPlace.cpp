#include <iostream>
using namespace std;
int main(){
	string array[] = {"a1", "a2", "a3", "b1", "b2", "b3"};
	int size = sizeof(array)/sizeof(array[0]);
	if (!(size%2))
	{
		int half = (size >> 1);
		int j = half;
		for (int i = 1; i < half && j < size; ++i)
		{
		int i = 1;

		cout << "array at i is " << array[i] << endl;
		cout << "array at j is " << array[j] << endl;
			string temp(array[i]);
			array[i] = array[j];
			array[j] = temp;
			++j;
		 }
		for (int i = 0; i < size; ++i)
		{
			cout << array[i];
		}
	}
	return 0;
}