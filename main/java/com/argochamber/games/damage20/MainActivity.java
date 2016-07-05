package com.argochamber.games.damage20;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.argochamber.games.damage20.adapters.DamageAdapter;
import com.argochamber.games.damage20.adapters.DamageViewHolder;
import com.argochamber.games.damage20.types.Damage;
import com.argochamber.games.damage20.types.Faction;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * Faction references, and their keys for the selector.
     */
    public static final Faction[] FACTIONS = new Faction[]{
            Faction.GRINEER,
            Faction.CORPUS,
            Faction.INFESTED,
            Faction.CORRUPTED,
            Faction.TENNO
    };

    /**
     * Iterable version, damages reference list.
     */
    public static final Damage[] DAMAGES = new Damage[]{
            Damage.IMPACT,
            Damage.PUNCTURE,
            Damage.SLASH,
            Damage.COLD,
            Damage.ELECTRICITY,
            Damage.HEAT,
            Damage.TOXIN,
            Damage.BLAST,
            Damage.CORROSIVE,
            Damage.GAS,
            Damage.MAGNETIC,
            Damage.RADIATION,
            Damage.VIRAL
    };

    /**
     * The faction that we have selected.
     */
    protected Faction selectedFaction = FACTIONS[0];

    /**
     * This will populate the choices, returns the Spinner.
     * @return
     */
    private Spinner populateEnemyTypes(){
        Spinner enemies = (Spinner) findViewById(R.id.enemies_selector);

        //Setup the names
        ArrayAdapter<CharSequence> names = ArrayAdapter.createFromResource(this,
                R.array.enemies_list, android.R.layout.simple_spinner_item);
        names.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enemies.setAdapter(names);

        return enemies;
    }

    /**
     * Updates the graphical information of the faction.
     */
    private void updateFactionData(){
        ListView list = (ListView) findViewById(R.id.damage_suggestion_list);
        ListAdapter adapter = new DamageAdapter(this, selectedFaction.getCalcAmount(), selectedFaction);
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Call the populators
        Spinner enemies = populateEnemyTypes();
        this.updateFactionData();//Update the faction data.
        enemies.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                try {
                    selectedFaction = FACTIONS[pos];
                } catch(ArrayIndexOutOfBoundsException ex){
                    selectedFaction = FACTIONS[0];
                    System.err.println("The item"+pos+" does not exist in the array of damages!");
                }
                updateFactionData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Ignore this
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        /*if (id == R.id.action_true_damage){
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

}
