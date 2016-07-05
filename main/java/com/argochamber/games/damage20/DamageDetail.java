package com.argochamber.games.damage20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.argochamber.games.damage20.types.Damage;

import java.io.Serializable;

public class DamageDetail extends AppCompatActivity {

    /**
     * Keys for the extra data that will be settled up from the outside.
     */
    public static final String
        DMG_DAMAGE_NAME = "com.argochamber.games.damage20.DamageDetail#DAMAGE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup the external given data
        Damage s = null;
        try {
            s = (Damage)Damage.class.getField(getIntent().getStringExtra(DMG_DAMAGE_NAME).toUpperCase()).get(s);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        android.support.design.widget.CollapsingToolbarLayout t = (android.support.design.widget.CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        t.setTitle(s.getName());

        TextView text = (TextView)findViewById(R.id.damage_detail_content);
        text.setText(s.getDesc()+"\n\nEffect: "+s.getEffect());

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
}
