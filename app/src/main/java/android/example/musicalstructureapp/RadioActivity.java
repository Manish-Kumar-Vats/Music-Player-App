package android.example.musicalstructureapp;

import android.content.Intent;
import android.example.musicalstructureapp.adapters.GenreAdapter;
import android.example.musicalstructureapp.adapters.RadioListAdapter;
import android.example.musicalstructureapp.modals.GenreModal;
import android.example.musicalstructureapp.modals.RadioChannelModal;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RadioActivity extends AppCompatActivity {

    ArrayList<RadioChannelModal> customList = new ArrayList<RadioChannelModal>();
    RecyclerView recyclerView;
    RadioListAdapter radioListAdapter;

    ArrayList<GenreModal> genreList = new ArrayList<GenreModal>();


    GridView grid;

    int[] genreImage = {
            R.drawable.electronic,
            R.drawable.folk,
            R.drawable.jazz,
            R.drawable.metal,
            R.drawable.old,
            R.drawable.old,
            R.drawable.party,
            R.drawable.pop,
            R.drawable.rap
    };
    String[] genreName = {
            "electronic",
            "folk",
            "jazz",
            "metal",
            "old80",
            "old90",
            "party",
            "pop",
            "rap"
    };
    int[] genreColor= {
            R.color.bright_pink,
            R.color.red,
            R.color.orange,
            R.color.yellow,
            R.color.chartreuse,
            R.color.green,
            R.color.spring_green,
            R.color.cyan,
            R.color.azure,
            R.color.blue,
            R.color.violet,
            R.color.magenta,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        recyclerView = findViewById(R.id.channelListView);
        radioListAdapter = new RadioListAdapter(customList);

        String channel[] = {"66.1", "78.9", "81.8", "89", "90.3", "91.1", "91.7", "95.5", "96", "98.8", "99.9", "105"};
        for (int i = 0; i < channel.length; i++) {

            customList.add(new RadioChannelModal(channel[i], "FM Name " + i));
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        ;

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(radioListAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));



        for (int i=0;i<9;i++){

            genreList.add(new GenreModal(genreName[i],genreImage[i],genreColor[i]));
        }

        GenreAdapter genreAdapter = new GenreAdapter(RadioActivity.this, genreList);
        grid = (GridView) findViewById(R.id.genreGridView);
        grid.setAdapter(genreAdapter);

                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(RadioActivity.this, "You Clicked at ", Toast.LENGTH_SHORT).show();

            }
        });

    }



    public void playlistButton(View view) {
        startActivity(new Intent(RadioActivity.this, PlaylistActivity.class));
        finish();
    }

    public void homeButton(View view) {
        startActivity(new Intent(RadioActivity.this, HomeActivity.class));
        finish();
    }
}
