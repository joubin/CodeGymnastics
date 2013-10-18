/*
CSUS Spring 2013 programming competition
Problem: #1
The problem set can be found on my github page
@Author: Joubin Jabbari
@myPage: github.com/joubin
 */
#include <iostream>
using namespace std;
int main (){
	std::string input;
	cout << "How many date: " << endl;
	getline(cin, input);

	int inputInt;
	std::string tempInput;
	inputInt = atoi(input.c_str());

	int evenCount=0;
	int oddCount=0;
	for (int i = 0; i <= inputInt-1; ++i)
	{
		cout << "Please enter date:\n " ;
		getline(cin, tempInput);
		int tempint = atoi(tempInput.c_str());
		if(tempint%2 == 0){
			evenCount++;
		}
		else{
			oddCount++;
		}
	}
	cout << "Number of odds: " << oddCount << endl;
	cout << "Number of evenCount: " << evenCount << endl;
	if (evenCount > oddCount){
		cout << "The winner is Joe\n";
	}else if (oddCount > evenCount){
		cout << "The winner is Sarah\n";
	}else{
		cout << "There is a tie\n";
	}
}