#ifndef _LIST_ITEM_H_
#define _LIST_ITEM_H_

struct list_item{
  int info;
  struct list_item *next;
};

typedef struct list_item LIST_ITEM;

void print_list_item(LIST_ITEM );
void print_recursive(LIST_ITEM *start);
LIST_ITEM* get_node();
LIST_ITEM* search_item(LIST_ITEM *list, int info);
LIST_ITEM* find_end(LIST_ITEM *);
LIST_ITEM* find_penultimate(LIST_ITEM *);
LIST_ITEM* reverse_items(LIST_ITEM *);

#endif