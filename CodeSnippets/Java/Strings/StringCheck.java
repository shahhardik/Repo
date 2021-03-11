package in.shahhardik;

import java.text.Collator;

public class StringCheck {
    public static void main(String args[]) {

        Collator collator = Collator.getInstance();

        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");
        String d = new String("Hello");

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(c==d);
        System.out.println(a==d);
        System.out.println(b==d);

        System.out.println("**************");
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(c.intern()));

        System.out.println("**************");

        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(c.equals(d));
        System.out.println(a.equals(d));
        System.out.println(b.equals(d));

        System.out.println("**************");

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(c.compareTo(d));
        System.out.println(a.compareTo(d));
        System.out.println(b.compareTo(d));
        System.out.println("**************");

        System.out.println(collator.compare(a,b));
        System.out.println(collator.compare(b,c));
        System.out.println(collator.compare(c,d));
        System.out.println(collator.compare(a,d));
        System.out.println(collator.compare(b,d));

    }
}
