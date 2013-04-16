/*
You can use this to implement Link Lists in your C code

Restrictions are:
	I have already made a "Head" for you. Use this head. 

	Poor commenting. This code is very simple to read and I have not commented the code so that anyone using it, has to read it. 

	If you have never implemented link lists, I recommend you do so first by hand.

@author: Joubin Jabbari
*/


#include <stdlib.h>
#include <stdio.h>

struct node {
	int x;
	struct node *next;
};

// We can also include a "last" ptr so that we dont have to have a find last function; however, it would take away from what a link list truly is -- a useless tool to show new coders how lucky they are that they can use Arraylists and functions like it.

struct node *head;      

void initHead(int x){

	head = (struct node*)malloc(sizeof(struct node) ); 
	head->next = NULL;  
	head->x = x;   
}

void isNull(struct node* head){
	if(head == NULL) printf("its Null\n");
}


struct node* findLastNode(struct node *someStruct){
	//struct node *temp;
	if (someStruct == NULL)
	{
		exit(1);
	}
	if (someStruct->next == NULL)
	{
		return someStruct;
	}else {
		return findLastNode(someStruct->next);
	}
}


void printlist(struct node* head){
	if (head == NULL)
	{ 
		printf("No nodes\n");
		return;
	}
	if (head->next == NULL){
		printf("%d\n", head->x);
	}
	else { printf("%d\n", head->x);
	printlist(head->next); }
}

void addNode(int x, struct node *head){
	if (head == NULL)
	{
		initHead(x);
	}else{

		struct node *next;
		next = (struct node*)malloc(sizeof(struct node));

		next->x = x;
		next->next = NULL;
		findLastNode(head)->next = next;

	}
}

struct node* findNode(int lookingFor, struct node *headOfNode){
	if (headOfNode == NULL)
	{
		return NULL;
	}else if (headOfNode->x == lookingFor)
	{
		return headOfNode;
	}else{
		return findNode(lookingFor, headOfNode->next);
	}
}


void removeNode(struct node *toRemove){
	if(findNode(toRemove->x, head) == NULL) return ;
	if(toRemove == head) {
		head = head->next;
		free(toRemove);
		return;
	}
	struct node *beforeNode;
	struct node *afterNode;
	struct node *currentNode;
	currentNode = head;

	while(currentNode->x != toRemove->x){
		beforeNode = currentNode;
		currentNode = currentNode->next;
	}
	afterNode = toRemove->next;
	beforeNode->next = afterNode;

	free(toRemove);

}