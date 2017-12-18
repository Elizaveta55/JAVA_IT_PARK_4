

public class Way {
    private Point begin;
    private Point end;
    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Point getEnd() {
        return end;
    }

    public Point getBegin() {
        return begin;
    }

    public Way(Point begin, Point end){
        this.begin = begin;
        this.end = end;
        distance = 0;
    }
}
