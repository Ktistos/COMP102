#include <stdio.h>
#include <stdlib.h>

typedef struct list
{
    int value;
    struct list * next;
}list;


list * lastNode(list * head);//finding the last node

void newNode(list**head, int value);//Creates a new Node

void newList(list** head, int range);//Creates a new list

void printList(list * head);// prints the list

int checkModuloOfSum(list * node);//main function(recursive) , checks whether a value in node can be divided by the sum of the values of the next nodes

int main()
{
   int num_of_ints,val;
    printf("Please enter the amount of integers that you wish to store in the list:");
    scanf("%d",&num_of_ints);
    list *head=NULL;//initialization of head
    newList(&head,num_of_ints);
    printList(head);
    printf("\n");
    checkModuloOfSum(head);
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


list * lastNode(list * head)
{
    list * tmp=head;
    while(tmp->next!=NULL)
        tmp=tmp->next;
    return tmp;
}


int checkModuloOfSum(list * node)
{
    // initializing the sum
    int sum=0;
    // if variable node is not pointing at the last node of the list ,variable sum will be equal to the sum of values of the next nodes
    if(node->next!=NULL)
        sum=checkModuloOfSum(node->next);
    //Alerts user accordingly depending on the outcome of the operation sum%node->value
    if(sum%node->value==0)
        printf("%d[%d](Yes) ", node->value,sum);
    else
        printf("%d[%d](No) ", node->value,sum);
    //updates value of variable sum in order to return it to the previous node sum
    sum+=node->value;
    return sum;
}
