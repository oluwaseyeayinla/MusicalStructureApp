package com.alc.musicplayer.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListenNowActivity extends AppCompatActivity {

    static final long ONE_MILLISECOND = 1000;
    long quitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);

        ArrayList<AudioFile> recentFiles = new ArrayList<AudioFile>();
        recentFiles.add(new AudioFile("Deep End", "Daugtry", "Cage To Rattle", R.drawable.daughtry_cage_to_rattle));
        recentFiles.add(new AudioFile("As You Are", "Daughtry", "Cage To Rattle", R.drawable.daughtry_cage_to_rattle));
        recentFiles.add(new AudioFile("Jelous", "Ne-Yo", "R.E.D."));
        recentFiles.add(new AudioFile("She Is", "Ne-Yo", "R.E.D."));
        recentFiles.add(new AudioFile("Way", "Falz"));
        recentFiles.add(new AudioFile("Kamikaze", "Eminem"));
        recentFiles.add(new AudioFile("Fast Car", "Taio Cruz"));
        recentFiles.add(new AudioFile("Fast", "Luke Byran", "Kill the Lights"));

        AudioFileAdapter filesAdapter = new AudioFileAdapter(this, recentFiles);

        GridView recentActivityView = (GridView) findViewById(R.id.recent_activity_list);
        recentActivityView.setAdapter(filesAdapter);
    }

    @Override
    public void onBackPressed() {
        if (quitTime < System.currentTimeMillis())
        {
            // on hardware back button pressed, confirm notification by toast
            confirmQuit();
        }
        else
        {
            // on hardware back button pressed, quit the app
            quitApp();
        }
    }

    /**
     *
     */
    void confirmQuit() {
        // display confirm toast
        Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_LONG).show();
        quitTime = System.currentTimeMillis() + (ONE_MILLISECOND * 5);
    }

    /**
     * Quit and exit the application.
     */
    void quitApp() {
        // drop activity from memory
        finish();

        System.exit(0);
    }


}
