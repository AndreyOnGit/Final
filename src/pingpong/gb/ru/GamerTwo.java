package pingpong.gb.ru;

public class GamerTwo implements Runnable {
    PingPong pp;

    public GamerTwo(PingPong pp) {
        this.pp = pp;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            pp.pong();
        }
    }
}
