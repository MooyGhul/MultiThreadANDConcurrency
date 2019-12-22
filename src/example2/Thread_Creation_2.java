package example2;

public class Thread_Creation_2 {
    public static void main(String[] args){
        Thread thread = new NewThread();
        thread.setName("Extended_Thread");
        thread.start();
    }

    private static class NewThread extends Thread{
        @Override
        public void run(){
            // can use this.getName() instead of Thread.currentThread().getName()
            System.out.println("Hello from "+ this.getName());
        }
    }
}
