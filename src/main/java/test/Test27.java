package test;

public class Test27 {
    private static final InheritableThreadLocal<String> TRACE_ID = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        TRACE_ID.set("trace-123");

        new Thread(() -> {
            // 子线程能拿到父线程设置的值
            System.out.println(TRACE_ID.get());  // 输出: trace-123
        }).start();
    }
}
