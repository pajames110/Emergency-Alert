package felight.samplecode.feanor.teamtrialproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SimpleActivity extends AppCompatActivity {

    private TextView tvResult;
    String latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simple);

        //Reading the data from message as link
        Intent intent=getIntent();
        tvResult = (TextView) findViewById(R.id.tvUrl);
        Uri data = getIntent().getData();

        if ( data != null ) {

            //scheme - https
            String scheme = data.getScheme();
            //host - maps.google.com
            String host = data.getHost();

            //Extracting latitude and longitude values
            List<String> params = data.getPathSegments();
            latitude = params.get(0);
            longitude = params.get(1);
            //list size
            int size = params.size();
            String third = params.get(size-1);
            tvResult.setText(data.toString()+"\n"+"Latitude :"+latitude+"\n"+"Longitude :"+longitude);
            Toast.makeText(SimpleActivity.this, latitude+"\n"+longitude, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
