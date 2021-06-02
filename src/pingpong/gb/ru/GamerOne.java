package pingpong.gb.ru;

public class GamerOne implements Runnable {
    PingPong pp;

    public GamerOne(PingPong pp) {
        this.pp = pp;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            pp.ping();
        }
    }
}



