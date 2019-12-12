package proapp;

import java.io.*;
import java.util.ArrayList;

public class filereader {
    public static ArrayList<String> items3 = new ArrayList<>();
    public static ArrayList<String> items4 = new ArrayList<>();

    public static ArrayList<String> Reader_teacher() {
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try {

            fi = new FileInputStream("teacher.txt");
            is = new InputStreamReader(fi, "UTF-8");
            br = new BufferedReader(is);
            String line;
            while ((line = br.readLine()) != null) {
                items3.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (IOException e) {

            System.out.println(e);
        }
        return items3;
    }

    public static ArrayList<String> Reader_place() {

        FileInputStream fi2 = null;
        InputStreamReader is2 = null;
        BufferedReader br2 = null;
        try {
            fi2 = new FileInputStream("place.txt");
            is2 = new InputStreamReader(fi2, "windows-31j");
            br2 = new BufferedReader(is2);
            String line2;
            while ((line2 = br2.readLine()) != null) {
                items4.add(line2);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (IOException e) {

            System.out.println(e);
        }
        return items4;
    }
}

