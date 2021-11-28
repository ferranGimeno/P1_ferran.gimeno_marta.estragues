package Logic;

import Model.LSManga.LSManga;
import Model.LSManga.Series;
import SortingAlgorithms.BucketSort;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.Quicksort;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class Logic {
    private static final String PATH = "Datasets\\Datasets JSON\\series_S.json";
    private static LSManga lsManga;
    private static Series[] series;
    private static final LinkedList<Series> seriesLinkedList = new LinkedList<>();

    public static void readDataset() {
        Gson gson = new Gson();
        JsonReader reader;

        try {
            reader = new JsonReader(new FileReader(PATH));
            lsManga = gson.fromJson(reader, LSManga.class);
            sanitizeJson(lsManga);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sanitizeJson(LSManga lsManga){
        for (int i = 0; i < lsManga.getSeries().length; i++) {
            if (lsManga.getSeries()[i].getAverageScore() == null) {
                lsManga.getSeries()[i].setAverageScore(0);
            }
            if (lsManga.getSeries()[i].getStartDate().getDay() == null) {
                lsManga.getSeries()[i].getStartDate().setDay(1);
            }
            if (lsManga.getSeries()[i].getStartDate().getMonth() == null) {
                lsManga.getSeries()[i].getStartDate().setMonth(1);
            }
            if (lsManga.getSeries()[i].getStartDate().getYear() == null) {
                lsManga.getSeries()[i].getStartDate().setYear(1);
            }
            lsManga.getSeries()[i].setPriorityComb(((0.01)*lsManga.getSeries()[i].getAverageScore() + (float)lsManga.getSeries()[i].getFavourites() / lsManga.getSeries()[i].getPopularity())*100 + (float)lsManga.getSeries()[i].getPopularity()/10000);
            seriesLinkedList.add(lsManga.getSeries()[i]);
        }
    }

    public static void menu(){
        int option;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("--= Sorting Algorithms =--\n");
            System.out.println("1) Sort series by average score (Bucket Sort)");
            System.out.println("2) Sort by date (Merge Sort)");
            System.out.println("3) Sort by priority (Quick Sort)");
            System.out.println("4) Exit");
            System.out.println("\nSelect an option: ");
            option = scan.nextInt();
            System.out.println();

            long accumulated = 0;
            long start;

            switch (option) {
                case 1 -> {
                    start = System.currentTimeMillis();
                    LinkedList<Series> averageScoreList = BucketSort.sort(seriesLinkedList);
                    System.out.println("Rank - Title - Average Score\n");
                    for (int i = 0; i < averageScoreList.size(); i++) {
                        System.out.println(i + 1 + " - " + averageScoreList.get(i).getTitle().getRomaji() + " - " + averageScoreList.get(i).getAverageScore());
                    }
                    System.out.println("\n");
                    accumulated += System.currentTimeMillis() - start;
                    System.out.println("Time: " + accumulated);
                }
                case 2 -> {
                    start = System.currentTimeMillis();
                    series = MergeSort.sort(lsManga.getSeries(), 0, lsManga.getSeries().length - 1);
                    System.out.println("Rank - Title - Date\n");
                    for (int i = 0; i < series.length; i++) {
                        System.out.println(i + 1 + " - " + series[i].getTitle().getRomaji() + " - " + series[i].getStartDate().getDay() + "/" + series[i].getStartDate().getMonth() + "/" + series[i].getStartDate().getYear());
                    }
                    System.out.println("\n");
                    accumulated += System.currentTimeMillis() - start;
                    System.out.println("Time: " + accumulated);
                }
                case 3 -> {
                    DecimalFormat df = new DecimalFormat("#.##");
                    start = System.currentTimeMillis();
                    series = Quicksort.sort(lsManga.getSeries(), 0, lsManga.getSeries().length - 1);
                    System.out.println("Rank - Title - Priority\n");
                    for (int i = 0; i < series.length; i++) {
                        System.out.println(i + 1 + " - " + series[i].getTitle().getRomaji() + " - " + df.format(series[i].getPriorityComb()) + "\n Popularity: " + series[i].getPopularity() + "\n Average score: " + series[i].getAverageScore() + "\n Fav: " + series[i].getFavourites());
                    }
                    System.out.println("\n");
                    accumulated += System.currentTimeMillis() - start;
                    System.out.println("Time: " + accumulated);
                }
                case 4 -> System.out.println("See you soon!");
                default -> System.out.println("\nError. Enter a number between 1 and 4.\n");
            }
        } while (option != 4);
    }
}

