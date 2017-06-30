package example.org.youtubeplayerreal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
                             implements YouTubePlayer.OnInitializedListener
{
    private String GOOGLE_API_KEY = "AIzaSyAMeb-hM-9WUY4v11jxDYhL3Xe8z8GUSvg";
    private String YOUTUBE_VIDEO_ID = "Cpc-t-Uwv1I";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        YouTubePlayerView youtubeplayer = (YouTubePlayerView) findViewById(R.id.btn_youtube_video);
        youtubeplayer.initialize(GOOGLE_API_KEY, this);
       // setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener(){
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, "Video is playing", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this, "Video is paused", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(YoutubeActivity.this, "Video is stopped", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener stateChangeListener = new YouTubePlayer.PlayerStateChangeListener(){
        @Override
        public void onLoading() {
            Toast.makeText(YoutubeActivity.this, "Video is loading", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this, "Video is started", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Toast.makeText(YoutubeActivity.this, "Youtube player is initialized successfully", Toast.LENGTH_LONG).show();
        youTubePlayer.setPlayerStateChangeListener(stateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if(!b){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(YoutubeActivity.this, "Youtube player failed to initialize", Toast.LENGTH_LONG).show();
    }
}
