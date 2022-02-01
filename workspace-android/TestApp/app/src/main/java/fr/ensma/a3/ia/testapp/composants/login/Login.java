package fr.ensma.a3.ia.testapp.composants.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;

import fr.ensma.a3.ia.testapp.R;
import fr.ensma.a3.ia.testapp.composants.fragments.login.FragLogin;
import fr.ensma.a3.ia.testapp.composants.navigation.INavigationObserver;

public class Login extends FrameLayout {

    private EditText textField;
    private Button bouton;
    private TextView textVue;

    private ArrayList<ILoginObserver> mesObs;
    private TypedArray att;

    public Login(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.compo_login, this);
        mesObs = new ArrayList<ILoginObserver>();
    }

    public Login(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.compo_login, this);
        setCompo(context,attrs);
    }

    public Login(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.compo_login, this);
        setCompo(context,attrs);
    }

    public Login(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater.from(context).inflate(R.layout.compo_login, this);
        setCompo(context,attrs);
    }

    private void setCompo(Context ctx, AttributeSet attrs) {
        mesObs = new ArrayList<ILoginObserver>();
        att = ctx.obtainStyledAttributes(attrs,R.styleable.Login);
        textField = (EditText) findViewById(R.id.textField);
        bouton = (Button) findViewById(R.id.Bouton);
        textVue = (TextView) findViewById(R.id.textView);
        textVue.setText("Donne ton nom");
        //bouton.setOnClickListener();
    }

    public void addObserver(ILoginObserver ob) {
        mesObs.add(ob);
    }
}
