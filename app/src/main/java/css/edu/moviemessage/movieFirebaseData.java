package css.edu.moviemessage;

import java.util.ArrayList;
import java.util.List;

public class movieFirebaseData {
    DatabaseReference myMovieDb;
    public static final String MovieDataTag = "Movie Data";


    public DatabaseReference open()  {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myMovieDb = database.getReference(MovieDataTag);
        return myMovieDb;
    }

    public void close() {

    }

    public Movie createMovie(String movieTitle, int rating){
        String key = myMovieDb.child(MovieDataTag).push().getKey();
        Movie newMovie = new Movie(key, movieTitle, rating);
        myMovieDb.child(key).setValue(newMovie);
        return newMovie;
    }

    public List<Movie> getAllMovie(DataSnapshot dataSnapshot){
        List<Movie> fishList = new ArrayList<Movie>();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Movie movie = data.getValue(Movie.class);
            fishList.add(movie);
        }
        return fishList;
    }
}
