package br.com.blackbook.presenters;

public final class UiValidation {


    static String validate(String email, String password) {

        if (email.length() <= 2) {

            return "Tem que ser maior que dois";
        }

        if (password.length() <= 2) {
            return "Tem que ser maior que dois";
        }
        return null;
    }

}
