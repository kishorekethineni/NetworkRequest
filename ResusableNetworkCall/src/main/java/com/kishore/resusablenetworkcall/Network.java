package com.kishore.resusablenetworkcall;

import android.app.Activity;


public class Network {
    private final Activity activity; //required
    private final String url; // required
    private final int method; // required
    private final String requestBody; // required
    private final NetworkCallback callback; //required
    private final String alertSuccessMessage; // optional
    private final String alertFailedMessage; // optional
    private final String alertNetworkFailedMessage; // optional
    private final int alertSuccessImage; // optional
    private final int alertFailedImage; // optional
    private final String ipAddress; // optional


    private Network(NetworkBuilder builder) {
        this.activity=builder.activity;
        this.url = builder.url;
        this.method = builder.method;
        this.requestBody = builder.requestBody;
        this.callback = builder.callback;
        this.alertSuccessMessage = builder.alertSuccessMessage;
        this.alertFailedMessage = builder.alertFailedMessage;
        this.alertNetworkFailedMessage = builder.alertNetworkFailedMessage;
        this.alertSuccessImage = builder.alertSuccessImage;
        this.alertFailedImage = builder.alertFailedImage;
        this.ipAddress = builder.ipAddress;
    }
 
    //All getter, and NO setter to provde immutability


    public String getIpAddress() {
        return ipAddress;
    }

    public String getUrl() {
        return url;
    }

    public int getMethod() {
        return method;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public NetworkCallback getCallback() {
        return callback;
    }

    public String getAlertSuccessMessage() {
        return alertSuccessMessage;
    }

    public String getAlertFailedMessage() {
        return alertFailedMessage;
    }

    public String getAlertNetworkFailedMessage() {
        return alertNetworkFailedMessage;
    }

    public int getAlertSuccessImage() {
        return alertSuccessImage;
    }

    public int getAlertFailedImage() {
        return alertFailedImage;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "Network{" +
                "url='" + url + '\'' +
                ", method=" + method +
                ", requestBody='" + requestBody + '\'' +
                ", alertSuccessMessage='" + alertSuccessMessage + '\'' +
                ", alertFailedMessage='" + alertFailedMessage + '\'' +
                ", alertNetworkFailedMessage='" + alertNetworkFailedMessage + '\'' +
                ", alertSuccessImage=" + alertSuccessImage +
                ", alertFailedImage=" + alertFailedImage +
                '}';
    }

    public static class NetworkBuilder
    {
        private final Activity activity; // required
        private String url; // required
        private int method; // required
        private NetworkCallback callback; //required
        private String requestBody; // optional
        private String alertSuccessMessage; // optional
        private String alertFailedMessage; // optional
        private String alertNetworkFailedMessage; // optional
        private int alertSuccessImage; // optional
        private int alertFailedImage; // optional
        private String ipAddress; // optional


        public NetworkBuilder(Activity activity) {
            this.activity = activity;
            this.callback = null;
            this.url = null;
            this.ipAddress = null;
            this.method = 0;
            this.requestBody = null;
            this.alertSuccessMessage = null;
            this.alertFailedMessage = null;
            this.alertNetworkFailedMessage = null;
            this.alertSuccessImage = 0;
            this.alertFailedImage = 0;
        }
        public NetworkBuilder IPAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }
        public NetworkBuilder URL(String url) {
            this.url = url;
            return this;
        }
        public NetworkBuilder Method(int method) {
            this.method = method;
            return this;
        }
        public NetworkBuilder NetworkCallback(NetworkCallback callback) {
            this.callback = callback;
            return this;
        }
        public NetworkBuilder FailedSuccessImage(int alertFailedImage) {
            this.alertFailedImage = alertFailedImage;
            return this;
        }

        public NetworkBuilder AlertSuccessImage(int alertSuccessImage) {
            this.alertSuccessImage = alertSuccessImage;
            return this;
        }

        public NetworkBuilder NetworkFailedMessage(String alertNetworkFailedMessage) {
            this.alertNetworkFailedMessage = alertNetworkFailedMessage;
            return this;
        }
        public NetworkBuilder RequestBody(String requestBody) {
            this.requestBody = requestBody;
            return this;
        }
        public NetworkBuilder SuccessMessage(String alertSuccessMessage) {
            this.alertSuccessMessage = alertSuccessMessage;
            return this;
        }
        public NetworkBuilder FailedMessage(String alertFailedMessage) {
            this.alertFailedMessage = alertFailedMessage;
            return this;
        }
        //Return the finally consrcuted User object
        public Network build() throws InvalidBuilderException {
            Network network =  new Network(this);
            validateUserObject(network);
            return network;
        }
        private void validateUserObject(Network network) throws InvalidBuilderException {
            if (network.getCallback()==null){
                throw new InvalidBuilderException("CallBack, URL and Method is required please intitiate builder properly");
            }
            if (network.getUrl()==null){
                throw new InvalidBuilderException("CallBack, URL and Method is required please intitiate builder properly");
            }
            if (network.method==0){
                throw new InvalidBuilderException("CallBack, URL and Method is required please intitiate builder properly");
            }
        }
    }
}