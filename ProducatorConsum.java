//import java.util.ArrayList;
//
//class Store{
//
//    ArrayList<String> stockList=new ArrayList<>();
//    private String str1;
//
//    public synchronized String get(String str) {
//        while (stockList.size()<1) {
//            try {
//                wait();
//            } catch (InterruptedException e) { }
//        }
//
//        str1 = stockList.get(stockList.size()-1);
//
//        stockList.remove(stockList.size()-1);
//        if(!stockList.isEmpty()){
//            System.out.print("Letters in stock: "+stockList.size()+" : ");
//            stockList.forEach((consonal) -> {
//                System.out.print(consonal+ " ");
//            });
//            System.out.println(" ");
//        } else{
//            System.out.println("Deposit is empty");
//        }
//        notifyAll();
//        return str1;
//    }
//
//    public synchronized void put(String str, String a) {
//        while (stockList.size()>10) {
//            try {
//                wait();
//            } catch (InterruptedException e) { }
//        }
//        System.out.print(str + " put letter: ");
//        stockList.add(a);
//        System.out.print(stockList.get(stockList.size()-1)+", ");
//
//        if(!stockList.isEmpty()){
//            System.out.print("Letters in stock: "+stockList.size()+" : ");
//            stockList.forEach((consonal) -> {
//                System.out.print(consonal + " ");
//            });
//            System.out.println(" ");
//        }else{
//            System.out.println("Stock is empty");
//        }
//
//        notifyAll();
//    }
//}
//
//class Producer extends Thread{
//    Store s;
//    static int pro = 0;
//    public Producer(Store s) {
//        this.s = s;
//    }
//    @Override
//    public void run() {
//        String[] consonal = new String[]{"***","!!!","@","%",">&<"};
//        while(pro<9){
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException ex) {
//                System.out.println(ex);
//            }
//            if(pro==37)break;
//
//            synchronized(this){
//
//                if(pro==10)break;
//
//                s.put(getName(), consonal[(int)(Math.random()*5)]);
//                pro++;
//
//                System.out.println("Producers put " + pro);
//            }
//            if(pro==10)break;
//        }
//        System.out.println("-->"+getName()+ "  stopped");
//
//    }
//}
//
//class Consumer extends Thread{
//    private final Store s;
//    static int cons = 0;
//    private String str1;
//    public Consumer(Store s) {
//        this.s = s;
//
//    }
//    @Override
//    public void run() {
//        while(cons<10){
//            if(cons==10)break;
//            try {
//                Thread.sleep(150);
//            } catch (InterruptedException ex) {
//                System.out.println(ex);
//            }
//            if(cons==10)break;
//
//            str1 = s.get(getName());
//
//            System.out.println(getName()+" consumed: "+str1);
//            cons++;
//
//            System.out.println("Consumers got " + cons);
//
//            if(cons==10)break;
//
//        }
//        System.out.println('\n'+"-->" + getName() + "  stopped");
//    }
//}
//
//public class ProdCons {
//    public static void main(String[] args) {
//        Store store=new Store();
//        Producer p1 = new Producer(store);
//        p1.setName("Producer 1");
//        Consumer c1 = new Consumer(store);
//        c1.setName("Consumer 1");
//        p1.start();
//        c1.start();
//    }
//}
