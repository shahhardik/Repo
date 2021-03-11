package in.shahhardik;

public class PalindromeCheck {
    static char[] stack;
    static int top = -1;

    public static void main(String args[]) {
        stack = new char[10];

        String str1 = "hardikshah";
        String str2 = "level";
        String str3 = "levvel";

        System.out.println(" Is String "+str1+" Palindrome ? " + isPalinDrome(str1));
        System.out.println(" Is String "+str2+" Palindrome ? " + isPalinDrome(str2));
        System.out.println(" Is String "+str3+" Palindrome ? " + isPalinDrome(str3));
    }

     static void push(char c) {
        stack[++top] = c;
    }

    static char pop() {
        if(top>-1) stack[top+1] = ' ';
        char c =  stack[top--];
        return c;
    }

    static int top() {
        return top;
    }

    private static boolean isPalinDrome(String str) {
        if(str == null ) return false;

        /*
        // Method 1 : Simple reverse and compare
        StringBuilder stringBuilder = new StringBuilder(str);
        return (stringBuilder.reverse().toString()).equals(str);
        */

        /*
        // Method 2 :  Comparing Starting and Ending
        int count = str.length();
        if(count > 1) {
            for(int i = 0 ; i < count/2; i++)
            {
                if(str.charAt(i) != str.charAt(count-i-1))
                    return false;
            }
            return true;
        }
        else if (count == 1) return true;
        else
            return false;
         */

        // Method 3 : Using Stack
        int len = str.length();
        int mid = len/2;
        boolean skipMiddle = false;
        if(len % 2 == 1) skipMiddle = true;
        boolean isPalindrome = true;

        for(int i = 0 ; i < len ; i++) {
            if(i < mid) {
                // Push
                push(str.charAt(i));
            }
            else {
                // pop
                if(skipMiddle && i == mid) {
                    System.out.println("Skip "+str.charAt(i));
                    continue;
                }
                if(str.charAt(i) != pop())
                    isPalindrome = false;
            }
            System.out.println(stack);
        }
        return  isPalindrome;
    }
}
