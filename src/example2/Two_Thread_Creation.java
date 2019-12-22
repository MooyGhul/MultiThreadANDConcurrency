package example2;

public class Two_Thread_Creation {
    public static void main(String [] args) {
        Thread thread1 = new Thread(new Task2());
        Thread thread2 = new TaskThread1();

        thread1.start();
        thread2.start();
    }


    private static class TaskThread1 extends Thread {
        @Override
        public void run(){
            System.out.println("Hello from new thread1");
        }
    }

    private static class Task2 implements Runnable {
        @Override
        public void run(){
            System.out.println("Hello from new thread2");
        }
    }
}
