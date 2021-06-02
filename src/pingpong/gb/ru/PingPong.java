package pingpong.gb.ru;

public class PingPong {
    boolean flag = false;

    synchronized void ping() {
        while (!flag) {
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Ping");
        ;
        flag = false;
        notify();
    }

    synchronized void pong() {
        while (flag) {
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pong");
        flag = true;
        notify();
    }
}



