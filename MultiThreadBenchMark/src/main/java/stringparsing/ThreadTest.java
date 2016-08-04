package stringparsing;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            Thread td = new Thread(new TestThread());
            td.start();
        }
    }
}
