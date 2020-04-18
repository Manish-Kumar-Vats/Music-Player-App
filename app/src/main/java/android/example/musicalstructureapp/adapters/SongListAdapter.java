package android.example.musicalstructureapp.adapters;

import android.content.Context;
import android.example.musicalstructureapp.R;
import android.example.musicalstructureapp.modals.SongItemModal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongListAdapter extends ArrayAdapter<SongItemModal> {

    TextView songName,singerName,songDuration;
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }
        SongItemModal currentSong=getItem(position);
        songName=view.findViewById(R.id.songName);
        singerName=view.findViewById(R.id.singerName);
        songDuration=view.findViewById(R.id.songDuration);

        songName.setText(currentSong.getSongName());
        singerName.setText(currentSong.getSingerName());
        songDuration.setText(currentSong.getDuration());

        return view;
    }

    public SongListAdapter(@NonNull Context context, ArrayList<SongItemModal> songsList) {
        super(context, 0, songsList);
    }
}
