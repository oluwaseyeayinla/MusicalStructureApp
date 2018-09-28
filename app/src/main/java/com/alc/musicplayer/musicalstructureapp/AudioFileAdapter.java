package com.alc.musicplayer.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AudioFileAdapter extends ArrayAdapter<AudioFile> {

    private static final String LOG_TAG = AudioFileAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param audioFile A list of AudioFile objects to display in a list
     */
    public AudioFileAdapter(Activity context, ArrayList<AudioFile> audioFile) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, audioFile);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.recent_audio_file, parent, false);
        }

        final AudioFile currentFile = getItem(position);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link NowPlayingActivity}
                Intent nowPlayingIntent = new Intent(getContext(), NowPlayingActivity.class);
                nowPlayingIntent.putExtra(NowPlayingActivity.ALBUM_TITLE_KEY,currentFile.getAlbumTitle());
                nowPlayingIntent.putExtra(NowPlayingActivity.ARTIST_NAME_KEY,currentFile.getArtistName());
                nowPlayingIntent.putExtra(NowPlayingActivity.SONG_TITLE_KEY,currentFile.getSongTitle());
                if(currentFile.hasAlbumArtImageResourceId())
                {
                    nowPlayingIntent.putExtra(NowPlayingActivity.ALBUM_ART_KEY,currentFile.getAlbumArt());
                }
                else
                {
                    nowPlayingIntent.putExtra(NowPlayingActivity.ALBUM_ART_KEY,R.drawable.album_art_goes_here);
                }
                // Start the new activity
                getContext().startActivity(nowPlayingIntent);
            }
        });

        // Find the TextView in the recent_audio_file.xml layout with the ID song_or_album_title
        TextView songOrAlbumTitle = (TextView) listItemView.findViewById(R.id.song_or_album_title);
        songOrAlbumTitle.setText(currentFile.getSongTitle());

        // Find the TextView in the recent_audio_file.xml layout with the ID artist_name
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name);
        if(currentFile.hasAlbumTitle())
        {
            artistName.setText(currentFile.getArtistName() + " - " + currentFile.getAlbumTitle());
        }
        else
        {
            artistName.setText(currentFile.getArtistName());
        }

        // Find the ImageView in the recent_audio_file.xml layout with the ID album_art
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.album_art);
        if(currentFile.hasAlbumArtImageResourceId())
        {
            iconView.setImageResource(currentFile.getAlbumArt());
        }
        else
        {
            iconView.setImageResource(R.drawable.album_art_goes_here);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }
}