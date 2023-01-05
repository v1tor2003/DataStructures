#ifndef _STACK_ARRAY_H_
#define _STACK_ARRAY_H_

#include "stack_item.h"
#define STACK_SIZE 5

struct stack_array{
  int top;
  struct stack_item item[STACK_SIZE];
};

typedef struct stack_array Stack;

void initialize_stack(Stack *);
void print_stack(Stack *);
void push(Stack *, Item);
Item pop(Stack *);
Item check_top(Stack *);
int is_empty(Stack *);
int is_full(Stack *);

#endif