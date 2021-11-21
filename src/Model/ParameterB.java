package Model;

import Model.LSManga.Series;

import java.util.LinkedList;

public class ParameterB {
    private LinkedList<Series> series;
    private int l;
    private int r;

    public ParameterB(LinkedList<Series> series, int l, int r) {
        this.series = series;
        this.l = l;
        this.r = r;
    }

    public LinkedList<Series> getArr() {
        return series;
    }

    public void setArr(LinkedList<Series> series) {
        this.series = series;
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