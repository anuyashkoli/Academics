#include <stdio.h>
#include <ctype.h>

#define MAX_STACK_SIZE 20

int stack[MAX_STACK_SIZE];
int top = -1;

void push(int x) {
    stack[++top] = x;
}

int pop() {
    return stack[top--];
}

int main() {
    char exp[MAX_STACK_SIZE];
    char *e;
    int n1, n2, n3, num;

    printf("Enter the expression: ");
    scanf("%19s", exp);  // Leave space for null terminator

    e = exp;
    while (*e != '\0') {
        if (isdigit(*e)) {
            num = *e - '0';
            push(num);
        } else {
            n1 = pop();
            n2 = pop();

            switch (*e) {
                case '+': {
                    n3 = n1 + n2;
                    break;
                }
                case '-': {
                    n3 = n2 - n1;
                    break;
                }
                case '*': {
                    n3 = n1 * n2;
                    break;
                }
                case '/': {
                    if (n1 != 0) {
                        n3 = n2 / n1;
                    } else {
                        printf("Error: Division by zero!\n");
                        return 1;
                    }
                    break;
                }
                default:
                    printf("Error: Invalid operator '%c'\n", *e);
                    return 1;
            }

            push(n3);
        }
        e++;
    }

    printf("\nThe result of expression %s = %d\n\n", exp, pop());
    return 0;
}
