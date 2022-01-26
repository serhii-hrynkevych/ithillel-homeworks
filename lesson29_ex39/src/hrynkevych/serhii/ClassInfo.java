package hrynkevych.serhii;

public class ClassInfo implements Comparable<ClassInfo> {
    private final String simpleName;
    private final String nameClass;
    private final int priority;
    private final String method;

    public ClassInfo(String simpleName, String nameClass, int priority, String method) {
        this.simpleName = simpleName;
        this.nameClass = nameClass;
        this.priority = priority;
        this.method = method;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getNameClass() {
        return nameClass;
    }

    public int getPriority() {
        return priority;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "Simple name class : " + simpleName + ", name class : " + nameClass
                + ", priority : " + priority + ", method : " + method + "\n";
    }

    @Override
    public int compareTo(ClassInfo o) {
        return this.priority - o.getPriority();
    }
}
