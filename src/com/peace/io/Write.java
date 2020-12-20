package com.peace.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import com.peace.sort.QuickSort;

public class Write {

    int getRandomInteger(int lo, int hi) {
        return (int) (Math.random() * (hi - lo)) + lo;
    }

    void writeRandomNumbers(String filename, int fromIndex, int toIndex) {
        long timeBefore = System.currentTimeMillis();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("./src/com/peace/io/" + filename)); // overwrite

            for (int i = fromIndex; i <= toIndex; i++) {
                writer.write(Integer.toString(getRandomInteger(fromIndex, toIndex)));
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        } finally {
            System.out.println("Writer finalizado");
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms
    }

    void writeFromTo(String filename, int fromIndex, int toIndex) {
        long timeBefore = System.currentTimeMillis();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("./src/com/peace/io/" + filename)); // overwrite

            for (int i = fromIndex; i <= toIndex; i++) {
                writer.write(Integer.toString(i));
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        } finally {
            System.out.println("Writer finalizado");
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms
    }

    void writeOneHundred() {
        long timeBefore = System.currentTimeMillis();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("./src/com/peace/io/million.txt")); // overwrite

            for (int i = 1; i <= 100; i++) {
                writer.write(Integer.toString(i));
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        } finally {
            System.out.println("Writer finalizado");
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms
    }

    void writeOneThousand() {
        long timeBefore = System.currentTimeMillis();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("./src/com/peace/io/million.txt")); // overwrite

            for (int i = 1; i <= 1000; i++) {
                writer.write(Integer.toString(i));
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        } finally {
            System.out.println("Writer finalizado");
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms
    }

    void writeOneMillion() {
        long timeBefore = System.currentTimeMillis();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("./src/com/peace/io/million.txt")); // overwrite

            for (int i = 1; i <= 1000000; i++) {
                writer.write(Integer.toString(i));
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        } finally {
            System.out.println("Writer finalizado");
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms
    }

    void printFileSize(String filename) {
        File file = new File("./src/com/peace/io/" + filename);
        if (file.exists()) {
            double bytes = file.length();
            double kilobytes = (bytes / 1024);
            double megabytes = (kilobytes / 1024);
            double gigabytes = (megabytes / 1024);
            double terabytes = (gigabytes / 1024);
            double petabytes = (terabytes / 1024);
            double exabytes = (petabytes / 1024);
            double zettabytes = (exabytes / 1024);
            double yottabytes = (zettabytes / 1024);

            System.out.println("bytes : " + bytes);
            System.out.println("kilobytes : " + kilobytes);
            System.out.println("megabytes : " + megabytes);
            System.out.println("gigabytes : " + gigabytes);
            System.out.println("terabytes : " + terabytes);
            System.out.println("petabytes : " + petabytes);
            System.out.println("exabytes : " + exabytes);
            System.out.println("zettabytes : " + zettabytes);
            System.out.println("yottabytes : " + yottabytes);
        }
    }

    void printLines(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./src/com/peace/io/" + filename));

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Leitura terminada");
        }
    }

    LinkedList<String> getLinesAsList(String filename) {

        long timeBefore = System.currentTimeMillis();

        LinkedList<String> lines = new LinkedList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./src/com/peace/io/" + filename));

            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Leitura terminada");
        }

        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms

        return lines;
    }

    int[] getLinesAsIntegerArray(String filename) {
        long timeBefore = System.currentTimeMillis();

        BufferedReader reader = null;

        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader("./src/com/peace/io/" + filename));
            while (reader.readLine() != null)
                lines++;
            reader.close();
            System.out.println("Numero de linhas: " + lines);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] arr = new int[lines];

        try {
            reader = new BufferedReader(new FileReader("./src/com/peace/io/" + filename));

            int lineNumber = 0;
            String line = reader.readLine();
            while (line != null) {
                arr[lineNumber] = Integer.parseInt(line);
                lineNumber++;
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Leitura terminada");
        }

        long timeAfter = System.currentTimeMillis();
        System.out.println("Time used: " + (timeAfter - timeBefore) + "ms"); // 149ms

        return arr;
    }

    public static void main(String[] args) {
        // new Write().writeOneHundred(); // 1ms
        // new Write().writeOneThousand(); // 174ms (10x bigger)
        // new Write().writeOneMillion(); // 123ms (1000x bigger)

        // new Write().writeFromTo("hundred.txt", 1, 100); // 1ms
        // new Write().writeFromTo("thousand.txt", 1, 1000); // 1ms
        // new Write().writeFromTo("million.txt", 1, 1000000); // 134ms
        // new Write().writeFromTo("tenMillions.txt", 1, 10000000); // 1005ms

        // new Write().writeFromTo("billion.txt", 1, 1000000000); // >>> 10s

        // new Write().printFileSize("tenMillions.txt"); // 75MB
        // new Write().printFileSize("hundred.txt"); // 2MB

        // new Write().writeRandomNumbers("thousandOfRandom.txt", 1, 1000); // 5ms
        // new Write().writeRandomNumbers("millionOfRandom.txt", 1, 1000000); // 178ms
        // new Write().writeRandomNumbers("hundredMillionOfRandom.txt", 1, 100000000);
        // // 11,780ms

        // new Write().printLines("hundred.txt");

        /**
         * List<String> lines = new Write().getLinesAsList("hundred.txt"); // 1ms int
         * sum = 0; for (String line : lines) { sum += Integer.parseInt(line); }
         * System.out.println("Soma de 1 ate 100: " + sum); // 5050
         */

        /*
         * int[] arr = new Write().getLinesAsIntegerArray("thousandOfRandom.txt"); int
         * sum = 0; for (int line : arr) { sum += line; System.out.print(line + " "); }
         * System.out.println("Soma de 1 ate 100: " + sum); // 5050
         */

        // timer
        long timeBefore = 0;
        long timeAfter = 0;

        // sort using
        /*
         * int[] arr = new Write().getLinesAsIntegerArray("millionOfRandom.txt"); new
         * QuickSort().quicksort(arr, 0, arr.length - 1); timeBefore =
         * System.currentTimeMillis(); for (int i : arr) { System.out.print(i + " "); }
         * timeAfter = System.currentTimeMillis(); System.out.println("Sort time used: "
         * + (timeAfter - timeBefore) + "ms"); // 2ms sem sysout, 10,444ms com sysout
         */

        // sort one hundred million numbers
        int[] arrHundredMillion = new Write().getLinesAsIntegerArray("hundredMillionOfRandom.txt"); // 10,018ms, 9872ms
        int[] arrOneMillion = new Write().getLinesAsIntegerArray("millionOfRandom.txt"); // 205ms

        timeBefore = System.currentTimeMillis();
        new QuickSort().quicksort(arrHundredMillion, 0, arrHundredMillion.length - 1);
        timeAfter = System.currentTimeMillis();
        System.out.println("Sort arrHundredMillion time used: " + (timeAfter - timeBefore) + "ms"); // 9,726ms, 11474ms

        timeBefore = System.currentTimeMillis();
        new QuickSort().quicksort(arrOneMillion, 0, arrOneMillion.length - 1);
        timeAfter = System.currentTimeMillis();
        System.out.println("Sort arrOneMillion time used: " + (timeAfter - timeBefore) + "ms"); // 81ms

        // 1 million: 80ms log (1 million) = 6
        // 100 million: 11,470ms (143x bigger) log(100 million) = 8 (1.33x bigger)
        // 1.33 x 100 = 133x
        // 100 million 32 bits = 4x100MB

    }

}