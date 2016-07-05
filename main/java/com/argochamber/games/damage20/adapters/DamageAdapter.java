package com.argochamber.games.damage20.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.argochamber.games.damage20.R;
import com.argochamber.games.damage20.types.Damage;
import com.argochamber.games.damage20.types.Faction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This inflates the layouts of the damage types.
 * Created by Pablo on 03/07/2016.
 */
public class DamageAdapter extends BaseAdapter {

    /**
     * Factions.
     */
    private final Damage.DamageSet damages;

    /**
     * The layout inflater.
     */
    private final LayoutInflater inflater;

    /**
     * The activity's reference.
     */
    private final Activity activity;

    /**
     * The faction that must be represented by.
     */
    private final Faction faction;

    /**
     * Direct simple constructor.
     * @param damages
     */
    public DamageAdapter(Activity activity, Damage.DamageSet damages, Faction faction) {
        this.damages = damages;
        this.activity = activity;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.faction = faction;
    }

    @Override
    public int getCount() {
        return damages.size();
    }

    @Override
    public Object getItem(int position) {
        return damages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * <h3>Populates the view.</h3>
     * <p>
     *     <i>Inherited method.</i>
     * </p>
     * @see BaseAdapter#getView(int, View, ViewGroup)
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DamageViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.damage_list_item, null);
            holder = new DamageViewHolder();
            holder.text = (TextView)convertView.findViewById(R.id.name);
            holder.icon = (ImageView)convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else {
            holder = (DamageViewHolder) convertView.getTag();
        }
        try {
            Integer value = damages.get(position).getValue();
            holder.text.setText(
                    damages.get(position).getKey().getName()
                            .concat(" (")
                            .concat(value.toString())
                            .concat("%)"));
            if (value > 5){
                holder.text.setTextColor(Color.BLUE);
            } else if (value < 5){
                holder.text.setTextColor(Color.RED);
            }
            //Set the icon
            int a = 0;
            holder.icon.setImageResource(R.drawable.class.getField(damages.get(position).getKey().getIcon()).getInt(a));
        } catch (NullPointerException ex){
            System.err.println("FATAL! Could not set the view's damage name!!!");
            ex.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return convertView;
    }
}