class Solution {
    public int evalRPN(String[] tokens) {       
           ArrayList<String> list = new ArrayList<>(Arrays.asList(tokens));
       int i = 0;
       while (list.size() > 1) {

           if ("+/-*".contains(list.get(i))) {

               String operand = list.get(i);

               int a = Integer.parseInt(list.get(i - 2));
               int b = Integer.parseInt(list.get(i - 1));

               list.remove(i - 1);
               list.remove(i - 2);

               if (operand.equals("+")) {
                   list.set(i - 2, (a + b) + "");
               } else if (operand.equals("-")) {
                   list.set(i - 2, (a - b) + "");
               }  else if (operand.equals("*")) {
                   list.set(i - 2, (a * b) + "");
               }  else if (operand.equals("/")) {
                   list.set(i - 2, (a / b) + "");
               }

               i = i - 1;
              
           } else {
               i++;
           }

       }


       return Integer.parseInt(list.getFirst());
    }

    }
