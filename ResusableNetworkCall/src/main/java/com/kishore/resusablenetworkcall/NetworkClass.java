package com.kishore.resusablenetworkcall;

import android.os.AsyncTask;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkClass extends AsyncTask<String,String,String> {


    private LoadingDialog dialog;

    private final Network network;

    public NetworkClass (Network network){
        this.network=network;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new LoadingDialog(network.getActivity());
        dialog.startLoadingDialog();
        if (!NetworkUtils.isConnected(network.getActivity(),network.getAlertNetworkFailedMessage()==null?"Unable to connect":network.getAlertNetworkFailedMessage(),network.getIpAddress())){
            cancel(true);
            onCancelled(null);
            dialog.dismissDialog(NetworkUtils.isResource(network.getActivity(),network.getAlertFailedImage())?network.getAlertFailedImage():R.drawable.error_24,network.getAlertFailedMessage()==null?"Failed":network.getAlertFailedMessage());
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        if (network.getMethod()==NetworkCallback.GET) {
            Request request = new Request.Builder()
                    .url(network.getUrl())
                    .method("GET", null)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else{
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, network.getRequestBody());
            Request request = new Request.Builder()
                    .url(network.getUrl())
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        network.getCallback().GetResponse(s);
        if (s!=null)
            dialog.dismissDialog(NetworkUtils.isResource(network.getActivity(),network.getAlertSuccessImage())?network.getAlertSuccessImage():R.drawable.green_tick_24,network.getAlertSuccessMessage()==null?"Success":network.getAlertSuccessMessage());
        else
            dialog.dismissDialog(NetworkUtils.isResource(network.getActivity(),network.getAlertFailedImage())?network.getAlertFailedImage():R.drawable.error_24,network.getAlertFailedMessage()==null?"Failed":network.getAlertFailedMessage());
    }

}
