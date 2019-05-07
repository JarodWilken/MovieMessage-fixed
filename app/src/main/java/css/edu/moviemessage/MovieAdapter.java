package css.edu.moviemessage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("CIS3334", "getView");
        //get the fish we are displaying
        Movie mov = movieList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //view = inflater.inflate(R.layout.fish_row_layout, null);
        view = inflater.inflate(R.layout.movie_row_layout, null);

        TextView tvTitle=(TextView)view.findViewById(R.id.textViewMovieTitle);
        tvTitle.setText(mov.getMovieTitle());

        return(view);
    }
}
