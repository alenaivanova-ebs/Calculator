# Calculator
Write a stack calculator that takes as an argument the command
string is the name of the file containing the commands. If there is no argument, then use
standard input for reading commands. Use real numbers.

Implement the following set of commands:

 # - line with comment.
 POP, PUSH - remove/put a number from/on the stack(s).
 + , - , * , /, SQRT – arithmetic operations. Use one or two top
stack elements, pop them from the stack, pushing the result back
 PRINT - prints the top element of the stack (without removing it).
 DEFINE—set the parameter value. In the future, use everywhere instead

parameter is the value.

Example (should output 2):

DEFINE a 4
PUSH a
SQRT
PRINT
