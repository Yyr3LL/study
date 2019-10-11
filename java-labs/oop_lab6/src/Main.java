import java.util.Scanner;

class Task1 extends Thread{
    private static final double DIVIDER = 1_000_000;
    String s;
    int times;

    Task1(int times){
        this.times = times;
        this.s = "adasdasdasdasdadasdasdasd";
    }

    public void run() {
        long start = System.nanoTime();
        int count = 0;
        for(int i = 0; i<this.times;i++) {
            if(i%2==0)s+="qwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqw"; count++;
        }
//		System.out.println("Task1 - "+(System.nanoTime() - start)/DIVIDER);
        System.out.println("Task 1 proceed " + count + " times");
        return;
    }
}

class Task2 extends Thread{
    private static final double DIVIDER = 1_000_000;
    String s;
    int times;

    Task2(int times){
        this.times = times;
        this.s = "adasdasdasdasdadasdasdasd";
    }

    public void run() {
        long start = System.nanoTime();
        int count = 0;
        for(int i = 0; i<this.times;i++) {
            if(i%3==0)s+="PPpPpPpPpPpPpPpPpPpPpPpPppPpPpPpPpPp"; count++;
        }
//		System.out.println("Task1 - "+(System.nanoTime() - start)/DIVIDER);
        System.out.println("Task 2 proceed " + count + " times");
        return;
    }
}

class Task3 extends Thread{
    private static final double DIVIDER = 1_000_000;
    String s;
    int times;

    Task3(int times){
        this.times = times;
        this.s = "oaoaoaoaoaoaoaoaoaooa";
    }

    public void run() {
        long start = System.nanoTime();
        int count = 0;
        for(int i = 0; i<this.times;i++) {
            if(i%2==0)s+="zxzxzxzxzxzxzxzxzxzxzxzxzxzxzxzxzx"; count++;
        }
//		System.out.println("Task1 - "+(System.nanoTime() - start)/DIVIDER);
        System.out.println("Task 3 proceed " + count + " times");
        return;
    }
}


class TimeLimitChecker extends Thread{
    private static final double DIVIDER = 1_000_000;
    private float time_limit;

    TimeLimitChecker(float limit){
        this.time_limit = limit;
    }

    public void run() {
        float start = System.nanoTime();
        while(((System.nanoTime() - start)/DIVIDER) < time_limit) {
        }
        System.exit(-1);
    }
}

public class Main{

    private static final double DIVIDER = 1_000_000;

    public static void main(String[] args) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Type times tasks will proceed: ");
        int times = scan.nextInt();
        Task1 t1 = new Task1(times);
        Task2 t2 = new Task2(times);
        Task3 t3 = new Task3(times);
        System.out.println("m - MultiPotochniy \ng - Postupovo");
        char ch = scan.next().charAt(0);
        System.out.println("Type limit time in ms: ");
        float limit = scan.nextFloat();
        scan.close();
        long start;
        double end = 0;
        switch(ch) {
            case ('m'):

                start = System.nanoTime();
                t1.start();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t2.start();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t3.start();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t1.join();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t2.join();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t3.join();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                end = (System.nanoTime() - start)/DIVIDER;

                System.out.println("MultiPotok - "+end);
                break;

            case('g'):

                start = System.nanoTime();
                t1.start();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t1.join();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t2.start();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t2.join();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t3.start();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                t3.join();
                if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
                end = (System.nanoTime() - start)/DIVIDER;
                System.out.println("Postupovo - "+end);
                break;

        }



    }

}
