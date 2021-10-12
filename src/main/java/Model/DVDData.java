package Model;

import java.util.Date;

public class DVDData implements Data {
    //Model.Data Transfer Object
    private String title;
    private Date releaseDate;
    private String rating;
    private String directorName;
    private String studio;
    private String userNote;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public String getTitle() {
        return title;
    }

    public String getRating(){
        return rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setInfo(String title,Date releaseDate,String rating,String directorName,String studio,String userNote)
    {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
        this.setRating(rating);
        this.setDirectorName(directorName);
        this.setStudio(studio);
        this.setUserNote(userNote);
    }
}
