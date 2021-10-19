package C00_utils;

public class Pair {
    private int a;
    private int b;

    private int[] points;

    public Pair(int x, int y) {
        this.a = x;
        this.b = y;

        this.points = new int[2];
        this.points[0] = x;
        this.points[1] = y;
    }

    public int getFirst() {
        return this.points[0];
    }

    public int getSecond() {
        return this.points[1];
    }
}
