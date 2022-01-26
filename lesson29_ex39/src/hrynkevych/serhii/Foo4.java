package hrynkevych.serhii;

@Start(priority = 80, method = "initialize")
public class Foo4 {

    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialize() {
        System.out.println("Class Foo4 initialized!");
    }
}
