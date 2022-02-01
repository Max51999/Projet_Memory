package fr.ensma.a3.ia.testapp.composants.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;

import fr.ensma.a3.ia.testapp.R;

public class Navigation extends LinearLayout {

    private SwitchCompat menuSwitch;
    private TextView menuTextView;

    private TypedArray att;
    private ArrayList<INavigationObserver> mesObs;

    public Navigation(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.compo_navigation, this);
        mesObs = new ArrayList<INavigationObserver>();
    }

    public Navigation(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.compo_navigation, this);
        setCompo(context,attrs);
    }

    public Navigation(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.compo_navigation, this);
        setCompo(context,attrs);
    }


    private void setCompo(Context ctx, AttributeSet attrs) {
        mesObs = new ArrayList<INavigationObserver>();
        att = ctx.obtainStyledAttributes(attrs,R.styleable.Navigation);
        menuSwitch = (SwitchCompat) findViewById(R.id.menuSwitch);
        menuTextView = (TextView) findViewById(R.id.menuTextView);
        menuTextView.setText(att.getString(R.styleable.Navigation_menuString));
        menuSwitch.setEnabled(att.getBoolean(R.styleable.Navigation_activation, true));
        menuSwitch.setText("");
        menuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isPressed()){
                    for (INavigationObserver ob : mesObs) {
                        ob.stateChanged(b,getId());
                    }
                }

            }
        });
    }

    public final void setMenuTextView(final String desc) {menuTextView.setText(desc);}
    public final void setEnable(final Boolean b) {menuSwitch.setEnabled(b);}
    public final void setChecked(final Boolean b) {menuSwitch.setChecked(b);}
    public void addNavigationObserver(INavigationObserver ob) { mesObs.add(ob); }
    public void removeNavigationObserver(INavigationObserver ob) { mesObs.remove(ob); }

}
