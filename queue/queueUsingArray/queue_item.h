#ifndef _QUEUE_ITEM_H_
#define _QUEUE_ITEM_H_

struct queue_item{
  int info;
};

typedef struct queue_item QUEUE_ITEM;

void print_queue_item(QUEUE_ITEM );

#endif