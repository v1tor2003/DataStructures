#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

int is_full(QUEUE *queue){
  return (queue->used_space == QUEUE_SIZE);
}

int is_empty(QUEUE *queue){
  return (queue->used_space == 0);
}

void print_queue(QUEUE *queue){
  puts("priting queue");
  printf("[");
  for(int i = 0; i < QUEUE_SIZE; i++){
    printf("%d ", queue->items[i].info);
  }
  puts("]");
}

void initialize_queue(QUEUE *queue){
  queue->used_space = 0;
  queue->start = -1;
  queue->end = -1;
}

void enqueue(QUEUE *queue, QUEUE_ITEM new_item){
  if(!is_full(queue)){
    if(queue->end + 1 == QUEUE_SIZE){
      queue->end = 0;
      queue->items[queue->end]= new_item;
    }else{
      queue->items[++(queue->end)] = new_item;
    }
    queue->used_space++;
  }else{
    puts("Error, no space left on the queue.");
    exit(-1);
  }
}

QUEUE_ITEM dequeue(QUEUE *queue){
  if(!is_empty(queue)){
    queue->used_space--;
    return queue->items[++(queue->start)];
  }else{
    puts("Error, there are no elements to dequeue.");
    exit(-1);
  }
}
