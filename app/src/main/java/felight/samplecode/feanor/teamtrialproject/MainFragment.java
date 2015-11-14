package felight.samplecode.feanor.teamtrialproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.util.Arrays;
import java.util.List;
/**
 * Created by Merlin on 11/13/2015.
 */
public class MainFragment extends Fragment {

    private TextView textView;
    private CallbackManager callbackManager;
    String uri;
    //To know whether the login is sucessful or not.
    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

            //It contains the current token that we get
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        /*List<String> permissionforNeeds = Arrays.asList("publish_actions");
        LoginManager manager = LoginManager.getInstance();
        manager.logInWithPublishPermissions(this, permissionforNeeds);*/
        //Manages the call back to Facebook SDK either from activity or from fragment from onActivityResult method
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Initializing the login button
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        //Taking permissions from the user
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        //Calling the callbackmanager and sending the values .
        loginButton.registerCallback(callbackManager,callback);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Passing the parameters to the callbackmanager
        callbackManager.onActivityResult(requestCode,resultCode,data);

       /* if(requestCode==2) {
            uri = data.getStringExtra("Image");
            SharePhoto photo = new SharePhoto.Builder()
                    .setImageUrl(Uri.parse(uri))
                    .build();
            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)
                    .build();
            ShareApi.share(content, null);
        }*/
    }
}
