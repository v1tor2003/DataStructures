#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main (void){
  Stack my_stack;
  Item element;
  element.info = 1;
  initialize_stack(&my_stack);
  for(int i = 0; i <= 4; i++){
    push(&my_stack, element);
  }
  print_stack(&my_stack);
  push(&my_stack, element);
  element.info = 2;
  push(&my_stack, element);

  return 0;
}
