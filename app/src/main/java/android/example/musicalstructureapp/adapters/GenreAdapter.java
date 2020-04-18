package android.example.musicalstructureapp.adapters;

import android.content.Context;
import android.example.musicalstructureapp.R;
import android.example.musicalstructureapp.RadioActivity;
import android.example.musicalstructureapp.modals.GenreModal;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

    public class GenreAdapter extends BaseAdapter {
        Context c;
        ArrayList<GenreModal> genreList;

        public GenreAdapter(Context c, ArrayList<GenreModal> genreList) {
            this.c = c;
            this.genreList = genreList;
        }

        @Override
        public int getCount() {
            return genreList.size();
        }

        @Override
        public Object getItem(int i) {
            return genreList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(c).inflate(R.layout.music_genre, viewGroup, false);
            }

            final GenreModal currentGenre = (GenreModal) this.getItem(i);

            TextView genreNameTV = (TextView) view.findViewById(R.id.grid_text);
            ImageView bg_imageIV = (ImageView) view.findViewById(R.id.grid_image);
            ImageView genreImageIV = (ImageView) view.findViewById(R.id.genreImage);

            genreNameTV.setText(currentGenre.getGenreName());
            bg_imageIV.setBackgroundColor(currentGenre.getColor());
            genreImageIV.setImageResource(currentGenre.getGenreImage());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, currentGenre.getGenreName(), Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }