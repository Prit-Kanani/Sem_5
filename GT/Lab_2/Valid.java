package Lab_2;

import java.util.Scanner;
import java.util.Stack;

public class Valid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter the Brackets : ");
        String s = sc.nextLine();   
        if (!count(s)) {
            System.err.println("Not Valid!");
            sc.close();
            return;
        }

        Stack<Character> stack = new Stack<Character>();

        stack.push(s.charAt(0));
        if (s.charAt(0) == ')') {
            System.err.println("Not Valid!");
            sc.close();
            return;
        }
        int i = 1;
        while (i != s.length() || !stack.empty()) {
            char c = s.charAt(i);
            if(c ==')'){
                stack.pop();
            }
            else{
                stack.push('(');
            }
            i++;
        }
        if(i!=s.length()){
            System.err.println("Not Valid!");
            sc.close();
            return;
        }
        System.err.println("Valid!");
        sc.close();
    }

















    public static boolean count(String s) {
        int c = 0;
        int o = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                o++;
            } else {
                c++;
            }
        }
        if (c == o) {
            return true;
        }
        return false;
    }
}
