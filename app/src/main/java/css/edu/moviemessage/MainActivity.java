package css.edu.moviemessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAddMovie;
    ListView listViewMovie;                                  // listview to display all the movies in the database
    ArrayAdapter<Movie> movieAdapter;
    List<Movie> movieList;
    movieFirebaseData movieDataSource;
    DatabaseReference myMovieDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupFirebaseDataChange();
        setupAddButton();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    private void setupFirebaseDataChange() {
        movieDataSource = new movieFirebaseData();
        myMovieDb = movieDataSource.open();
        myMovieDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                movieList = movieDataSource.getAllMovie(dataSnapshot);
                // Instantiate a custom adapter for displaying each movie
                movieAdapter = new MovieAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, movieList);
                // Apply the adapter to the list
                listViewMovie.setAdapter(movieAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setupAddButton() {
        buttonAddMovie = (Button) findViewById(R.id.buttonAddMovie);

        buttonAddMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent detailActIntent = new Intent(view.getContext(), DetailActivity.class);

                startActivity(detailActIntent);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
