package example3_ThreadCoordination;

import java.math.BigInteger;

public class ThreadTerm_2 {

    public static void main(String[] args){
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2"),new BigInteger("5")));

        // if we dont think we need to handle the thread interruption gracefully in the loop
        // then we can simply set the daemon property of the thread to true
        // if run the program, even though the long calculation has not finished, make sure that
        // the main thread ended makes the entire app terminated.
        // thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run(){
            System.out.println(base + "^" + power + " = " + pow(base,power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power)!=0; i=i.add(BigInteger.ONE)){
                // to answer the thread.interrupt().
                // Check if the currentThread is interrupted from the outside world
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
        return result;
        }


    }
}
