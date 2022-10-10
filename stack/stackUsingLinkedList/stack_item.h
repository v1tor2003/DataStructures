#ifndef _STACK_ITEM_H_
#define _STACK_ITEM_H_

struct stack_item{
  int info;
  struct stack_item *previous;
};

typedef struct stack_item Item;

void print_item(Item);

#endif