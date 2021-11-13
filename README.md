# NetworkRequest
Light weight library to make network request call with call backs and alerts

```ruby

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

```

