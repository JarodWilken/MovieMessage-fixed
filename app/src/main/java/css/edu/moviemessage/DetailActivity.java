package css.edu.moviemessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;

public class DetailActivity extends AppCompatActivity {
    EditText editTextMovieName;
    Button buttonSaveMovie, buttonBack;
    movieFirebaseData movieDataSource;
    DatabaseReference myMovieDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviedetail);
        editTextMovieName = (EditText) findViewById(R.id.editTextMovieName);
        buttonSaveMovie = (Button) findViewById(R.id.buttonSaveMovie);
        buttonBack = (Button) findViewById(R.id.buttonReturn);


        movieDataSource = new movieFirebaseData();
        myMovieDb = movieDataSource.open();


        String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };
        Spinner s = (Spinner) findViewById(R.id.spinnerStar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);



        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });

        buttonSaveMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String movieTitle = editTextMovieName.getText().toString();
                int star = ((Spinner)findViewById(R.id.spinnerStar)).getSelectedItemPosition();
                movieDataSource.createMovie(movieTitle, star);
                //Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                //startActivity(mainActIntent);
            }
        });
    }
}
