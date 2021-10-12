package View;

import java.util.Date;

public interface UserInput {
    String stringUserInput();
    int intUserInput(int min, int max);
    Date dateUserInput();
}
