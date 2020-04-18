package android.example.musicalstructureapp;

import android.content.Intent;
import android.example.musicalstructureapp.adapters.SongListAdapter;
import android.example.musicalstructureapp.modals.SongItemModal;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class PlaylistActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<SongItemModal> songItemModalList;
    SongListAdapter songListAdapter;
    private MediaPlayer mMediaPlayer;

    private int song[]={R.raw.ncs_one,R.raw.ncs_two,R.raw.ncs_three,R.raw.ncs_four,R.raw.ncs_five,R.raw.ncs_six,R.raw.ncs_seven,R.raw.ncs_eight,R.raw.ncs_nine,R.raw.ncs_ten};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        listView = findViewById(R.id.songsListView);

        songItemModalList = new ArrayList<SongItemModal>();
        String songArray[] = {"Fire and Water-NCS ", "Love him-NCS", "India,the Best-NCS", "Namaste-NCS", "Loppen-NCS", "Sheru"};
        String singerArray[] = {"Manish Vats", "NItesh Kumar", "Bharat", "Aditya Verma", "Dssaini", "Sheru"};
        String durationArray[] = {"02:53", "03:45", "04:03", "06:02", "04:42", "03:58"};

        for (int i = 0; i < 15; i++) {
            int randomSingerIndex = new Random().nextInt(singerArray.length);
            int randomSongIndex = new Random().nextInt(songArray.length);
            int randomDurationIndex = new Random().nextInt(durationArray.length);
            songItemModalList.add(new SongItemModal(songArray[randomSongIndex], singerArray[randomSingerIndex], durationArray[randomDurationIndex]));
        }
        songListAdapter = new SongListAdapter(this, songItemModalList);
        listView.setAdapter(songListAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(position>10){
                    position=position%10;
                }
                if (mMediaPlayer != null){
                    mMediaPlayer.stop();
                    mMediaPlayer.reset();
                    mMediaPlayer.release();

                }
                mMediaPlayer =MediaPlayer.create(PlaylistActivity.this, song[position]);

                mMediaPlayer.start();
            }
        });
    }


    public void radioButton(View view) {
        if (mMediaPlayer != null){
            mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer.release();

        }
        startActivity(new Intent(PlaylistActivity.this, RadioActivity.class));
        finish();
    }

    public void homeButton(View view) {
        if (mMediaPlayer != null){
            mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer.release();

        }
        startActivity(new Intent(PlaylistActivity.this, HomeActivity.class));
        finish();
    }
}
