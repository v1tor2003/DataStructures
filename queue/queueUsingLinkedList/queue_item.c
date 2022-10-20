#include <stdio.h>
#include <stdlib.h>
#include "queue_item.h"

void print_queue_item(QUEUE_ITEM item){
  printf("Queue item: %d\n", item.info);
}

QUEUE_ITEM* get_node(){
  QUEUE_ITEM *node = (QUEUE_ITEM *) malloc(sizeof(QUEUE_ITEM));
  return node;
}