#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_SIZE 100

// Stack implementation
typedef struct {
    char data[MAX_SIZE];
    int top;
} Stack;

void init(Stack* stack) {
    stack->top = -1;
}

int isEmpty(Stack* stack) {
    return stack->top == -1;
}

int isFull(Stack* stack) {
    return stack->top == MAX_SIZE - 1;
}

void push(Stack* stack, char value) {
    if (isFull(stack)) {
        printf("Stack overflow!\n");
        exit(1);
    }
    stack->data[++(stack->top)] = value;
}

char pop(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack underflow!\n");
        exit(1);
    }
    return stack->data[(stack->top)--];
}

char peek(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack underflow!\n");
        exit(1);
    }
    return stack->data[stack->top];
}

// Function to check if the character is an operator
int isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}

// Function to get the precedence of an operator
int precedence(char op) {
    switch (op) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}

// Function to convert infix expression to postfix expression
void infixToPostfix(char* infix, char* postfix) {
    Stack stack;
    init(&stack);
    int i, j = 0;
    for (i = 0; infix[i] != '\0'; i++) {
        char ch = infix[i];
        if (ch == ' ' || ch == '\t') {
            continue; // Skip whitespace characters
        }
        if (isdigit(ch) || isalpha(ch)) {
            postfix[j++] = ch;
        } else if (isOperator(ch)) {
            while (!isEmpty(&stack) && precedence(peek(&stack)) >= precedence(ch)) {
                postfix[j++] = pop(&stack);
            }
            push(&stack, ch);
        } else if (ch == '(') {
            push(&stack, ch);
        } else if (ch == ')') {
            while (!isEmpty(&stack) && peek(&stack) != '(') {
                postfix[j++] = pop(&stack);
            }
            pop(&stack); // Pop the opening parenthesis '('
        }
    }
    while (!isEmpty(&stack)) {
        postfix[j++] = pop(&stack);
    }
    postfix[j] = '\0';
}

int main() {
    char infix[MAX_SIZE];
    char postfix[MAX_SIZE];

    printf("Enter the infix expression: ");
    fgets(infix, sizeof(infix), stdin);

    // Remove the trailing newline character if present
    int len = strlen(infix);
    if (infix[len - 1] == '\n') {
        infix[len - 1] = '\0';
    }

    infixToPostfix(infix, postfix);
    printf("Postfix expression: %s\n", postfix);

    return 0;
}
