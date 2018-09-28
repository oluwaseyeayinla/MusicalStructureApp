package com.alc.musicplayer.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    public static final String ARTIST_NAME_KEY = "#Artist";
    public static final String SONG_TITLE_KEY = "#SongTitle";
    public static final String ALBUM_TITLE_KEY = "#AlbumTitle";
    public static final String ALBUM_ART_KEY = "#AlbumArt";

    private TextView songTitleTextView;
    private TextView artistAndAlbumTextView;
    private ImageView albumArtImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        songTitleTextView = (TextView) findViewById(R.id.song_title_text_view);
        String songTitle = getSongTitle(savedInstanceState);
        if (songTitle != null)
        {
            songTitleTextView.setText(songTitle);
        }

        artistAndAlbumTextView = (TextView) findViewById(R.id.album_artist_title_text_view);
        String artistName = getArtistName(savedInstanceState);
        if (artistName != null)
        {
            String albumTitle = getAlbumTitle(savedInstanceState);
            albumTitle =  albumTitle != null && !albumTitle.isEmpty() ? albumTitle : songTitle;
            artistAndAlbumTextView.setText(getString(R.string.artist_with_album, artistName, albumTitle));
        }

        albumArtImageView = (ImageView) findViewById(R.id.album_art_image_view);
        int albumArt = getAlbumArt(savedInstanceState);
        albumArtImageView.setImageResource(albumArt);
    }


    String getArtistName(Bundle bundle)
    {
        if (bundle == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras == null)
            {
                return null;
            }
            else
            {
                return extras.getString(ARTIST_NAME_KEY);
            }
        }
        else
        {
            return (String) bundle.getSerializable(ARTIST_NAME_KEY);
        }
    }

    int getAlbumArt(Bundle bundle)
    {
        if (bundle == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras == null)
            {
                return R.drawable.album_art_goes_here;
            }
            else
            {
                return extras.getInt(ALBUM_ART_KEY);
            }
        }
        else
        {
            return (int) bundle.getSerializable(ALBUM_ART_KEY);
        }
    }

    String getAlbumTitle(Bundle bundle)
    {
        if (bundle == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras == null)
            {
                return null;
            }
            else
            {
                return extras.getString(ALBUM_TITLE_KEY);
            }
        }
        else
        {
            return (String) bundle.getSerializable(ALBUM_TITLE_KEY);
        }
    }

    String getSongTitle(Bundle bundle)
    {
        if (bundle == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras == null)
            {
                return null;
            }
            else
            {
                return extras.getString(SONG_TITLE_KEY);
            }
        }
        else
        {
            return (String) bundle.getSerializable(SONG_TITLE_KEY);
        }
    }
}
