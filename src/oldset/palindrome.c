#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>

void removeSpaces(char *array);
void removePunctuation(char *array);
void findPalindrome(char *array);
main(){
	char xx[] = "DOD stands for hello. this isn't for fun";
	//printf("Original array: %s\n", xx);
	removeSpaces(xx);
	removePunctuation(xx);
	findPalindrome(xx);
	//printf("Redone array: %s\n", xx);
}

void removeSpaces(char *array){
	int count = 0;
	int lng = strlen(array);

	char temp [lng];

	for (int i = 0; i <= lng; ++i) {
		while (array[i] ==  ' ') {
			i++;
			count++;
		}

		temp[i-count] = array[i];
		array[i]=NULL;
	}

	for (int i = 0; i <= lng-count; ++i) {
		array[i]=temp[i];
	}
}

void removePunctuation(char *array){
	int count=0;
	int lng = strlen(array);
	printf("%d\n", lng);

	char temp[lng];

	for(int i = 0; i <= lng ; ++i){
		if( !((int)array[i] >= (int)'a' && (int)array[i] <= (int)'z' ) && !((int)array[i] >= (int)'A' && (int)array[i] <= (int)'Z')){
			i++;
			count++;
		}

		temp[i-count] = array[i];
		array[i]=NULL;
	}
	for (int i = 0; i <= lng-count; ++i) {
		array[i]=temp[i];
	}
}

void findPalindrome(char *array){
	printf("asd\n");
	int longest[2];
	int longStart, longEnd;
	longStart = 0;
	longEnd = 0;
	for(int i = 0; i <= strlen(array); ++i){
		for(int j = i+1; j <= strlen(array)-i; ++j){
					printf("%c\n", array[i] );

			if( array[i] == array[j]){
				if((longStart-longEnd) <= (i-j))
					longEnd = j; 
					longStart = i;
			}

		}
	}

	for (int i = longStart; i <= longEnd; ++i)
	{
		printf("%d", array[i] );
		printf(" is the longest palindrome found.\n");
	}
	// longest[0] = longStart;
	// longest[1] = longEnd;

	// return longest;
}