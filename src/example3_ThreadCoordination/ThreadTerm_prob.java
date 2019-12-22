package example3_ThreadCoordination;

public class ThreadTerm_prob {
    public static void main(String [] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
    }

    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception caught, terminated");
                    return;
                }
            }
        }
    }
}
