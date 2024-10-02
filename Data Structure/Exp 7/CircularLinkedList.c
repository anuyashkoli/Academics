#include <stdio.h>
#include <stdlib.h>
// Structure to represent a node in the circular linked list
struct Node
{
    int data;
    struct Node *next;
};
// Function to insert a new node at the end of the circular linked list
void insert(struct Node **head, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = value;
    if (*head == NULL)
    {
        *head = newNode;
        newNode->next = *head;
    }
    else
    {
        struct Node *current = *head;
        while (current->next != *head)
        {
            current = current->next;
        }
        current->next = newNode;
        newNode->next = *head;
    }
}
// Function to display the circular linked list
void display(struct Node *head)
{
    if (head == NULL)
    {
        printf("Circular Linked List is empty.\n");
        return;
    }
    struct Node *current = head;
    do
    {
        printf("%d ", current->data);
        current = current->next;
    } while (current != head);
    printf("\n");
}
int main()
{
    struct Node *head = NULL;
    int i, num;
    for (i = 0; i < 5; i++)
    {
        printf("Enter Node in Circular Linked List");
        scanf("%d", &num);
        insert(&head, num);
    }
    printf("Circular Linked List: ");
    display(head);
    return 0;
}