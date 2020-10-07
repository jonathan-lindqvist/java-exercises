package exercises.ex3theory;

/*
      Uncomment a)-h) one at the time and explain
      what happens and why.
      If no errors, what is printed out, explain why.

      Remember: Static/declared type is type of variable. Type of object
      (=runtime type/dynamic type) may differ!

      A a = new A();      // Declared and object type the same
      A a = new B()       // Not the same (B must be subtype)

      Declared type decides what is possibly (at all) to do with the
      variable (i.e. which methods to call, checked compile time)

      Object type decides which version of method (if overriding) should be called
      (decided runtime)

 */
public class TypesAndOverride {

    public static void main(String[] args) {
        new TypesAndOverride().program();
    }

    void program() {
        // a
        D d = new D();
        C c = d;
        c.doIt();
        /*
        We create a new object of the D class, then we can assign the the object to a new variable because the object is
        a subtype of C. But the pointer is still to the D object so when we run doIt it references the method in class D.
         */

        // b
        IY iy = new D();
        C c1 = (C) iy;
        c1.doOther();
        /*
        We create a new object of D class, we can do this because D inherits everything from C which implements the IY interface.
        Our object inherits the doOther method and will run it as its own, hence why we get it "DoOther D".
         */

        // c
        A a = new B();
        a.doIt(1);
        /*
        Because the variable it is of type A it will look for the first doIt method that can handle the argument using.
         */

        // d
        IX ix = new B();
        IY iy3 = new C();
        //ix = (IX) iy3;
        //ix.doIt();
        /*
        This will fail because we are trying to cast iy3 to the type IX. C implements IY, not IX, so now they are not
        connected.
         */

        // e
        A a4 = new C();
        //D d1 = (D) a4;
        //d1.doIt(1.0);
        /*
        Since a4 is of type A in can be casted because everything that A has, C inherits. D inherits C and not A, so there is not direct
        connection between them. So this will fail.
         */


        // f
        C c2 = new D();
        //B b = (B) c2;
        /*
        This will fail. Just because C and B both extend A does not mean they are the same, C could implement methods that A does not have
        and therefore B cant be casted here.
         */

        // g
        C c3 = new C();
        A a1 = c3;
        //a1.doOther();
        /*
        Will also fail because class A does not have the doOther method, and we are "converting" c3 into type A.
         */

        // h
        IY iy2 = new C() {  // Anonymous subclass to C created
            @Override
            public void doOther() {
                super.doOther();
            }
        };
        iy2.doOther();
        /*
        Anonymous classes do not have names. So it will just print "DoOther"
         */

    }


    // ---------- Interfaces and classes -------------------------

    public interface IX {
        void doIt();
    }

    public interface IY {
        void doOther();
    }

    public class A {
        public void doIt(double d) {
            System.out.println("Doit A " + d);
        }
    }

    public class B extends A implements IX {
        public void doIt() {
            System.out.println("Doit B");
        }
        public void doIt(int i) {
            System.out.println("Doit B " + i);
        }
    }

    public class C extends A implements IY {
        public void doIt() {
            System.out.println("Doit C");
        }

        public void doOther() {
            System.out.println("DoOther " + this.getClass().getSimpleName());
        }
    }

    public class D extends C {
        public void doIt() {
            System.out.println("Doit D");
        }
    }

}
