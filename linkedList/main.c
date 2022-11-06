#include <stdio.h>
#include "linked_list.h"

int main (void){
  LINKED_LIST list;

  initialize_list(&list);
  insert_at_start(&list, 10);
  insert_at_start(&list, 20);
  insert_at_start(&list, 30);
  
  insert_after(&list, 20, 0);
  insert_at_end(&list, 200);
  //insert_at_end(&list, 250);
  insert_after(&list, 200, 2);
  print_list(&list);

  remove_at_start(&list);
  printf("\n");
  print_list(&list);

  remove_after(&list, 10);
  printf("\n");
  print_list(&list);

  remove_at_end(&list);
  printf("\n");
  print_list(&list);
  
  printf("\n");
  reverse(&list);
  print_list(&list);

  printf("\n");
  reverse(&list);
  print_list(&list);


  return 0;
}