#include <stdlib.h>
#include <stdio.h>

struct node {
  int x;
  struct node *next;
};

void addNode(int x, struct node *head);
struct node* findLastNode(struct node *someStruct);
void printlist(struct node *someStruct);
struct node* findNode(int lookingFor, struct node *headOfNode);
void removeNode(struct node *toRemove);

    struct node *head;      

int main()
{
    /* This will be the unchanging first node */
    struct node *last;
    struct node *next;

    // head = addtolist(tmp);

    /* Now root points to a node struct */
    head = (struct node*)malloc(sizeof(struct node) ); 

    // /* The node root points to has its next pointer equal to a null pointer 
    //    set */
    head->next = NULL;  
 
    // /* By using the -> operator, you can modify what the node,
    //    a pointer, (root in this case) points to. */
    head->x = 1;    
   // last = findLastNode(head);

   // next = (struct node*)malloc(sizeof(struct node) );
    //last->next = next;
    //next->x = 2;
    //next->next = NULL;
    for (int i = 0; i < 5; ++i)
    {
    next = (struct node*)malloc(sizeof(struct node) );
    next->x = i;
    next->next=NULL;
    findLastNode(head)->next=next;
    }

    addNode(333, head);
    last = findLastNode(head);
    printf("%d\n", last->x);
    removeNode(findNode(0, head));
    
  printlist(head);
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
	//return temp;
}


void printlist(struct node *someStruct){
	if (someStruct == NULL)
	{
		printf("No nodes exist\n");
	}
	if (someStruct->next == NULL){
	printf("%d\n", someStruct->x);
	}
	else { printf("%d\n", someStruct->x);
	printlist(someStruct->next); }
}

void addNode(int x, struct node *head){
	struct node *next;
	next = (struct node*)malloc(sizeof(struct node));

	findLastNode(head)->next = next;
	next->x = x;
	next->next = NULL;

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