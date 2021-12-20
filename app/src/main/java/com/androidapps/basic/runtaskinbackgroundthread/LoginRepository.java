package com.androidapps.basic.runtaskinbackgroundthread;

public class LoginRepository {
/*
    private final String loginUrl = "https://example.com/login";
    private final LoginResponseParser responseParser;

    private final Executor executor;

    public LoginRepository(LoginResponseParser responseParser) {
        this.responseParser = responseParser;
    }


    public LoginRepository(LoginResponseParser responseParser, Executor executor) {
        this.responseParser = responseParser;
        this.executor = executor;
    }

    public Result<LoginResponse> makeLoginRequest(String jsonBody) {
        try {
            URL url = new URL(loginUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setDoOutput(true);
            httpConnection.getOutputStream().write(jsonBody.getBytes("utf-8"));

            LoginResponse loginResponse = responseParser.parse(httpConnection.getInputStream());
            return new Result.Success<LoginResponse>(loginResponse);
        } catch (Exception e) {
            return new Result.Error<LoginResponse>(e);
        }
    }

    *//*Inside the execute() method, we create a new Runnable with the block of code we want to execute in the background thread—in our case,
     the synchronous network request method. Internally,
    the ExecutorService manages the Runnable and executes it in an available thread.*//*
    public void makeLoginRequest(final String jsonBody) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Result<LoginResponse> ignoredResponse = makeSynchronousLoginRequest(jsonBody);
            }
        });


    }
    public Result<LoginResponse> makeSynchronousLoginRequest(String jsonBody) {
        // HttpURLConnection logic
    }*/
}
