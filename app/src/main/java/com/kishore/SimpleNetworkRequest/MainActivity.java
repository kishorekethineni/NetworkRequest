package com.kishore.SimpleNetworkRequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.kishore.resusablenetworkcall.InvalidBuilderException;
import com.kishore.resusablenetworkcall.Network;
import com.kishore.resusablenetworkcall.NetworkCallback;
import com.kishore.resusablenetworkcall.NetworkClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Network.NetworkBuilder builder = new Network.NetworkBuilder(this);
        try {
            Network network = builder //FORM A BUILDER
                    .AlertSuccessImage(R.drawable.green_tick_24)
                    .SuccessMessage("***PASS SUCCESS MESSAGE HERE***") // OPTIONAL
                    .FailedSuccessImage(R.drawable.error_24) // OPTIONAL
                    .FailedMessage("***PASS ERROR MESSAGE HERE***") // OPTIONAL
                    .Method(NetworkCallback.GET) // *REQUIRED NetworkCallback.GET or NetworkCallback.POST
                    .URL("***PASS URL HERE***") // *REQUIRED URL is mandatory
                    .RequestBody("***PASS REQUEST BODY HERE***") //*REQUIRED IF GIVEN POST METHOD
                    .IPAddress("***PASS IP Address HERE to check ping for your server***") //Optional to check ping
                    .NetworkFailedMessage("***PASS PING FAILED MESSAGE HERE***") // OPTIONAL
                    .NetworkCallback(new NetworkCallback() { //*REQUIRED to get result
                        @Override
                        public void GetResponse(String response) {
                            System.out.println("Response: "+response); //JSON RESPONSE
                        }
                    })
                    .build();

            new NetworkClass(network).execute(); // Execute the request using this line

        } catch (InvalidBuilderException e) {
            e.printStackTrace();
        }
    }
}