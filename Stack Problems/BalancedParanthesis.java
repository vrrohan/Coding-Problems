import java.util.*;
public class BalanceParanthesis {  
    static boolean isBalanced(String str) {
        boolean b = true;
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='['|str.charAt(i)=='{'|str.charAt(i)=='(') {
                //System.out.println("\npushing " + str.charAt(i) + " into stack...");
                st.push(str.charAt(i));
                System.out.print("\nstack elements are : ");
                st.forEach(x -> System.out.print(x + " "));    
            }
            if(str.charAt(i)==']') {
                try {
                    if(st.peek()=='[') {    st.pop();   }
                    else {  b=false;    }
                }
                catch(EmptyStackException es) {
                    System.out.println("stack is now empty");
                    b=false;
                }
            }
            //check for this condition - ()))
            //last 2 )) , when come, will try to first seek() which throws EmptyStackException, & then set b to false in catch block.
            //cannot use finally block, becus if no exception is thrown & normal pop() executes it will always set b to false, which means paranthesis are not balanced.
            if(str.charAt(i)==')') {
                try {
                    if(st.peek()=='(') {    st.pop();   }
                    else {  b=false;    }
                }
                catch(EmptyStackException es) {
                    System.out.println("stack is now empty");
                    b=false;
                }
            }
            if(str.charAt(i)=='}') {
                try {
                    //peek() throws EmptyStackException
                    if(st.peek()=='{') {    st.pop();   }
                    else {  b=false;    }
                }
                catch(EmptyStackException es) {
                    System.out.println("stack is now empty");
                    b=false;
                }            
            }
        }//end of for loop
        //to check for condition - ((((((()), last 4 will be popped out of stack, but first 5 still in stack so need to check that after string paranthesis is processed.
        //hence, we need to check if stack is still empty or not.
        if(st.size()>0) {
            b=false;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter paranthesis string to check for balancing : ");
        String paran = sc.nextLine();

        if(isBalanced(paran)) {
            System.out.println("\nparanthesis are balanced...");
        }
        else {
            System.out.println("\nparanthesis are not balanced...");
        }
    }
}
