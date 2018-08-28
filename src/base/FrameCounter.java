package base;

public class FrameCounter {
    private int timeInterval;
    private int count;

    public FrameCounter(int timeInterval) {
        this.timeInterval = timeInterval;
        this.count = 0;
    }

    public boolean run() {
        if (this.count == this.timeInterval) {
            this.reset();
            return true;
        } else {
            this.count ++;
            return false;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
