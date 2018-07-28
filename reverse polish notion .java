package reversePolishNotion;

import java.util.LinkedList;
import java.util.Scanner;

public class reversePolishNotion {

   
    public static void main(String[] args) {
        String op="/*-+^";
        LinkedList<Character> stack=new LinkedList();
        Scanner sc=new Scanner(System.in);
        LinkedList<Character> queue=new LinkedList();
        String a=sc.next();
        char[] b=a.toCharArray();
        int n=b.length;
        for(int j=0;j<n;j++){
            if(op.indexOf(b[j])!=-1){//contains operator or opening braces
                if(b[j]=='^'){
                    if(stack.getLast()=='+' || stack.getLast()=='-' || stack.getLast()=='/' || stack.getLast()=='*'){
                        stack.add(b[j]);
                    }
                    else
                        stack.add(b[j]);
                }
                else if(b[j]=='*' || b[j]=='/' ){
                    if(stack.getLast()=='^'){
                        char q=stack.getLast();
                        queue.add(q);
                        stack.removeLast();
                        stack.add(b[j]);
                    }
                    else if(stack.getLast()=='+' || stack.getLast()=='-'){
                        stack.add(b[j]);
                    }
                    else
                        stack.add(b[j]);
                }
                else{
                    if(stack.getLast()=='/' || stack.getLast()=='*' || stack.getLast()=='^'){
                        char q=stack.getLast();
                        queue.add(q);
                        stack.removeLast();
                        stack.add(b[j]);
                    }
                    else
                        stack.add(b[j]);
                }
            }
            else if(b[j]=='('){
                stack.add(b[j]);
            }
            else if(b[j]==')'){//closing braces
                while(stack.getLast()!='('){
                    char q=stack.getLast();
                    queue.add(q);
                    stack.removeLast();
                }
                stack.removeLast();
            }
            else{// contains number
                queue.add(b[j]);
            }
            }
            for(int k=0;k<queue.size();k++) {
                System.out.print(queue.get(k));
            }
            System.out.println();
    }
    
}
