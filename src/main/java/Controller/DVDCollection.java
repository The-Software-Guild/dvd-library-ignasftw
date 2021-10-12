package Controller;
import java.io.IOException;
import java.util.*;

import Model.DVDData;
import Model.Data;
import Model.DataStorage;

import Model.Storage;
import View.MessagePass;
import View.UserInput;

public class DVDCollection {
    private Storage dvdDataList;
    private int id = 0;
    private Rating ratings = new Rating();
    private MessagePass messagePass;
    private UserInput userInput;

    public void start() throws IOException {
        FileReader reader = new FileReader();
        reader.readFile();

        for(Data data : reader.getData()){
            dvdDataList.put(id++,data);
        }
        sendMessage("Data from file was loaded.");
        initialMenu();
        List<Data> writeInfo = new ArrayList<>();
        writeInfo.addAll(dvdDataList.getAllDVDs().values());
        reader.writeFile(writeInfo);
        sendMessage("This session was saved in file.");
    }

    public void initialMenu(){
        do{
            sendMessage(
                    "    ========== \n" +
                            "Initial Menu:\n" +
                            "      Please select the operation you wish to perform:");
            sendMessage(
                            "            1. Add DVD\n" +
                            "            2. Delete DVD\n" +
                            "            3. Edit DVD\n" +
                            "            4. List of all DVDs\n" +
                            "            5. Get DVD by ID\n" +
                            "            6. Get DVD by title"
            );
            sendInput(userInput.intUserInput(1,6));
            sendMessage("Press 1 to go to Main Menu.Or enter 0 to exit");
        }while(userInput.intUserInput(0,1) == 1);
        sendMessage("Thank you for using DVD Collection software.");
    }

    public void setData(DataStorage data){
        dvdDataList = data;
    }

    public void setMessagePass(MessagePass delegate){
        messagePass = delegate;
    }

    public void setUserInput(UserInput delegate){
        userInput = delegate;
    }

    public void sendMessage(String message){
        messagePass.sendMessage(message);
    }

    public void displayRow(Data row){
        Date date = row.getReleaseDate();
        String dateText = String.format("%s/%s/%s",date.getDate(),date.getMonth()+1,date.getYear());
        sendMessage(String.format(
                "|%s|%s|%s|%s|%s|%s|",
                row.getTitle(),
                dateText,
                row.getRating(),
                row.getDirectorName(),
                row.getStudio(),
                row.getUserNote()
        ));
    }

    public void sendInput(int choice){
        sendMessage("Choice is " + choice);
        switch (choice){
            case 1:
                inputDVD();
                break;
            case 2:
                removeDVD();
                break;
            case 3:
                editDVD();
                break;
            case 4:
                listAllDVDs();
                break;
            case 5:
                displayRow(getDVDFromID());
                break;
            case 6:
                displayRow(getDVDFromName());
                break;
            default:
                break;
        }
    }

    private void inputDVD(){
        sendMessage("Enter DVD title:");
        String title = userInput.stringUserInput();
        sendMessage("Enter releaseDate:");
        Date releaseDate = userInput.dateUserInput();
        sendMessage("Enter rating:");
        String rating = userInput.stringUserInput();
        sendMessage("Enter directors full name:");
        String directorName = userInput.stringUserInput();
        sendMessage("Enter studio name:");
        String studio = userInput.stringUserInput();
        sendMessage("Enter user note:");
        String userNote = userInput.stringUserInput();

        Data newItem = new DVDData();
        newItem.setInfo(title,releaseDate,rating, directorName, studio, userNote);
        dvdDataList.put(id++,newItem);
        sendMessage(title + " was added to collection.");
    }

    public void editDVD(){
        sendMessage("Enter DVD id you would like to modify:");
        int id = userInput.intUserInput(0,this.id-1);
        sendMessage("Modify DVD title:");
        String title = userInput.stringUserInput();
        sendMessage("Modify releaseDate:");
        Date releaseDate = userInput.dateUserInput();
        sendMessage("Modify rating:");
        String rating = userInput.stringUserInput();
        sendMessage("Modify directors full name:");
        String directorName = userInput.stringUserInput();
        sendMessage("Modify studio name:");
        String studio = userInput.stringUserInput();
        sendMessage("Modify user note:");
        String userNote = userInput.stringUserInput();
        if(dvdDataList.containsKey(id)) {
            dvdDataList.get(id).setInfo(title, releaseDate, rating, directorName, studio, userNote);
        }
        sendMessage(title + " was modified.");
    }

    public void removeDVD()
    {
        sendMessage("Enter DVD id you would like to REMOVE:");
        int id = userInput.intUserInput(0,this.id-1);
        String message = "";
        try
        {
            message += dvdDataList.get(id).getTitle() + " was successfully removed.";
            dvdDataList.remove(id);
        }
        catch (Exception e)
        {
            message += "Item was not removed. Error: " + e.getMessage();
        }
        finally {
            sendMessage(message);
        }
    }

    private void listAllDVDs(){
        HashMap<Integer,Data> dataHashMap = dvdDataList.getAllDVDs();
        sendMessage("List of all DVDs:");
        for(var key : dataHashMap.keySet()){
            sendMessage(String.format("ID[%s]",key));
            displayRow(dataHashMap.get(key));
        }
    }

    public Data getDVDFromID(){
        sendMessage("Enter DVD ID to display:");
        int id = userInput.intUserInput(0,this.id-1);
        return dvdDataList.get(id);
    }

    public Data getDVDFromName(){
        Data data = new DVDData();
        sendMessage("Enter title of DVD to display");
        String title = userInput.stringUserInput();

        do{
            for(int i=0;i<dvdDataList.getAllDVDs().size();i++)
            {
                Data item = dvdDataList.get(i);
                if(item.getTitle().toLowerCase(Locale.ROOT) == title.toLowerCase(Locale.ROOT)){
                    return item;
                }
            }
        }while(data.getTitle() == null);
        return data;
    }
}
