package id.web.devgolan.splashscreen;

import android.os.Bundle;

//import com.example.splash.Loading.LoadingTaskFinishedListener;

import android.app.Activity;
import android.content.Intent;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements Loading.LoadingTaskFinishedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar_Horizontal);
        new Loading(progressBar, this).execute("");

    }

    @Override
    public void onTaskFinished() {
        completeSplash();
    }
    private void completeSplash(){
        startApp();
        finish(); // Don't forget to finish this Splash Activity so the user can't return to it!
    }
    private void startApp() {
        Intent intent = new Intent(MainActivity.this, Dashboard.class);
        startActivity(intent);
    }

}