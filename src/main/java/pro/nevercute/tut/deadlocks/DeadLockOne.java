package pro.nevercute.tut.deadlocks;

public class DeadLockOne {

    static class A {
        static final B b = new B();
    }

    static class B {
        static final A a = new A();
    }

    /*public static void main(String[] args) {
        System.out.println("A construct");
        new Thread(A::new).start();
        System.out.println("B construct");
        new B();
        System.out.println("Objects A&B was constructed");
    }              */
}
