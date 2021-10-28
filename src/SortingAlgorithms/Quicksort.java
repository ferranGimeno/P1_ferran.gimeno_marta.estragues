package SortingAlgorithms;

import Model.Parameter;
import Model.LSManga.Series;

public class Quicksort {
    private static Parameter p;

    public static Series[] sort(Series[] arr, int i, int j){
        if (i < j) {
            p = particio(arr, i, j);
            p.setArr(sort(arr, i, p.getR()));
            p.setArr(sort(arr, p.getL(), j));
        }
        return p.getArr();
    }

    public static Parameter particio(Series[] arr, int low, int high) {
        Parameter param = new Parameter(arr, low, high);
        param.setL(low);
        param.setR(high);
        int mig = (low + high) / 2;
        //int pivot = arr[mig];
        int pivot = arr[mig].getAverageScore(); //TODO Afegir la funció

        while (param.getL() <= param.getR()) {
            while (arr[param.getL()].getAverageScore() < pivot) {
                param.setL(param.getL() + 1);
            }
            while (arr[param.getR()].getAverageScore() > pivot) {
                param.setR(param.getR() - 1);
            }
            if (param.getL() < param.getR()) {
                int tmp = arr[param.getL()].getAverageScore();
                arr[param.getL()] = arr[param.getR()];
                arr[param.getR()].setAverageScore(tmp);
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