#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

int main (void){
  //consider this code just for testing and debbung porpuses
  // the print_queue function is just for keep tracking of the info, it doesn´t display the info "as it should"
  QUEUE queue;
  QUEUE_ITEM item;
  item.info = 1;

  print_queue_item(item);
  
  initialize_queue(&queue);
  
  item.info = 10;
  enqueue(&queue, item);
  
  item.info = 20;
  enqueue(&queue, item);
  
  item.info = 30;
  enqueue(&queue, item);

  print_queue(&queue);
  
  printf("used space : %d\n", queue.used_space);
  printf("start : %d\n", queue.start);
  printf("end : %d\n", queue.end);

  item = dequeue(&queue);
  puts("printing 1st dequeue item");
  print_queue_item(item);
  printf("new start : %d\n", queue.start);

 item = dequeue(&queue);
  puts("printng 2nd dequeue item");
  print_queue_item(item);
  printf("new start : %d\n", queue.start);


item =dequeue(&queue);
item.info = 21;
  enqueue(&queue, item);

  item.info = 22;
  enqueue(&queue, item);

  item.info = 23;
  enqueue(&queue, item);
  print_queue(&queue);



  /*
  item.info = 20;
  enqueue(&queue, item);

  item.info = 20;
  enqueue(&queue, item);

  print_queue(&queue);*/
  return 0;
}