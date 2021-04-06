package br.com.blackbook.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import br.com.blackbook.R;
import br.com.blackbook.interfaces.LoginInterface;
import br.com.blackbook.presenters.LoginPresenter;

public class LoginView extends AppCompatActivity implements LoginInterface.View {

    private  LoginInterface.Presenter presenter;
    CircularProgressIndicator progress;
    EditText email, passowrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenter(this);
        progress = findViewById(R.id.progress);
        email = findViewById(R.id.email);
        passowrd = findViewById(R.id.password);


        
    }

    @Override
    public void hideProgress() {

        progress.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void message(String msg) {
        toast(msg);

    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    public void access(View view) {
        presenter.validateUI(email.getText().toString(), passowrd.getText().toString());
    }
}