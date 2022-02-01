package fr.ensma.a3.ia.testapp.composants.fragments.login;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.testapp.MainActivity;
import fr.ensma.a3.ia.testapp.R;
import fr.ensma.a3.ia.testapp.composants.login.ILoginObserver;
import fr.ensma.a3.ia.testapp.composants.login.Login;

public class FragLogin extends Fragment implements ILoginObserver {

    private Login compoLogin;
    private List<ILoginObserver> mesObs = new ArrayList<>();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        compoLogin = (Login) getActivity().findViewById(R.id.compoLogin);
        compoLogin.addObserver(this);
    }

    @Override
    public void loginOk(String user) {
        for (ILoginObserver ob : mesObs) {
            ob.loginOk(user);
        }
    }


    public void addObserver(ILoginObserver ob) {
        mesObs.add(ob);
    }
}
