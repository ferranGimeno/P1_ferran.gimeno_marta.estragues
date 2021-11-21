package SortingAlgorithms;

import Model.LSManga.Series;

import java.util.LinkedList;

public class BucketSort {
    private static LinkedList[] buckets = new LinkedList[11];
    public static LinkedList<Series> sort(LinkedList<Series> series) {
        for (int j = 0; j < buckets.length; j++) {
            buckets[j] = new LinkedList<Series>();
        }
        for (Series serie: series) {
            if (serie.getAverageScore() != 100) {
                if (serie.getAverageScore() < 10) {
                    buckets[0].add(serie);
                } else {
                    String average = String.valueOf(serie.getAverageScore());
                    buckets[(average.charAt(0) - '0')].add(serie);
                }
            } else {
                buckets[10].add(serie);
            }
        }
        for (LinkedList<Series> bucket: buckets) {
            if (!bucket.isEmpty()) {
                BucketQuickSort.sort(bucket, 0, bucket.size() - 1);
            }
        }

        LinkedList<Series> toReturn = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            toReturn.addAll(buckets[i]);
        }
        return toReturn;
    }
}

