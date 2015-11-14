package felight.samplecode.feanor.teamtrialproject;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

/**
 * Created by Merlin on 11/13/2015.
 */
public class OSMDroidMapActivity extends Activity {


    /**
     * Created by SurroundSync1 on 11/12/2015.
     */
        MapController mapController;
        MyItemizedOverlay myItemizedOverlay=null;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //To view the tiles
            MapView mapView=(MapView)findViewById(R.id.mapview);
            //Zoom controls
            mapView.setBuiltInZoomControls(true);
            Drawable marker=getResources().getDrawable(R.drawable.star);
            //Default width and height of the marker
            int markerWidth=marker.getIntrinsicWidth();
            int markerHeight=marker.getIntrinsicHeight();
            marker.setBounds(0, markerHeight, markerWidth, 0);
            //It returns fixed string to get string resources and reads the jar package to get bitmap resources
            ResourceProxy resourceProxy=new DefaultResourceProxyImpl(getApplicationContext());
            myItemizedOverlay=new MyItemizedOverlay(marker,resourceProxy);
            //Setting the location to some latitude and longitude
            GeoPoint mypoint1=new GeoPoint(0*1000000, 0*1000000);
            myItemizedOverlay.addItem(mypoint1, "mypoint1", "mypoint1");
        }
    }
