#ifndef _QUEUE_LINKED_LIST_H_
#define _QUEUE_LINKED_LIST_H_

#include "queue_item.h"

struct queue_linked_list{
  struct queue_item* start;
  struct queue_item* end;
};

typedef struct queue_linked_list QUEUE;

void initialize_queue(QUEUE *);
void print_queue(QUEUE *);
void enqueue(QUEUE *, QUEUE_ITEM);
int is_empty(QUEUE *);
QUEUE_ITEM dequeue(QUEUE *);
//int is_full(QUEUE *); used only when it´s implemented with arrays

#endif
