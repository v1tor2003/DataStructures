#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int is_empty(Stack *stack){
  return (stack->item.previous == NULL);
}

void initialize_stack(Stack *stack){
  stack->item.previous = NULL;
}

void print_stack(Stack *stack){
  Item *ptr = stack->item.previous;
  
  if(!ptr){
    puts("There are no elements in the stack to print");
  }else{
    puts("\tSTACK");
    while (ptr){
      printf("  -item = %d\n", ptr->info);
      ptr = ptr->previous;
    }
  }
}

void push(Stack *stack, Item item){
  Item *new_item = (Item *) malloc(sizeof(Item));
  
  if(new_item){
    new_item->info = item.info;
    new_item->previous = stack->item.previous; 
    stack->item.previous = new_item;
  }else{
    puts("There is no memory left to push a new item");
    exit(-1);
  }
}

Item pop(Stack *stack){
  if(is_empty(stack)){
    puts("There are no elements in the stack to pop");
    exit(-1);
  }

  Item *top_item = stack->item.previous;
  //free(stack->item.previous);
  stack->item.previous = stack->item.previous->previous;
  return *top_item;
}

Item check_top(Stack *stack){
  Item top_item = pop(stack);
  push(stack, top_item);
  return top_item;
}



