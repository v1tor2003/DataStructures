#include <stdio.h>
#include <stdlib.h>
#include "linked_list.h"

int is_empty(LINKED_LIST *list){
  return (list->start == NULL);
}

void initialize_list(LINKED_LIST *list){
  list->start = NULL;
}

void print_list(LINKED_LIST *list){
  LIST_ITEM *ptr = list->start;
  if(is_empty(list))
    puts("The list is empty.");
  else{
    puts("\tPrinting list:");
    print_recursive(ptr);
  }
}

void free_node(LINKED_LIST *list, LIST_ITEM *item){
  if(is_empty(list)){
    puts("There are no nodes to free.");
    return;
  }

  free(item);
}

void reverse(LINKED_LIST *list){
  list->start = reverse_items(list->start);
}

void insert_at_start(LINKED_LIST *list, int node_info){
  LIST_ITEM *new_node = get_node();
  
  if(!new_node){
    puts("Error, no memory left, finishing program.");
    exit(-1);
  }

  new_node->next = NULL;
  new_node->info = node_info;
  
  if(list->start != NULL)
    new_node->next = list->start;

  list->start = new_node;
}

void insert_after(LINKED_LIST *list, int reference, int node_info){
  LIST_ITEM *new_node = get_node();

  if(!new_node){
    puts("Error, no memory left, finishing program.");
    exit(-1);
  }

  LIST_ITEM *place_to_insert = search_item(list->start, reference);

  new_node->info = node_info;
  new_node->next = place_to_insert->next;
  place_to_insert->next = new_node;
}

void insert_at_end(LINKED_LIST *list, int node_info){
  LIST_ITEM *new_node = get_node();
  
  if(!new_node){
    puts("Error, no memory left, finishing program.");
    exit(-1);
  }

  new_node->info = node_info; 
  new_node->next = NULL;

  LIST_ITEM *end = find_end(list->start);
  
  end->next = new_node;
}

LIST_ITEM* remove_at_start(LINKED_LIST *list){
  if(is_empty(list)){
    puts("There are no elements to remove.");
    return NULL;
  }

  LIST_ITEM *temp = list->start;
  list->start = temp->next;
  return temp;
}

LIST_ITEM* remove_after(LINKED_LIST *list, int reference){
  if(is_empty(list)){
    puts("There are no elements to remove.");
    return NULL;
  }

  LIST_ITEM *place_to_remove = search_item(list->start, reference);

  LIST_ITEM *temp = place_to_remove->next;
  place_to_remove->next = temp->next;
  return temp;
}

LIST_ITEM* remove_at_end(LINKED_LIST *list){
  if(is_empty(list)){
    puts("There are no elements to remove.");
    return NULL;
  }

  LIST_ITEM* end = find_end(list->start);
  LIST_ITEM* penultimate = find_penultimate(list->start);

  penultimate->next = end->next;
  return end;
}

