/* 
Given an int array which might contain duplicates, find the largest subset of it which form a sequence. 
Eg. {1,6,10,4,7,9,5} 
then ans is 4,5,6,7 

Sorting is an obvious solution. Can this be done in O(n) time

Note: Compile with the c99 standard. 
*/

#include<stdio.h>
#include<stdlib.h>
int current, start, distance, i, end, arraySize, fStart, fEnd;
int range =0;


int comp (const void * elem1, const void * elem2) {
	int f = *((int*)elem1);
	int s = *((int*)elem2);
	if (f > s) return  1;
	if (f < s) return -1;
	return 0;
}

main()
{
	int arr[] = {1,6,10,4,7,9,5} ;
	arraySize = sizeof(arr)/sizeof(arr[0]);

	qsort (arr, sizeof(arr)/sizeof(int), sizeof(int), comp);

	printf("The largest squence is:\n");
	if(sizeof(arr) == 1){
		printf("%d\n",arr[0] );
	}else{
		for( i = 1; i <= arraySize-1; ++i){
			if(arr[i-1] + 1 != arr[i]){ 
				if((end - start) >= range){
					range = end - start;
					fStart = start;
					fEnd = end; 
				}
				if( i != arraySize ) start = i;
			}
			end = i;

		}
	}
	printf("{");
	for(int j = fStart; j < fEnd; j++){
		printf("%d,\t",arr[j] );
	}
	printf("%d}\n", arr[fEnd]);
}
