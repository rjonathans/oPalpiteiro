package br.com.digitalhouse.opalpiteiro.Home;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import br.com.digitalhouse.opalpiteiro.R;
import br.com.digitalhouse.opalpiteiro.splash.ActivitySplash;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 4000; //This is 4 seconds

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash();
        initViews();
        /*ValidaDadosEvaiPraHome();*/




        //Code to start timer and take action after the timer ends

    }

    public void splash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(MainActivity.this, ActivitySplash.class);
                startActivity(mySuperIntent);
                /* This 'finish()' is for exiting the app when back button pressed
                 *  from Home page which is ActivityHome
                 */
                finish();
            }
        }, SPLASH_TIME);


        return;
    }

    private void ValidaDadosEvaiPraHome() {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if (email.isEmpty()){
            textInputLayoutEmail.setError("Email não pode ser vazio");
            return;
        }

        if (password.isEmpty()){
            textInputLayoutPassword.setError("Password não pode ser vazio");
            return;
        }


        if (email.equals("robson@live.com") && password.equals("123")){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("NAME", "Robson");

            intent.putExtras(bundle);

            startActivity(intent);
        }else {
            Snackbar.make(textInputLayoutEmail, "Email ou senha invalidos", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.inputEmail);
        textInputLayoutPassword = findViewById(R.id.inputSenha);
        btnLogin = findViewById(R.id.btnLogin);
    }




}
