package example1;

public class Thread_Creation_1 {
    public static void main(String[] args) throws InterruptedException{

        // The thread object itself is empty by default so we need to pass it an object of a class
        // that implements the runnable interface into its constructor
        // The code inside this run method is going to be run on that new thread as soon as it is
        // scheduled by the operating system
        // Thread thread = new Thread(()->{});
        // The code is creating a new thread which if started(by calling the thread.start(), will
        // execute the code inside the run() method on new thread.
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                //code that will run in a new thread
                System.out.println("We are now in thread: "+ Thread.currentThread().getName());
                System.out.println("Current thread priority is "+ Thread.currentThread().getPriority());
            }
        }
        );

        // Otherwise, called thread zero;
        thread.setName("New Worker Thread");

        // we can set the static component of that dynamic priority programmatically
        // by calling the set priority method we can pass a value which ranges from 1 to 10
        // or use one of the predefined values -- the max priority, the min priority or the norm priority (default).
        thread.setPriority(Thread.MIN_PRIORITY);

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread1.setName("Misbehaving thread");
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e){
                System.out.println("A critical error happened in thread "+ t.getName()
                        + " the error is " + e.getMessage());
            }
        });

        System.out.println("We are in thread: "+ Thread.currentThread().getName() + " before starting a new thread");

        // instruct the JVM to create a new thread and pass it to the operating system
        thread.start();

        thread1.start();

        // after we called the .start() method, the new thread has not been scheduled yet, as that takes some time
        // and it happens synchronously by the OS, so it is also from the main thread.
        // OS compare which thread to be scheduled first. If both execute .getName() and getPriority(), then "Main" + "a new thread"
        //      else, the println with less method will be scheduled first.
        System.out.println("1. We are in thread: "+ Thread.currentThread().getName() + " after starting a new thread ");
        System.out.println("2. We are in thread: "+ Thread.currentThread().getName() + " after starting a new thread ");
        System.out.println("3. We are in thread: "+ Thread.currentThread().getName() + " after starting a new thread of PQ "+ Thread.currentThread().getPriority());


/*
        // MY OWN TEST
        System.out.println("NOW: Current is " + Thread.currentThread().getName() + ", the priority is "+ Thread.currentThread().getPriority());

        // .sleep(): instruct the OS to not schedule the current thread until that time passes
        // during that time this thread is not consuming any CPU
        Thread.sleep(10000);

        // MY OWN TEST
        System.out.println("NOW: Current is " + Thread.currentThread().getName() + ", the priority is "+ Thread.currentThread().getPriority());
*/
    }
}