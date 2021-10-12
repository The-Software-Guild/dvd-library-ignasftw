package Controller;
import Model.DVDData;
import Model.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<Data> dvdLoaded = new ArrayList<>();

    public void writeFile(List<Data> data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        for(Data row : data){
            Date date = row.getReleaseDate();
            String dateText = String.format("%s/%s/%s",date.getDate(),date.getMonth()+1,date.getYear());
            out.println(String.format(
                    "%s::%s::%s::%s::%s::%s",
                    row.getTitle(),
                    dateText,
                    row.getRating(),
                    row.getDirectorName(),
                    row.getStudio(),
                    row.getUserNote()
            ));
        }
        out.flush();
        out.close();
    }

    public void readFile(){
        try {
            File myObj = new File("OutFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tokens=data.split("::");

                DVDData item = new DVDData();
                String[] dateText = tokens[1].split("/");
                Date date = new Date(Integer.parseInt(dateText[2]),
                                     Integer.parseInt(dateText[1])-1,
                                     Integer.parseInt(dateText[0]));
                item.setInfo(tokens[0],date,tokens[2],tokens[3],tokens[4],tokens[5]);
                dvdLoaded.add(item);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred. Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Data> getData(){
        return dvdLoaded;
    }
}
