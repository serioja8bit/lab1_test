public class Consummer3 implements Runnable{
    private Buffer b;
    private int nrofItems=0;

    public Consummer3(Buffer b){
        this.b = b;

    }
    private boolean checkisAviable(){
        if(b.stock.isEmpty() && b.nrofProducers ==0 )
            return false;
        else
            return true;
    }


    @Override
    public void run() {
        while (checkisAviable()){
            if(b.nrofProducers == 0 && b.stock.size()==0)
                break;
            try{
                Thread.sleep(200);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


                try {
                        b.get(Thread.currentThread().getName());
                        b.get(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                nrofItems = nrofItems + 2;
            if(b.nrofProducers == 0)
                break;

        }
        System.out.println("Consumatorul "+ Thread.currentThread().getName()+ " a terminat de consumat ");

    }
}
