#ifndef _STACK_ARRAY_H_
#define _STACK_ARRAY_H_

#include "stack_item.h"

struct stack_array{
  //int top;
  struct stack_item item;
};

typedef struct stack_array Stack;

void initialize_stack(Stack *);
void print_stack(Stack *);
void push(Stack *, Item);
Item pop(Stack *);
Item check_top(Stack *);
int is_empty(Stack *);
//int is_full(Stack *); Avaliable just for LIFO using arrays

#endif