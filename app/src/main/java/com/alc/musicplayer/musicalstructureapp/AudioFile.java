package com.alc.musicplayer.musicalstructureapp;

public class AudioFile
{
    /** Title of the audio file */
    private String mSongTitle;
    /** Name of song artist translation of word */
    private String mArtistName;
    /** Album title of song if there is one */
    private String mAlbumTitle;
    /** Album art of song if there is one */
    private int mAlbumArtImageResourceId;

    private static final int NO_IMAGE_RESOURCE_ID = -1;


    /**
     * Create a new Audio File object.
     * @param songTitle title of the song
     * @param artistName name of the artist
     */
    public AudioFile(String songTitle, String artistName)
    {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumTitle = "";
        mAlbumArtImageResourceId = NO_IMAGE_RESOURCE_ID;
    }

    /**
     * Create a new Audio File object.
     * @param songTitle title of the song
     * @param artistName name of the artist
     * @param albumTitle title of the album if any
     */
    public AudioFile(String songTitle, String artistName, String albumTitle)
    {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumTitle = albumTitle;
        mAlbumArtImageResourceId = NO_IMAGE_RESOURCE_ID;
    }

    /**
     * Create a new Audio File object.
     * @param songTitle title of the song
     * @param artistName name of the artist
     * @param albumTitle title of the album if any
     * @param albumArtImageResourceId drawable image resource id
     */
    public AudioFile(String songTitle, String artistName, String albumTitle, int albumArtImageResourceId)
    {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumTitle = albumTitle;
        mAlbumArtImageResourceId = albumArtImageResourceId;
    }

    /**
     * Returns the song title
     * @return title of song
     */
    public String getSongTitle()
    {
        return mSongTitle;
    }

    /**
     * Returns the name of the artist
     * @return name of artist
     */
    public String getArtistName()
    {
        return mArtistName;
    }

    /**
     * Returns the album title
     * @return title of album
     */
    public String  getAlbumTitle() { return mAlbumTitle; }

    /**
     * Checks if the song of the audio file has an album title
     * @return if audio file has an album title
     */
    public boolean hasAlbumTitle()
    {
        return mAlbumTitle != "";
    }

    /**
     * Returns the album art image resource id for the word
     * @return the album art of the song if any exists
     */
    public int  getAlbumArt() { return mAlbumArtImageResourceId; }

    /**
     * Checks if the song of the audio file has an album art
     * @return true if audio file has an album art, and false if not
     */
    public boolean hasAlbumArtImageResourceId()
    {
        return mAlbumArtImageResourceId != NO_IMAGE_RESOURCE_ID;
    }
}

