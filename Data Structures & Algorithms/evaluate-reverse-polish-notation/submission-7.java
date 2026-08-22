class Solution {
    public int evalRPN(String[] tokens) {       
           Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if ("+/-*".contains(token)){

                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                // calculate a operator b
                if (token.equals("+")) {
                    result = a + b;
                } else if (token.equals("-")) {
                    result = a - b;
                } else if (token.equals("*")) {
                    result = a * b;
                } else if (token.equals("/")) {
                    result = a / b;
                }

                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        // return remaining value
        return stack.pop();
    }

    }
