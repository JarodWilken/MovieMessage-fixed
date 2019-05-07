package css.edu.moviemessage;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        Log.d("CIS3334", "Create movie with key: "+key);
        Movie newMovie = new Movie(key, movieTitle, rating);
        myMovieDb.child(key).setValue(newMovie);
        Log.d("CIS3334", "Create movie added movie to firebase");

        return newMovie;
    }

    public List<Movie> getAllMovie(DataSnapshot dataSnapshot){
        List<Movie> fishList = new ArrayList<Movie>();
        Log.d("CIS3334", "get all movie");
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Log.d("CIS3334", "get a movie");
            Movie movie = data.getValue(Movie.class);
            fishList.add(movie);
        }
        return fishList;
    }
}
