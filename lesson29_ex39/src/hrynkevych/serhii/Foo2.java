package hrynkevych.serhii;

@Start(priority = 100, method = "initialize")
public class Foo2 {

    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialize() {
        System.out.println("Class Foo2 initialized!");
    }
}
