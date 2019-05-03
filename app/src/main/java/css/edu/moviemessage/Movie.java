package css.edu.moviemessage;

import java.io.Serializable;

public class Movie implements Serializable {
    private String movieTitle;
    private int rating;

    public Movie(){
    }

    public Movie(String movieTitle, int rating){
        this.movieTitle = movieTitle;
        this.rating = rating;
    }

    public String getMovieTitle(){
        return this.movieTitle;
    }

    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public int getRating(){
        return this.rating;
    }
    public void setRating(){
        this.rating = rating;
    }

    public String toString() {
        return "Movie Title: " + movieTitle + '\'' +
                "Rating: " + rating + '\'';
    }
}