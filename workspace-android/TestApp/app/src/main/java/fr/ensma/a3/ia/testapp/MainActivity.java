package fr.ensma.a3.ia.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.ensma.a3.ia.testapp.composants.fragments.login.FragLogin;
import fr.ensma.a3.ia.testapp.composants.login.ILoginObserver;
import fr.ensma.a3.ia.testapp.composants.navigation.Navigation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginObserver {

    private Navigation navHome;
    private FragLogin frLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navHome = (Navigation) findViewById(R.id.navHome);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragmentlayout, new FragLogin(), "FragLogin_Tag")
                .addToBackStack(null).commit();
        getSupportFragmentManager().executePendingTransactions();
        frLogin = (FragLogin) getSupportFragmentManager().findFragmentById("FragLogin_Tag");
        frLogin.addObserver(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void loginOk(String user) {

    }
}