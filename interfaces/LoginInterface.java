package br.com.blackbook.interfaces;

public class LoginInterface {
    public interface View {
        void hideProgress();

        void showProgress();

        void message(String msg);
    }

    public interface Presenter {
        void validateUI(String email, String password);
    }

    public interface Interactor {
        String access(String email, String password);

    }
}