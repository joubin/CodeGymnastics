//
//  linklist.h
//  c-Practice
//
//  Created by Joubin Jabbari on 2/24/14.
//  Copyright (c) 2014 Joubin Jabbari. All rights reserved.
//
#ifndef HEADERS
#include <stdlib.h>
#include <stdio.h>
#endif

int AL_appened(int val);
struct Tuple AL_find(int val);
int AL_remove(int val);
int AL_setup();
int AL_len();
void AL_printAll();

typedef struct Node Node;
typedef struct Tuple Tuple;

struct Node{
    
	int val;
    
	Node *next;
    
};

struct Tuple{
    int index;
    int val;
};