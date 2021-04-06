package br.com.blackbook.presenters;

import android.os.Handler;
import android.os.Looper;

import br.com.blackbook.interactors.LoginInteractor;
import br.com.blackbook.interfaces.LoginInterface;

public class LoginPresenter implements LoginInterface.Presenter {
    private LoginInterface.View view;
    private LoginInterface.Interactor interactor;

    public LoginPresenter(LoginInterface.View view) {
        this.view = view;
        this.interactor = new LoginInteractor();¡

    }

    @Override
    public void validateUI(String email, String password) {

        view.showProgress();
        String error = UiValidation.validate(email, password);
        if (error == null) {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                 String errorApi = interactor.access(email, password);
                if(errorApi!= null){
                    view.message(errorApi);
                }
                view.message("VALIDADO");
                view.hideProgress();
            }, 3000);
        } else {
            view.message(error);
            view.hideProgress();
        }

    }


}
