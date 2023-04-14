import java.util.Scanner;

public class Main {
    private static void showmenu(){
        System.out.println("1. fiecare producator produce cate 2 obiecte de fiecare data si consuma cate 2 de fiecare data");
        System.out.println("2. fiecare producator produce cate 2 obiecte de fiecare data si consuma cate 1 de fiecare data");
        System.out.println("3. fiecare producator produce cate 1 obiecte de fiecare data si consuma cate 2 de fiecare data");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //1. fiecare producator produce cate 2 obiecte de fiecare data si consuma cate 2 de fiecare data
        //2. fiecare producator produce cate 2 obiecte de fiecare data si consuma cate 1 de fiecare data
        //3. fiecare producator produce cate 1 obiecte de fiecare data si consuma cate 2 de fiecare data


        while (true){
            showmenu();
            int op = in.nextInt();
            showmenu();
            switch (op){
                case 1 ->{
                    Buffer buffer = new Buffer(2);
                    Producer1 prod11 = new Producer1(buffer, 47);
                    Producer1 prod12 = new Producer1(buffer, 47);
                    Thread p11 = new Thread(prod11);
                    Thread p12 =new Thread(prod12);
                    Consummer1 consummer11 = new Consummer1(buffer);
                    Consummer1 consummer12 = new Consummer1(buffer);
                    Consummer1 consummer13 = new Consummer1(buffer);
                    Thread c11 = new Thread(consummer11);
                    Thread c12 = new Thread(consummer12);
                    Thread c13 = new Thread(consummer13);
                    p11.start();
                    p12.start();
                    c11.start();
                    c12.start();
                    c13.start();

                }
                case 2 ->{
                    Buffer buffer = new Buffer(2);
                    Producer2 prod21 = new Producer2(buffer, 47);
                    Producer2 prod22 = new Producer2(buffer, 47);
                    Thread p21 = new Thread(prod21);
                    Thread p22 =new Thread(prod22);
                    Consummer2 consummer21 = new Consummer2(buffer);
                    Consummer2 consummer22 = new Consummer2(buffer);
                    Consummer2 consummer23 = new Consummer2(buffer);
                    Thread c21 = new Thread(consummer21);
                    Thread c22 = new Thread(consummer22);
                    Thread c23 = new Thread(consummer23);
                    p21.start();
                    p22.start();
                    c21.start();
                    c22.start();
                    c23.start();

                }
                case 3 ->{
                    Buffer buffer = new Buffer(2);
                    Producer3 prod31 = new Producer3(buffer, 47);
                    Producer3 prod32 = new Producer3(buffer, 47);
                    Thread p31 = new Thread(prod31);
                    Thread p32 =new Thread(prod32);
                    Consummer3 consummer31 = new Consummer3(buffer);
                    Consummer3 consummer32 = new Consummer3(buffer);
                    Consummer3 consummer33 = new Consummer3(buffer);
                    Thread c31 = new Thread(consummer31);
                    Thread c32 = new Thread(consummer32);
                    Thread c33 = new Thread(consummer33);
                    p31.start();
                    p32.start();
                    c31.start();
                    c32.start();
                    c33.start();

                }
                default -> {
                    System.out.println("Alege corect");
                }
            }

        }

    }
}