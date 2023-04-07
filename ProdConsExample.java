import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProdConsExample {

    private static final int BUFFER_SIZE = 8;
    private static final int NUM_ITEMS = 49;

    private static final Object bufferLock = new Object();
    private static final Object printLock = new Object();

    private static final int[] buffer = new int[BUFFER_SIZE];
    private static int in = 0;
    private static int out = 0;
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose buffer type (1, 2, or 3):");
            System.out.println("1. Produces 1, consumes 2");
            System.out.println("2. Produces 2, consumes 1");
            System.out.println("3. Produces 2, consumes 2");

            int choice = scanner.nextInt();
            if (choice == 1) {
                Buffer1 buffer1 = new Buffer1();
                buffer1.start();
                buffer1.join();
            } else if (choice == 2) {
                Buffer2 buffer2 = new Buffer2();
                buffer2.start();
                buffer2.join();
            } else if (choice == 3) {
                Buffer3 buffer3 = new Buffer3();
                buffer3.start();
                buffer3.join();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    static class Buffer1 extends Thread {

        private Random random;

        public Buffer1() {
            this.random = new Random();
        }

        @Override
        public void run() {
            int item;
            for (int i = 0; i < NUM_ITEMS; i++) {
                item = random.nextInt(50) * 2;
                synchronized (bufferLock) {
                    while (count >= BUFFER_SIZE - 1) {
                        System.out.println("Buffer1 is full. Waiting to produce...");
                        try {
                            bufferLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer[in] = item;
                   // in = (in + 1) % BUFFER_SIZE;
                    count++;
                    synchronized (printLock) {
                        System.out.println("Producatorul a produs: " + item + ". Count = " + (count));
                        if (count == 3){
                            System.out.println("Buffer1 is full. Waiting to produce...");
                        }
                    }
                    bufferLock.notifyAll();
                }

                synchronized (bufferLock) {
                    while (count == 0) {
                        try {
                            bufferLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int consumedItem = buffer[out];
                   // out = (out + 1) % BUFFER_SIZE;
                    if (count == 2){
                        count--;
                    }

                    synchronized (printLock) {
                        System.out.println("Consumatorul a consumat: " + consumedItem + ". Count = " + (count-1));
                        if (count == 0){
                            System.out.println("Buffer1 is empty. Waiting to produce...");
                        }
                        if (count > 2){
                            System.out.println("Buffer1 is full. Waiting to produce...");
                        }
                    }
                    bufferLock.notifyAll();
                }
            }
        }
    }


    static class Buffer2 extends Thread {

        private Random random;

        public Buffer2() {
            this.random = new Random();
        }

        @Override
        public void run() {
            int item1, item2;
            for (int i = 0; i < NUM_ITEMS / 2; i++) {
                item1 = random.nextInt(50) * 2;
                item2 = random.nextInt(50) * 2;
                synchronized (bufferLock) {
                    while (count >= BUFFER_SIZE - 2) {
                        try {
                            bufferLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer[in] = item1;
                    in = (in + 1) % BUFFER_SIZE;
                    buffer[in] = item2;
                    in = (in + 1) % BUFFER_SIZE;
                    count += 2;
                    synchronized (printLock) {
                        System.out.println("Buffer2 produced " + item1 + " and " + item2 + ". Count = " + count);
                    }
                    bufferLock.notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bufferLock) {
                    while (count <= 1) {
                        try {
                            if (count == 0){
                                System.out.println("Buferul este gol!");
                            }
                            bufferLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int consumedItem = buffer[out];
                    out = (out + 1) % BUFFER_SIZE;
                    count--;
                    synchronized (printLock) {
                        System.out.println("Buffer2 consumed " + consumedItem + ". Count = " + count);
                    }
                    consumedItem = buffer[out];
                    out = (out + 1) % BUFFER_SIZE;
                    count--;
                    synchronized (printLock) {
                        System.out.println("Buffer2 consumed " + consumedItem + ". Count = " + count);
                    }
                    bufferLock.notifyAll();
                }
            }
        }
    }

    static class Buffer3 extends Thread {

        private Random random;

        public Buffer3() {
            this.random = new Random();
        }

        @Override
        public void run() {
            int item1, item2;
            for (int i = 0; i < NUM_ITEMS / 2; i++) {
                item1 = random.nextInt(50) * 2;
                item2 = random.nextInt(50) * 2;
                synchronized (bufferLock) {
                    while (count >= BUFFER_SIZE - 2) {
                        try {
                            bufferLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer[in] = item1;
                    in = (in + 1) % BUFFER_SIZE;
                    buffer[in] = item2;
                    in = (in + 1) % BUFFER_SIZE;
                    count += 2;
                    synchronized (printLock) {
                        System.out.println("Buffer3 produced " + item1 + " and " + item2 + ". Count = " + count);
                    }
                    bufferLock.notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bufferLock) {
                    while (count <= 1) {
                        try {
                            bufferLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int consumedItem1 = buffer[out];
                    out = (out + 1) % BUFFER_SIZE;
                    int consumedItem2 = buffer[out];
                    out = (out + 1) % BUFFER_SIZE;
                    count -= 2;
                    synchronized (printLock) {
                        System.out.println("Buffer3 consumed " + consumedItem1 + " and " + consumedItem2 + ". Count = " + count);
                    }
                    bufferLock.notifyAll();
                }
            }
        }
    }
}

