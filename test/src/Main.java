import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        char[] chars = Integer.toString(a).toCharArray();
        System.out.println(chars.length);
    }

    public static void play(Father father) {
       father.say();
    }
}

class Father {
    int a = 0;

    public Father() {
        System.out.println("Father: " + this.hashCode());
    }

    public void say() {
        System.out.println("Father");
    }
}

class Son extends Father {
    int a;


    @Override
    public void say() {
        System.out.println("Son");
    }
}
