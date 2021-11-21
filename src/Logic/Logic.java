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
import java.util.LinkedList;
import java.util.Scanner;

public class Logic {
    private static final int N_ITERATIONS = 5;
    private static final String[] PATH_DEBUG = {"Datasets\\Datasets JSON\\series_S.json", "Datasets\\Datasets JSON\\series_M.json", "Datasets\\Datasets JSON\\series_L.json"};
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
            lsManga.getSeries()[i].setPriorityComb(((0.7) * lsManga.getSeries()[i].getAverageScore() / lsManga.getSeries()[i].getPopularity() + (0.3) * lsManga.getSeries()[i].getFavourites() / lsManga.getSeries()[i].getPopularity()) / 2 * 100);
            seriesLinkedList.add(lsManga.getSeries()[i]);
        }
    }

    public static void menu(){
        int option;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("--= Sorting Algorithms =--\n");
            System.out.println("1) Sort series by average score (Bucket Sort)");
            System.out.println("2) Sort by date (Merge Sort)");
            System.out.println("3) Sort by priority (Quicksort)");
            System.out.println("4) Exit");
            System.out.println("\nSelect an option: ");
            option = scan.nextInt();
            System.out.println();

            switch(option){
                case 1:
                    //calculateTimeDebug(1);
                    LinkedList<Series> averageScoreList = BucketSort.sort(seriesLinkedList);
                    System.out.println("Rank - Title - Average Score\n");
                    for (int i = 0; i < averageScoreList.size(); i++) {
                        System.out.println(i + 1 + " - " + averageScoreList.get(i).getTitle().getRomaji() + " - " + averageScoreList.get(i).getAverageScore());
                    }
                    System.out.println("\n");
                    break;

                case 2:
                    //calculateTimeDebug(2);
                    series = MergeSort.sort(lsManga.getSeries(), 0, lsManga.getSeries().length - 1);
                    System.out.println("Rank - Title - Date\n");
                    for (int i = 0; i < series.length; i++) {
                        System.out.println(i + 1 + " - " + series[i].getTitle().getRomaji() + " - " + series[i].getStartDate().getDay() + "/" + series[i].getStartDate().getMonth() + "/" + series[i].getStartDate().getYear());
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    //calculateTimeDebug(3);
                    series = Quicksort.sort(lsManga.getSeries(), 0, lsManga.getSeries().length - 1);
                    System.out.println("Rank - Title - Priority\n");
                    for (int i = 0; i < series.length; i++) {
                        System.out.println(i + 1 + " - " + series[i].getTitle().getRomaji() + " - " + series[i].getPriorityComb() + "\n Popularity: "+ series[i].getPopularity() + "\n Average score: " + series[i].getAverageScore() + "\n Fav: " + series[i].getFavourites());
                    }
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("See you soon!");
                    break;

                default:
                    System.out.println("\nError. Enter a number between 1 and 4.\n");
                    break;
            }
        }while(option != 4);
    }

    public static void calculateTimeDebug(int option) {
        LSManga[] lsMangaa = new LSManga[PATH_DEBUG.length];
        for (int i = 0; i < PATH_DEBUG.length; i++) {
            Gson gson = new Gson();
            JsonReader reader;

            try {
                reader = new JsonReader(new FileReader(PATH_DEBUG[i]));
                lsMangaa[i] = gson.fromJson(reader, LSManga.class);
                sanitizeJson(lsMangaa[i]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < lsMangaa.length; i++) {
            // We take 5 measures and average them out to smooth the results
            long accumulated = 0;
            for (int j = 0; j < N_ITERATIONS; j++) {
                long start;
                switch (option){
                    case 1:
                        start = System.currentTimeMillis();
                        MergeSort.sort(lsMangaa[i].getSeries(), 0, lsMangaa[i].getSeries().length - 1);
                        accumulated += System.currentTimeMillis() - start;
                        break;

                    case 2:
                        start = System.currentTimeMillis();
                        //MergeSort.sort(lsMangaa[i].getSeries(), 0, lsMangaa[i].getSeries().length - 1);
                        accumulated += System.currentTimeMillis() - start;
                        break;

                    case 3:
                        //start = System.currentTimeMillis();
                        //MergeSort.sort(lsMangaa[i].getSeries(), 0, lsMangaa[i].getSeries().length - 1);
                        //accumulated += System.currentTimeMillis() - start;
                        break;
                }
                // Figure out how much time has passed (and accumulate it)
            }
            System.out.println(accumulated / N_ITERATIONS);
        }
    }
}

