package Model;

public class Parameter {
    private Series[] arr;
    private int l;
    private int r;

    public Parameter(Series[] arr, int l, int r) {
        this.arr = arr;
        this.l = l;
        this.r = r;
    }

    public Series[] getArr() {
        return arr;
    }

    public void setArr(Series[] arr) {
        this.arr = arr;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}