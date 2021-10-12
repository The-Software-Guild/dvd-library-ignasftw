import Controller.DVDCollection;
import Model.DataStorage;
import View.MessagePass;
import View.UserInput;
import View.UserInterface;

import java.io.IOException;

public class DVDManager{
    //View
    private UserInterface userInterface= new UserInterface();
    public void start() throws IOException {
        //Model
        DataStorage storage = new DataStorage();
        //Controller
        DVDCollection collection = new DVDCollection();
        collection.setData(storage);
        collection.setMessagePass(this::sendMessage);
        collection.setUserInput(userInterface);
        collection.start();
    }

    public void sendMessage(String message){
        userInterface.printMessage(message);
    }

}
