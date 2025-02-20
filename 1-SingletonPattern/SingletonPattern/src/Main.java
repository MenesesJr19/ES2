import com.es2.singleton.Registry;

public class Main {
    public static void main(String[] args) {
        Registry singleton1 = Registry.getInstance();
        Registry singleton2 = Registry.getInstance();

        System.out.println("singleton1: " + singleton1);
        System.out.println("singleton2: " + singleton2);
    }
}