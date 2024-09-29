from typing import List


# Original Solution (Python integer division rounding away from zero burned me) fuck you '//'
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # push both nums then when operand comes you pop the operand and the two nums and apply
        # that operation on the two numbers, then push the result, then push next num, then encounter
        # next operand then pop both numbers and apply the operand to them, once again
        stack = []
        i = 0
        while i < len(tokens):
            tok = tokens[i]
            if tok == "+":
                sol = int(stack.pop()) + int(stack.pop())
                stack.append(str(sol))
            elif tok == "-":
                val = int(stack.pop())
                sol = int(stack.pop()) - val
                stack.append(str(sol))
            elif tok == "*":
                sol = int(stack.pop()) * int(stack.pop())
                stack.append(str(sol))
            elif tok == "/":
                val2 = int(stack.pop())
                val1 = int(stack.pop())
                sol = int(val1 / val2)
                stack.append(str(sol))
            else:
                stack.append(tok)
            i += 1
        return int(stack.pop())
