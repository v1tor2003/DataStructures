#include <stdio.h>
#include <stdlib.h>
#include "linked_list_item.h"

void print_list_item(LIST_ITEM item){
  printf("    value = %d\n", item.info);
}

void print_recursive(LIST_ITEM *start){
  if(!start)
    return;
  print_list_item(*start);
  print_recursive(start->next);
}

LIST_ITEM* get_node(){
  LIST_ITEM *node = (LIST_ITEM *) malloc(sizeof(LIST_ITEM));
  return node;
}

LIST_ITEM* search_item(LIST_ITEM *start, int info){
  if(start->info == info)
    return start;
  if(start->next == NULL)
    return start;

  return search_item(start->next, info);
}

LIST_ITEM* find_penultimate(LIST_ITEM *start){
  LIST_ITEM* end = find_end(start);
  
  while(start->next != end){
    start = start->next;
  }

  return start;
}

LIST_ITEM* find_end(LIST_ITEM *start){
  if(start->next == NULL)
    return start;

  return find_end(start->next);
}

LIST_ITEM* reverse_items(LIST_ITEM* start){
  LIST_ITEM* previous = NULL;
  LIST_ITEM* current = start;
  LIST_ITEM* following;
  
  while (current != NULL){
    following = current->next;
    current->next = previous;
    previous = current;
    current = following;
  }
  
  return previous;
}