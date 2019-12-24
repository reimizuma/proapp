package proapp;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class filewrite {
    private static final String NEW_LINE="\r\n";
    public static void write_teacher(ArrayList<String> item) {
        try {
            File file = new File("teacher.txt");
            file.delete();
            file.createNewFile();
            PrintWriter p = new PrintWriter(new BufferedWriter((new OutputStreamWriter(new FileOutputStream("teacher.txt",true), StandardCharsets.UTF_8))));
            for(int i=0;i<item.size();i++){
                if(item.get(i).isEmpty()){
                    break;
                }
                p.print(item.get(i));
                p.print(NEW_LINE);
            }
            p.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void write_place(ArrayList<String> item) {
        try {
            File file = new File("place.txt");
            file.delete();
            file.createNewFile();
            PrintWriter p = new PrintWriter(new BufferedWriter((new OutputStreamWriter(new FileOutputStream("place.txt",true), StandardCharsets.UTF_8))));
            for(int i=0;i<item.size();i++){
                if(item.get(i).isEmpty()){
                    break;
                }
                p.print(item.get(i));
                p.print(NEW_LINE);
            }
            p.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
