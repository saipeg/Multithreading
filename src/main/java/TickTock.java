import lombok.SneakyThrows;

public class TickTock {
    String state;

    @SneakyThrows
    synchronized void tick(boolean running)  {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }
        Thread.sleep(800);
        System.out.print("Tick ");
        state = "ticked";
        notify();

        try {
            while (!state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }
    @SneakyThrows
    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }
        Thread.sleep(300);
        System.out.println("Tock");
        state = "tocked";
        notify();
        try {
            while (!state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }
}
