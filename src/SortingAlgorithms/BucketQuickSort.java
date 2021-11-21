package SortingAlgorithms;

import Model.LSManga.Series;
import Model.Parameter;
import Model.ParameterB;

import java.util.LinkedList;

public class BucketQuickSort {
    private static ParameterB p;

    public static LinkedList<Series> sort(LinkedList<Series> series, int i, int j){
        if (i < j) {
            p = particio(series, i, j);
            p.setArr(sort(series, i, p.getR()));
            p.setArr(sort(series, p.getL(), j));
        }
        return p.getArr();
    }

    public static ParameterB particio(LinkedList<Series> series, int low, int high) {
        ParameterB param = new ParameterB(series, low, high);
        param.setL(low);
        param.setR(high);
        int mig = (low + high)/2;
        Series pivot = series.get(mig);

        while (param.getL() <= param.getR()) {
            while (series.get(param.getL()).getAverageScore() > pivot.getAverageScore()) {
                param.setL(param.getL() + 1);
            }
            while (series.get(param.getR()).getAverageScore() < pivot.getAverageScore()) {
                param.setR(param.getR() - 1);
            }
            if (param.getL() < param.getR()) {
                Series tmp = series.get(param.getL());
                series.set(param.getL(), series.get(param.getR()));
                series.set(param.getR(), tmp);
                param.setL(param.getL() + 1);
                param.setR(param.getR() - 1);
            } else {
                if (param.getL() == param.getR()) {
                    param.setL(param.getL() + 1);
                    param.setR(param.getR() - 1);
                }
            }
        }
        return param;
    }
}
