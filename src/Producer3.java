public class Producer3 implements Runnable {
    private Buffer b;
    private int quantity;

    public Producer3(Buffer b, int quantity){
        this.b = b;
        this.quantity = quantity;
    }
    private int generateEvenInteger(){
        int number = (int) (Math.random() * 100);
        if (number % 2 == 1)
            return number - 1;
        else
            return number;
    }

    @Override
    public void run() {
        while (quantity > 0){

            try{
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

                try {
                    b.put(Thread.currentThread().getName(), generateEvenInteger());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                quantity = quantity - 1;

            }
        System.out.println("Producatorul "+ Thread.currentThread().getName()+ " a terminat de produs "+ (int)(quantity+47) + " elemente.");
        b.nrofProducers --;
    }
}
