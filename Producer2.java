//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;

public class Producer2 implements Runnable {
    private Buffer b;
    private int quantity;

    public Producer2(Buffer b, int quantity) {
        this.b = b;
        this.quantity = quantity;
    }

    private int generateEvenInteger() {
        int number = (int)(Math.random() * 100.0D);
        return number % 2 == 1 ? number - 1 : number;
    }

    public void run() {
        for(; this.quantity > 0; this.quantity -= 2) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException var3) {
                throw new RuntimeException(var3);
            }

            try {
                this.b.put(Thread.currentThread().getName(), this.generateEvenInteger());
                this.b.put(Thread.currentThread().getName(), this.generateEvenInteger());
            } catch (InterruptedException var2) {
                throw new RuntimeException(var2);
            }
        }

        PrintStream var10000 = System.out;
        String var10001 = Thread.currentThread().getName();
        var10000.println("Producatorul " + var10001 + " a terminat de produs " + (this.quantity + 48) + " elemente.");
        --this.b.nrofProducers;
    }
}
