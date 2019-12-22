package example1;

public class Thread_Order {
    // Can appear in the output in any order. There is no way of knowing for certain.
    public static void main(String[] args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm going for a walk");
            }
        });

        Thread thread2 = new Thread(()-> {
                System.out.println("I'm going to swim");
            });

        thread1.start();
        thread2.start();
        System.out.println("I'm going home");
    }

}
