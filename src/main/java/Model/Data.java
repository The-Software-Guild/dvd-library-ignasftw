package Model;

import java.util.Date;

public interface Data {
    void setInfo(String title, Date releaseDate, String rating, String directorName, String studio, String userNote);
    void setTitle(String title);
    void setReleaseDate(Date releaseDate);
    void setRating(String rating);
    void setDirectorName(String directorName);
    void setStudio(String studio);
    void setUserNote(String userNote);

    String getUserNote();
    String getStudio();
    String getDirectorName();
    String getRating();
    Date getReleaseDate();
    String getTitle();
}
