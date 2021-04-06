package br.com.blackbook.interactors;

import br.com.blackbook.interfaces.LoginInterface;

public class LoginInteractor implements LoginInterface.Interactor {

    private String mResponse = null;

    @Override
    public String access(String email, String password) {


            if (email.length() <= 5) {
                mResponse = "email errado";
            }

            if (password.length() <= 5) {
                mResponse = "password errado";
            }


        return mResponse;

    }
}
