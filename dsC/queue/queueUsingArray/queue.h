#ifndef _QUEUE_ARRAY_H_
#define _QUEUE_ARRAY_H_

#include "queue_item.h"
#define QUEUE_SIZE 3

struct queue_array{
  int used_space;
  int start, end;
  QUEUE_ITEM items[QUEUE_SIZE];
};

typedef struct queue_array QUEUE;

void initialize_queue(QUEUE *);
void print_queue(QUEUE *);
void enqueue(QUEUE *, QUEUE_ITEM);
int is_empty(QUEUE *);
int is_full(QUEUE *);
QUEUE_ITEM dequeue(QUEUE *);

#endif


