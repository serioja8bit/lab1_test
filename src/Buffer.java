//1. fiecare producator produce cate 2 obiecte de fiecare data si consuma cate 2 de fiecare data
//2. fiecare producator produce cate 2 obiecte de fiecare data si consuma cate 1 de fiecare data
//3. fiecare producator produce cate 1 obiecte de fiecare data si consuma cate 2 de fiecare data

import java.util.ArrayList;

public class Buffer {
    public ArrayList<Integer> stock = new ArrayList<>();
    public int nrofProducers;


    public Buffer(int nrofProducers){
        this.nrofProducers = nrofProducers;
    }



    public synchronized void get(String name) throws InterruptedException {

        while(stock.size() == 0){
            System.out.println("Deposit gol");

                wait();
        }

        System.out.println("Consumatorul "+name+" a consumat " + stock.get(stock.size()-1) );
        stock.remove(stock.size()-1);

        notifyAll();

    }

    public synchronized void put(String name, int number) throws InterruptedException {

        //pune cate 1
        while (stock.size()>=8){
            //text.appendText("Deposit Plin \n");
            System.out.println("Deposit plin");
            wait();
        }

            stock.add(number);
            System.out.println("Producatorul "+ name + " a pus "+ number);
            //text.appendText("Producatorul "+ name + " a pus "+ number +"\n");
            //text.setText(stock.toString()+"\n");

        notifyAll();
    }

}
