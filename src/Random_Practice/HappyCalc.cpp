/*
CSUS Spring 2013 programming competition
Problem: #2
The problem set can be found on my github page
@Author: Joubin Jabbari
@myPage: github.com/joubin
 */

#include <iostream>
#include <sstream>
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
		string tempInput3 = tempInput1 + tempInput2;
		if (isPalindromic(tempInput1) || isPalindromic(tempInput2) || isPalindromic(tempInput3))
		{
			cout << "Unlucky! " << "Unlucky!" << endl;
		}else{
			stringstream s (tempInput1+ " " + tempInput2);
			int numeric1;
			int numeric2;
			s >> numeric1 >> numeric2;
			cout << numeric1 + numeric2 << endl;
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