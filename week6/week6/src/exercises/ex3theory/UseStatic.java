package exercises.ex3theory;

import static java.lang.System.out;

/*
      If uncommenting you will get compile errors? Explain, in depth!

      Static is for the class, you should be able to write: UseStatic.doOther(), just like you can do with Math.round()
      Static does not require an instance in order to run, and if you need to be able to run it without an instance, then
      you can not invovle instances (instance variables or methods) into a static method.

      This is the reason why the program will fail if we uncomment the code, we are mixing instance methods (they do not
      always exist) with static methods (that always exists).

      But we can use static methods in our instance methods because if we have initialized the class somewhere the there
      is an instance of it and since we can always run static (class) methods we can use them in our instance methods.
 */
public class UseStatic {

    private static int i;
    private int j;

    public static void main(String[] args) {
        //doIt();
        doOther();
    }

    void doIt() {
        out.println(i);
        out.println(j);
        this.doOther();
    }

    static void doOther() {
        out.println(i);
        //out.println(j);
        //this.doIt();
    }

}
