#ifndef _QUEUE_ITEM_H_
#define _QUEUE_ITEM_H_

struct queue_item{
  int info;
  struct queue_item * next;
};

typedef struct queue_item QUEUE_ITEM;

void print_queue_item(QUEUE_ITEM );

#endif