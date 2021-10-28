package SortingAlgorithms;

import Model.LSManga.Series;

public class MergeSort {

    public static Series[] sort(Series[] a, int i, int j) {
        if(i >= j) {
            return a;
        } else {
            int mig = (i + j) / 2;
            a = sort(a, i, mig);
            a = sort(a, mig + 1, j);
            a = merge(a, i, mig, j);
            return a;
        }
    }

    public static Series[] merge(Series[] a, int i, int mig, int j) {
        int l = i;
        int r = mig + 1;
        int cur = i;
        Series[] b = new Series[a.length];
        while(l <= mig && r <= j){
            if(a[l].getAverageScore() >= a[r].getAverageScore()){
                b[cur] = a[l];
                l++;
            }else{
                b[cur] = a[r];
                r++;
            }
            cur++;
        }
        while(l <= mig){
            b[cur] = a[l];
            l++;
            cur++;
        }
        while(r <= j){
            b[cur] = a[r];
            r++;
            cur++;
        }

        int k = i;
        while(k <= j){
            a[k] = b[k];
            k++;
        }
        return a;
    }
}