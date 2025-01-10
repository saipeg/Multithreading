import lombok.SneakyThrows;

public class MyThread implements Runnable {
    Thread thrd;
    TickTock tickTock;

    MyThread(String name, TickTock tickTock) {
        thrd = new Thread(this, name);
        this.tickTock = tickTock;
        thrd.start();
    }

//    public static MyThread createAndStart(String name, TickTock tt) {
//        MyThread myThread = new MyThread(name, tt);
//        myThread.thrd.start();
//        return myThread;
//    }

    @SneakyThrows
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) tickTock.tick(true);
            tickTock.tick(false);

        } else {
            for (int i = 0; i < 5; i++) tickTock.tock(true);
            tickTock.tock(false);

        }
    }
}
