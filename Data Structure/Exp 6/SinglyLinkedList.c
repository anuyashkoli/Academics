#include <stdio.h>
#include <stdlib.h>
// Define the structure for a node in the linked list
struct Node
{
    int data;
    struct Node *next;
};
// Function to create a new node
struct Node *createNode(int data)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}
// Function to insert a new node at the end of the list
void insertEnd(struct Node **head, int data)
{
    struct Node *newNode = createNode(data);
    if (*head == NULL)
    {
        *head = newNode;
        return;
    }
    struct Node *current = *head;
    while (current->next != NULL)
    {
        current = current->next;
    }
    current->next = newNode;
}
// Function to display the linked list
void display(struct Node *head)
{
    struct Node *current = head;
    while (current != NULL)
    {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}
// Function to free the memory occupied by the linked list
void freeList(struct Node *head)
{
    struct Node *current = head;
    while (current != NULL)
    {
        struct Node *temp = current;
        current = current->next;
        free(temp);
    }
}
int main()
{
    struct Node *head = NULL;
    insertEnd(&head, 1);
    insertEnd(&head, 2);
    insertEnd(&head, 3);
    insertEnd(&head, 4);
    printf("Linked List: ");
    display(head);
    freeList(head);
    return 0;
}