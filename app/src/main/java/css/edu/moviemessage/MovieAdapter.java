package css.edu.moviemessage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private List<Movie> movieList;
    private Context context;
    private int layoutResource;

    public MovieAdapter(Context context, int resource, List<Movie> movieList) {
        super(context, resource, movieList);
        this.context = context;
        this.layoutResource = resource;
        this.movieList = movieList;
    }
}
