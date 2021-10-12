package View;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class UserInterface implements UserInput{
    private Scanner scanner = new Scanner(System.in);

    public void printMessage(String message){
        System.out.println(message);
    }

    public String stringUserInput(){
        String text = scanner.nextLine();
        return text;
    }

    public int intUserInput(int min, int max)
    {
        int number=-1;
        do
        {
            number = scanner.nextInt();
            scanner.nextLine();
            if(min > number || number > max){
                printMessage("Number was out of range. Try again: ");
            }
        }while(min > number || number > max);
        return number;
    }

    public Date dateUserInput()
    {
        int year=-1;
        int month=-1;
        int day=-1;

        try{
            do{
                printMessage("Enter DVD year: ");
                year = scanner.nextInt();
                scanner.nextLine();
            }while(1 > year || year > Calendar.getInstance().get(Calendar.YEAR));

            do{
                printMessage("Enter DVD month: ");
                month = scanner.nextInt();
                scanner.nextLine();
            }while(1 > month || month > 12);

            do{
                printMessage("Enter DVD day: ");
                day = scanner.nextInt();
                scanner.nextLine();
            }while(1> day || day >31);
        }
        catch (Exception e){
            printMessage("Error: " + e.getMessage());
        }finally
        {
            return new Date(year,month-1,day);
        }
    }
}
