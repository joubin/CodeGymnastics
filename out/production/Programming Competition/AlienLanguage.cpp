#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;
string testCase(string inString);

int main(){
	ifstream infile;
	infile.open("smalltest.in");

	int L = 0; //Length of the word
	int D = 0; //Number of line
	int N = 0; //Number of tests	
	
	infile >> L >> D >> N;
	
	string *stringArray = new string[D];
	string *testCases = new string[N];
	
	for (int i = 0; i < D; ++i){
		infile >> stringArray[i];
	}
	
	for (int i = 0; i < N; ++i){
		infile >> testCases[i];
	}
	
	vector<string> *x = new vector<string>;
	string test;
	cout << endl;
	
	for (int i = 0; i < N; ++i)
	{
		string temp = testCases[i];
		test = "";

		for(int j = 0; j < temp.length(); ++j){
			if(temp[j] == '(' ){
				//Do nothing
			}else if(temp[j] == ')'){
				x->push_back(test);
				test = "";

			}else{
				test = test + temp[j];
				cout << "adding " << temp[j] << endl;
			}			
		}

	}



	cout << (*x)[0][0] << (*x)[1][0] << (*x)[2][0] << endl; 
	cout << (*x)[0][0] << (*x)[1][0] << (*x)[2][1] << endl; 
	cout << (*x)[0][0] << (*x)[1][1] << (*x)[2][0] << endl; 
	cout << (*x)[0][0] << (*x)[1][1] << (*x)[2][1] << endl; 
	cout << (*x)[0][1] << (*x)[1][0] << (*x)[2][0] << endl; 
	cout << (*x)[0][1] << (*x)[1][0] << (*x)[2][1] << endl; 
	cout << (*x)[0][1] << (*x)[1][1] << (*x)[2][0] << endl; 
	cout << (*x)[0][1] << (*x)[1][1] << (*x)[2][1] << endl; 






	// cout << (*x)[0] << endl;
	// cout << (*x)[1] << endl;
	// cout << (*x)[2] << endl;

	for (int i = 0; i < 3; ++i)
	{
		/* code */
	}

	delete [] stringArray;
	delete [] testCases;
	delete x;

	return 0;
}

string testCase(string inString){

	return inString;
}