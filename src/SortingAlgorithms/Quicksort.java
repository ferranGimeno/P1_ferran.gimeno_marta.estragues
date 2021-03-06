package SortingAlgorithms;

import Model.Parameter;
import Model.LSManga.Series;

public class Quicksort {
    private static Parameter p;

    public static Series[] sort(Series[] series, int i, int j){
        if (i < j) {
            p = particio(series, i, j);
            p.setArr(sort(series, i, p.getR()));
            p.setArr(sort(series, p.getL(), j));
        }
        return p.getArr();
    }

    public static Parameter particio(Series[] series, int low, int high) {
        Parameter param = new Parameter(series, low, high);
        param.setL(low);
        param.setR(high);
        int mig = (low + high)/2;
        Series pivot = series[mig];

        while (param.getL() <= param.getR()) {
            while (series[param.getL()].getPriorityComb() > pivot.getPriorityComb()) {
                param.setL(param.getL() + 1);
            }
            while (series[param.getR()].getPriorityComb() < pivot.getPriorityComb()) {
                param.setR(param.getR() - 1);
            }
            if (param.getL() < param.getR()) {
                Series tmp = series[param.getL()];
                series[param.getL()] = series[param.getR()];
                series[param.getR()] = tmp;
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