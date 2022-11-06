#ifndef _LINKED_LIST_H_
#define _LINKED_LIST_H_

#include "linked_list_item.h"

struct linked_list{
  struct list_item *start;
};

typedef struct linked_list LINKED_LIST;

void initialize_list(LINKED_LIST *);// done
void print_list(LINKED_LIST *);// done
int is_empty(LINKED_LIST *);// done
void free_node(LINKED_LIST *, LIST_ITEM *);// done
void reverse(LINKED_LIST *);
void insert_at_start(LINKED_LIST *, int);// done
void insert_after(LINKED_LIST *, int, int);// done
void insert_at_end(LINKED_LIST *, int);// done
LIST_ITEM* remove_at_start(LINKED_LIST *);// done
LIST_ITEM* remove_after(LINKED_LIST *, int);// done
LIST_ITEM* remove_at_end(LINKED_LIST *);// done

#endif