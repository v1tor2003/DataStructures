#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int is_empty(Stack *stack){
  return (stack->top == -1);
}

int is_full(Stack *stack){
  return (stack->top == STACK_SIZE - 1);
}

void initialize_stack(Stack *stack){
  stack->top = -1;
}

void print_stack(Stack *stack){
  int i = stack->top;
  puts("\tSTACK");
  if(is_empty(stack)){
    puts("There are no items in the stack");
  }else{
    while(i >= 0){
      printf("    - item = %d\n", stack->item[i].info);
      i--;
    }
  }
}

void push(Stack *stack, Item item){
  if(is_full(stack)){
    puts("There is no space left in the stack");
    exit(-1);
  }
  stack->top++;
  stack->item[stack->top] = item;
}

Item pop(Stack *stack){
  if(is_empty(stack)){
    puts("There are no items in the stack to pop");
    exit(-1);
  }
  return stack->item[stack->top--];
}

Item check_top(Stack *stack){
  Item top_item = pop(stack);
  push(stack, top_item);
  return top_item;
}