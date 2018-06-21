/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13521
Problem Statement
        In most programming languages variable names cannot contain spaces. If we want a variable name that consists of two or more words, we have to encode the spaces somehow. In this problem, we will look at two ways of doing so: Snake Case and Camel Case. When using Snake Case, we just replace each space by an underscore ('_'). 
        When using Camel Case, we capitalize the first letter of each word except for the first one, and then we remove all spaces.
For example, suppose that we want to declare a variable called "good morning world" (quotes for clarity). In Snake Case, we would write this variable as "good_morning_world", while in Camel Case it would be "goodMorningWorld".
You are given a String variableName. This String contains a valid variable name written in Snake Case. Return the same variable name in Camel Case.
 
Definition
Class:  NamingConvention
Method: toCamelCase
Parameters: String
Returns:    String
Method signature:   String toCamelCase(String variableName)
(be sure your method is public)
    
Constraints
-   variableName will contain between 1 and 50 characters.
-   Each character of variableName will be 'a'-'z' or '_'.
-   The first and last character of variableName will not be '_'.
-   variableName will not contain two consecutive underscores ('_').
 
Examples
0)  "sum_of_two_numbers"
Returns: "sumOfTwoNumbers"
We have 4 words: "sum", "of", "two", "numbers". So the answer is "sum" + "Of" + "Two" + "Numbers".

1)  "variable"
Returns: "variable"
Note that if we have only 1 word, then the varaible name will remain same.

2)  "t_o_p_c_o_d_e_r"
Returns: "tOPCODER"

3)  "the_variable_name_can_be_very_long_like_this"
Returns: "theVariableNameCanBeVeryLongLikeThis"
*/

import java.util.*;
public class NamingConvention {
    static String toCamelCase(String varName) {
        String camelCaseVariable="";

        if(varName.length()==1) {
            camelCaseVariable=varName;
        }
        else if(varName.length()==0) {
            camelCaseVariable="";
        }
        else {
            camelCaseVariable=String.valueOf(varName.charAt(0));
            for(int i=1; i<varName.length(); i++) {
                if((varName.charAt(i)=='_')&(i<varName.length()-1)) {
                    camelCaseVariable+=String.valueOf(varName.charAt(i+1)).toUpperCase();
                    i++;
                }
                //if _ is at the end of variable string    
                else if((varName.charAt(i)=='_')&(i==varName.length()-1)) {
                    camelCaseVariable=camelCaseVariable;
                }
                else {
                    camelCaseVariable+=String.valueOf(varName.charAt(i));
                }
            }//for loop ends...    
        }
        return camelCaseVariable;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter snake case variable name : ");
        String snakeCase = sc.nextLine();
        System.out.println("\nCamel case variable name is : " + toCamelCase(snakeCase));
    }
}
