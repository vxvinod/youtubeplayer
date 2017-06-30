package example.org.youtubeplayerreal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
                                implements View.OnClickListener
{

    private Button single_video;
    private Button playlist_video;
    private String GOOGLE_API_KEY = "AIzaSyAMeb-hM-9WUY4v11jxDYhL3Xe8z8GUSvg";
    private String YOUTUBE_VIDEO_ID = "Cpc-t-Uwv1I";
    private String YOUTBE_PLAYLIST_ID = "PL70DEC2B0568B5469";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        single_video = (Button) findViewById(R.id.btn_singlevdeo);
        playlist_video = (Button) findViewById(R.id.btn_playlist);
        single_video.setOnClickListener(this);
        playlist_video.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case(R.id.btn_singlevdeo):
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case (R.id.btn_playlist):
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTBE_PLAYLIST_ID);
                break;
            default:
                //Nothing

        }

        if(intent!=null){
            startActivity(intent);
        }

    }
}
