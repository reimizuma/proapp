package proapp;

import java.io.*;
import java.util.ArrayList;

public class filewrite {
    private static final String NEW_LINE="\r\n";
    public static void write_teacher(ArrayList<String> item) {
        try {
            File file = new File("teacher.txt");
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter("teacher.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            for(int i=0;i<item.size();i++){
                if(item.get(i).isEmpty()){
                    break;
                }
                pw.print(item.get(i));
                pw.print(NEW_LINE);
            }
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
