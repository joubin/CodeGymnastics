//
//  main.c
//  c-Practice
//
//  Created by Joubin Jabbari on 2/24/14.
//  Copyright (c) 2014 Joubin Jabbari. All rights reserved.
#include <stdio.h>
#include "linklist.h"


void useLinkList(){
    AL_setup(); //setup the root, we will use root to keep track of the number of links
	AL_appened(1); // append 1 so it should look like root>1
	AL_appened(2); // append 2 so it should look like root>1>2
	AL_appened(3);
	AL_appened(4);
    printf("%d\n", AL_len()); // print len of list
    
    Tuple results = AL_find(4); // find 4 in list
    printf("%d %d\n", results.index, results.val); // return the index and the number found
    
    AL_remove(3);
    Tuple results2 = AL_find(4);
    printf("%d %d\n", results2.index, results2.val);
    
    results2 = AL_find(4);
    printf("%d %d\n", results2.index, results2.val);
    AL_printAll(); // print entire list

}
int main(){
    useLinkList();
    return 0;
    
}

