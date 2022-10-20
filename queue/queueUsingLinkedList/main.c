#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

int main (void){
  QUEUE queue;
  QUEUE_ITEM item;

  initialize_queue(&queue);
  item.info = 10;
  enqueue(&queue, item);

  item.info = 20;
  enqueue(&queue, item);
  
  item.info = 30;
  enqueue(&queue, item);
  
  item = dequeue(&queue);
  item = dequeue(&queue);
  
  item.info = 25;
  enqueue(&queue, item);
  
  print_queue(&queue);
  
  item = dequeue(&queue);
  print_queue(&queue);
 

  
  /*while(1){
    item = dequeue(&queue);
    printf("item = %d", item.info);
    if(item.next == NULL)break;
  }*/

  return 0;
}