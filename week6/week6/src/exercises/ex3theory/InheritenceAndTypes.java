package exercises.ex3theory;

/*
    Uncomment each row in turn and explain why the row compiles or not.

 */
public class InheritenceAndTypes {

    public static void main(String[] args) {
        new InheritenceAndTypes().program();
    }

    public void program() {
        IA ia = new A();

        ia = new B();
        ia = new C();
        //ia = new D();
        /* All the other classes implements IA interface, and the variable ia expects certain behaviours from
        class, but since the D class does not implement it will not satisfy the ia variable.*/
        ia = new E();

        A a = new A();
        //a = new B();
        a = new C();
        //a = new D();
        //a = new E();
        /*
        The a variable expects the behaviour and methods of the class A, and why we can create a new C object is because
        C extends A, which means C inherits all the methods and behaviour of A.
         */

        //B b = new A();
        //B b = new C();
        //C c = new D();
        //C c = new E();
        D d = new E();
        //E e = new C();
        //E e = new D();
        /*
        Here the variable we declare expects the behaviour and methods of a class not an interface, so it will be more
        specific. But we can still declare the variable with a class that is not the specified if it extends the class
        we want for our variable.
         */

    }

    // -------------  Interfaces and classes ----------------------

    public interface IA {

    }

    public class A implements IA {

    }

    public class B implements IA {

    }

    public class C extends A {
    }

    public class D {

    }

    public class E extends D implements IA {

    }


}
