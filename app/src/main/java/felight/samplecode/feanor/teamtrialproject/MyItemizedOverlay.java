package felight.samplecode.feanor.teamtrialproject;

import android.graphics.Point;
import android.graphics.drawable.Drawable;

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

/**
 * Created by SurroundSync1 on 11/12/2015.
 */
public class MyItemizedOverlay extends ItemizedOverlay {
    //It is for giving inputs for array JSON list

    private ArrayList<OverlayItem> overlayItems=new ArrayList<OverlayItem>();

    @Override
    protected OverlayItem createItem(int i) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

//Selecting the required destination or location
    public MyItemizedOverlay(Drawable pDefaultMarker,ResourceProxy pResourceProxy){
        super(pDefaultMarker,pResourceProxy);
    }
    //Giving the location as input
    public void addItem(GeoPoint geoPoint,String title,String snippet){
        OverlayItem newItem=new OverlayItem(title,snippet,geoPoint);
        overlayItems.add(newItem);
        populate();

    }



    @Override
    public boolean onSnapToItem(int i, int i1, Point point, IMapView iMapView) {
        return false;
    }
}
