#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

int is_empty(QUEUE *queue){
  return (queue->start == NULL);
}

void initialize_queue(QUEUE *queue){
  queue->start = NULL;
  queue->end = NULL;
}

void print_queue(QUEUE *queue){
  QUEUE_ITEM *ptr= queue->start;

  if(!ptr){
    puts("There are no elements in the queue.");
  }else{
    puts("\tQUEUE");
    printf("[");
    while (ptr){
      printf("%d ", ptr->info);
      ptr = ptr->next;
    }
    puts("]");
  }
}

void enqueue(QUEUE *queue, QUEUE_ITEM item){
  QUEUE_ITEM *new_node = (QUEUE_ITEM *) malloc(sizeof(QUEUE_ITEM));

  if(new_node){
    new_node->next = NULL;
    new_node->info = item.info;

    if(queue->start == NULL)
      queue->start = new_node;
   
    if(queue->end != NULL)
      queue->end->next = new_node;
    
    queue->end = new_node;
  }else{
    puts("Error, there is no memory left.");
    exit(-1);
  }
}

QUEUE_ITEM dequeue(QUEUE *queue){
  if(!is_empty(queue)){
    QUEUE_ITEM *out = queue->start;
    queue->start = queue->start->next;
    return *out;
  }else{
    puts("Error, there are no elements to dequeue.");
    exit(-1);
  }
}