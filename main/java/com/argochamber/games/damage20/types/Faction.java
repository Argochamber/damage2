package com.argochamber.games.damage20.types;

import com.argochamber.games.damage20.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Pablo on 03/07/2016.
 */
public class Faction {

    public static final Faction
        GRINEER = Faction.build("Grineer", Arrays.asList(new Health[]{
                Health.CLONEDFLESH,
                Health.FERRITE,
                Health.ALLOY,
                Health.MACHINERY
        })),
        CORPUS = Faction.build("Corpus", Arrays.asList(new Health[]{
                Health.FLESH,
                Health.SHIELD,
                Health.PROTOSHIELD,
                Health.ROBOTIC
        })),
        INFESTED = Faction.build("Infested", Arrays.asList(new Health[]{
                Health.INFESTED,
                Health.INFESTEDFLESH,
                Health.FOSSILIZED,
                Health.SINEW
        })),
        CORRUPTED = Faction.build("Corrupted", Arrays.asList(new Health[]{
                Health.CLONEDFLESH,
                Health.FLESH,
                Health.FERRITE,
                Health.ALLOY,
                Health.SHIELD,
                Health.PROTOSHIELD,
                Health.ROBOTIC,
                Health.FOSSILIZED
        })),
        TENNO = Faction.build("Tenno", Arrays.asList(new Health[]{
                Health.FLESH,
                Health.FERRITE,
                Health.ALLOY,
                Health.SHIELD,
                Health.PROTOSHIELD
        }));

    /**
     * Build a new faction, with sorted damages.
     * @param name
     * @param types
     * @return
     */
    public static final Faction build(String name, List<Health> types){
        Faction faction = new Faction(name, types);
        faction.calcDamages();
        return faction;
    }

    /**
     * Sort out the maps!
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue( Map<K, V> map )
    {
        List<Map.Entry<K, V>> list =
                new LinkedList<>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
            {
                return ( o1.getValue() ).compareTo( o2.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }

    /**
     * The name of the faction.
     */
    private final String name;

    /**
     * List of health types that the faction has.
     */
    private final List<Health> types;

    /**
     * Sorted version of damages.
     */
    protected Damage.DamageSet sortedDamages;

    /**
     * Call this after construction.
     * <p>
     *     This calculates a damage list that is sorted.
     * </p>
     */
    protected void calcDamages(){
        Map<Damage, Integer> globals = new HashMap<>();
        //Collect data
        for (Health type : this.types){
            for (Map.Entry<Damage, Integer> entry : type.getEffect().entrySet()){
                if ( globals.containsKey(entry.getKey()) ){
                    Integer val = globals.get(entry.getKey());
                    Integer b = entry.getValue();
                    globals.put(entry.getKey(), Math.abs(val) > Math.abs(b) ? val : b);
                } else {
                    globals.put(entry.getKey(), entry.getValue());
                }
            }
        }
        //Fill non affecting ones.
        /*for (Damage d : MainActivity.DAMAGES){
            if (globals.get(d) == null){
                globals.put(d, 0);
            }
        }*/
        //Sort by highest
        globals = sortByValue(globals);
        for (Map.Entry<Damage, Integer> entry : globals.entrySet()){
            this.sortedDamages.add(0, entry);
        }
    }

    private Faction(String name, List<Health> types) {
        this.name = name;
        this.types = types;
        this.sortedDamages = new Damage.DamageSet();
    }

    public String getName() {
        return name;
    }

    public List<Health> getTypes() {
        return types;
    }

    public Damage.DamageSet getCalcAmount(){
        return this.sortedDamages;
    }

}
