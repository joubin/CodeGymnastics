/*
CSUS Spring 2013 programming competition
Problem: #2
The problem set can be found on my github page
@Author: Joubin Jabbari
@myPage: github.com/joubin
 */

#include <iostream>
using namespace std;
bool isPalindromic(string input);
int main(){
	string input;
	cout << "How many Calculations: ";
	
	getline(cin, input);
	int inputCount = atoi(input.c_str());
	string tempInput1;
	string tempInput2;

	for(int i = 1; i <= inputCount; ++i){
		cin >> tempInput1 >> tempInput2;
				//cout << tempInput1 << " " << tempInput2 << endl;
		string tempInput3 = tempInput1 + tempInput2;
				//cout << tempInput3 << endl;
		if (isPalindromic(tempInput1) || isPalindromic(tempInput2) || isPalindromic(tempInput3))
		{
			cout << "Unlucky! " << "Unlucky!" << endl;
		}else{
			int numeric1 = atoi(tempInput1.c_str());
			int numeric2 = atoi(tempInput2.c_str());
			int sum = numeric2 + numeric1;
			cout << sum << endl;
		}
	}
	return 0;
}

bool isPalindromic(string input){

	int length = input.length();
	int i = 0;
	int j = length-1;
	while (i < j){
		if (input[i] == input[j])
		{
			j--;
			i++;
		}else{
			return false;
		}
	}
	return true;
}