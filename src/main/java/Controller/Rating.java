package Controller;

public class Rating {
    enum ratingName {
            G,
            PG,
            PG13,
            R,
            NC17,
            Unrated
    };

    String[] ratingMeta = {
            "General Audiences",
            "Parental Guidance Suggested",
            "Parents Strongly Cautioned",
            "Restricted",
            "Adults Only",
            ""
    };
}
