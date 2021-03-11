package in.shahhardik;

public class InitStaticConstructorBlocks {
    public static void main(String args[]) {
        System.out.println("******************************");
        //A a = new A();
        System.out.println("******************************");
        A a2 = new B();
        System.out.println("******************************");
        //B b = new B();
        System.out.println("******************************");
    }
}
class A {
    {
        System.out.println("A Initialization Block");
    }
    static {
        System.out.println("A static Block");
    }

    A(){
        System.out.println("A Constructor Block");
    }
}
class B extends A {
    {
        System.out.println("B Initialization Block");
    }
    static {
        System.out.println("B static Block");
    }

    B(){
        System.out.println("B Constructor Block");
    }

}
