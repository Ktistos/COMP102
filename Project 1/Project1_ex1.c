#include <stdio.h>
#include <stdlib.h>


typedef struct list
{
    int value;
    struct list * next;
}list;

void newNode(list**head, int value);//Creates a new Node

void newList(list** head, int range);//Creates a new list

void printList(list * head);// prints the list

list * searchNode(list * head,int value);// searching nodes based on the value

void findAndPushBack(int n,list ** head);//main function of the program

list * lastNode(list * head);//finding the last node

list * previousNode(list * head, list * node);//finding the previous node


int main() {
    int num_of_ints,val;
    printf("Please enter the amount of integers that you wish to store in the list:");
    scanf("%d",&num_of_ints);
    list *head=NULL;//initialization of head
    newList(&head,num_of_ints);
    printList(head);
    printf("\nEnter another value:");
    scanf("%d",&val);
    findAndPushBack(val,&head);
    return 0;
}



void newNode(list**head, int value)
{
    if(*head==NULL)//in case of null head , it allocates memory for it and then initializes the head's variables
    {
        *head=(list*)malloc(sizeof(list));
        (*head)->next=NULL;
        (*head)->value=value;
    }
    else
    {
        //allocates memory for the node
        list * node=(list *)malloc(sizeof(list));
        //inserts the new node at the end of the list
        list * last=lastNode(*head);
        node->next=NULL;
        last->next=node;
        node->value=value;
    }

}

void newList(list** head, int range)
{
    int count=0,value;
    for(;count<range;count++)//iterates as many times as the preferred number of nodes
    {
        printf("Please enter a value:");
        scanf("%d",&value);//node value insertion
        newNode(head,value);//node creation
    }
}

void printList(list * head)
{
    list * tmp=head;
    while(tmp!=NULL)
    {
        printf("%d ",tmp->value);
        tmp=tmp->next;
    }
}

list * searchNode(list * head,int value)
{

    list * tmp=head;
    while(tmp!=NULL)
    {
        if(tmp->value==value)//if it finds the value in any of the nodes it will return the node
            return tmp;
        tmp=tmp->next;
    }

    //if the program doesn't find any node with the preffered value it returns NULL

    return tmp;
}
list * lastNode(list * head)
{
    list * tmp=head;
    while(tmp->next!=NULL)
        tmp=tmp->next;
    return tmp;
}


list * previousNode(list * head, list * node)
{
    if(node==head)//since head has no previous node the function exits
        return NULL;
    else
    {
        list * tmp=head;
        while(tmp->next!=node)
            tmp=tmp->next;
            return tmp;
    }
}
void findAndPushBack(int n,list ** head)//main function of the program
{
    list * node= searchNode(*head,n); //finds the appropriate node and then allocates it to variable node
    if(node!=NULL )//if it succeded finding it
    {

        if(node->next==NULL)//if the node is the last one the function alerts the user and closes
        {
            printf("That's the last node.\n");
            return;
        }
        else
        {
            if(node->next->value>n)//if the
        {
                list * last=lastNode(*head);//allocating the last node to the variable
                list * previous=previousNode(*head,node);// allocating the previous node of variable node to variable previous
                if(previous==NULL)//if variable node == head of the list , the function changes the head of the list and then makes the appropriate changes
                {
                    *head=node->next;
                    last->next=node;
                    node->next=NULL;
                }
                else//On every other occasion...
                {
                    previous->next=node->next;
                    last->next=node;
                    node->next=NULL;
                }
                printf("Node found.\n");
                printList(*head);
        }
            else//function allerts the user and then exits
        {
                printf("The node was found but will  remain intact.\n");
                return;
        }
        }


    }
    else
        printf("The value is not in the list.\n");
}


