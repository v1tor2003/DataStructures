#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main (void){
  Stack my_stack;
  Item my_item, poped, top;
  
  initialize_stack(&my_stack);
  my_item.info = 20;
  push(&my_stack, my_item);
  
  my_item.info = 25;
  push(&my_stack, my_item);
  
  my_item.info = 30;
  push(&my_stack, my_item);
  print_stack(&my_stack);
  puts("Checking and printing top:");
  
  top = check_top(&my_stack);
  print_item(top);
  
  
  poped = pop(&my_stack);
  puts("printing the 1st poped item");
  print_item(poped);
  
  poped = pop(&my_stack);
  puts("printing the 2nd poped item");
  print_item(poped);
  puts("Checking and printing top:");
  
  top = check_top(&my_stack);
  print_item(top);
  print_stack(&my_stack);

  
  my_item.info = 35;
  
  push(&my_stack, my_item);
  
  print_stack(&my_stack);

  return 0;
}
