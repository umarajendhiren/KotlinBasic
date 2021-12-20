package com.androidapps.basic.runtaskinbackgroundthread;

public class LoginViewModel {

    private final LoginRepository loginRepository;

    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void makeLoginRequest(String username, String token) {
        String jsonBody = "{ username: \"" + username + "\", token: \"" + token + "\" }";
        //loginRepository.makeLoginRequest(jsonBody);
    }
}
