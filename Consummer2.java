//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Consummer2 implements Runnable {
    private Buffer b;
    private int nrofItems = 0;

    public Consummer2(Buffer b) {
        this.b = b;
    }

    private boolean checkisAviable() {
        return !this.b.stock.isEmpty() || this.b.nrofProducers != 0;
    }

    public void run() {
        while(true) {
            if (this.checkisAviable() && (this.b.nrofProducers != 0 || this.b.stock.size() != 0)) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException var3) {
                    throw new RuntimeException(var3);
                }

                try {
                    this.b.get(Thread.currentThread().getName());
                } catch (InterruptedException var2) {
                    throw new RuntimeException(var2);
                }

                ++this.nrofItems;
                if (this.b.nrofProducers != 0) {
                    continue;
                }
            }

            System.out.println("Consumatorul " + Thread.currentThread().getName() + " a terminat de consumat ");
            return;
        }
    }
}
