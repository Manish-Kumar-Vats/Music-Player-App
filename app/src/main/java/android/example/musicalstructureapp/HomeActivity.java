package android.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    int currentSong=0;
    private int song[]={R.raw.ncs_one,R.raw.ncs_two,R.raw.ncs_three,R.raw.ncs_four,R.raw.ncs_five,R.raw.ncs_six,R.raw.ncs_seven,R.raw.ncs_eight,R.raw.ncs_nine,R.raw.ncs_ten};

    ImageView nextButton,previousButton,playButton;
Boolean isPlaying=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();

        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), song[currentSong]);



        nextButton=findViewById(R.id.nextSong);
        playButton=findViewById(R.id.playSong);
        previousButton=findViewById(R.id.previousSong);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){ isPlaying=true;
                    playButton.setImageResource(R.drawable.ic_pause);
                    Toast.makeText(HomeActivity.this,"started playing",Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();

                }else { isPlaying=false;
                    playButton.setImageResource(R.drawable.ic_play);
                    Toast.makeText(HomeActivity.this,"paused",Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){ isPlaying=true;
                    playButton.setImageResource(R.drawable.ic_pause);
                }
                if (currentSong==(song.length-1)){
                    currentSong=0;
                }else {
                    currentSong=currentSong+1;
                }

                if (mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();

                }
                mediaPlayer =MediaPlayer.create(HomeActivity.this, song[currentSong]);
                mediaPlayer.start();
                Toast.makeText(HomeActivity.this,"next song"+currentSong,Toast.LENGTH_SHORT).show();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){ isPlaying=true;
                    playButton.setImageResource(R.drawable.ic_pause);
                }
                if (currentSong==0){
                    currentSong=(song.length-1);
                }else {
                    currentSong=currentSong-1;
                }
                if (mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();

                }
                mediaPlayer =MediaPlayer.create(HomeActivity.this, song[currentSong]);
                mediaPlayer.start();

                Toast.makeText(HomeActivity.this,"previous song"+currentSong,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void playlistButton(View view) {
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();

        }
        startActivity(new Intent(HomeActivity.this, PlaylistActivity.class));
        finish();
    }

    public void radioButton(View view) {
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();

        }
        startActivity(new Intent(HomeActivity.this, RadioActivity.class));
        finish();
    }

}
