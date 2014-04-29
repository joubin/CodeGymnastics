#include "linklist.h"


Node *root, *curr;


int AL_appened(int val) {
	Node *tmp;
	tmp = (Node *)malloc(sizeof (Node));
	curr->next = tmp;
	tmp->val = val;
	curr = tmp;
	root->val++;
	return 0;
    
}



struct Tuple AL_find(int val){
	if(root->next) {
        curr = root->next;
        
        int count = 0;
        while (curr->next){
            
            if (curr->val == val){
                Tuple r = {count+=1, val};
                return r;
            }
            count++;
            curr = curr->next;
            
        }
        if (curr->val == val){
            Tuple r = {count+=1, val};
            return r;
        }
    }
    Tuple r = {-1, -1};
    return r;
    
}



int AL_remove(int val){
	Node *prev;
	prev = (Node *)malloc(sizeof (Node));
	curr = root;
	while (curr->next->val != val){
		prev = curr;
		curr = curr->next;
	}
	if (curr->next->val != val) return -1;
    curr->next = curr->next->next;
    root->val--;
	free(curr->next);
	return 1;
    
}


int AL_setup(){
	root = (Node *)malloc(sizeof(Node));
	root->val = 0;
	root->next = 0;
	curr = root;
	return 0;
    
}

int AL_len(){
    return root->val;
}

void AL_printAll(){
    curr=root->next;
    while (curr->next != NULL) {
        printf("%d\n",curr->val);
        curr=curr->next;
    }
    printf("%d\n",curr->val);
}

