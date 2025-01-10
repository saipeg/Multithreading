
public class Main {
    public static void main(String[] args) {

        TickTock tickTock = new TickTock();

        MyThread thread1 = new MyThread("Tick", tickTock);
        MyThread thread2 = new MyThread("Tock", tickTock);
    }
}
