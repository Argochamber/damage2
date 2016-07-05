package com.argochamber.games.damage20.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pablo on 03/07/2016.
 */
public class Health {

    public static final Health
        CLONEDFLESH = new Health("Cloned Flesh", new Object[]{
                Damage.IMPACT, -25,
                Damage.SLASH, 25,
                Damage.HEAT, 25,
                Damage.GAS, -50,
                Damage.VIRAL, 75
        }),
        FERRITE = new Health("Ferrite", new Object[]{
                Damage.PUNCTURE, 50,
                Damage.SLASH, -15,
                Damage.TOXIN, 25,
                Damage.BLAST, -25,
                Damage.CORROSIVE, 75
        }),
        ALLOY = new Health("Alloy", new Object[]{
                Damage.PUNCTURE, 15,
                Damage.SLASH, -50,
                Damage.COLD, 25,
                Damage.ELECTRICITY, -50,
                Damage.MAGNETIC, -50,
                Damage.RADIATION, 75
        }),
        MACHINERY = new Health("Machinery", new Object[]{
                Damage.IMPACT, 25,
                Damage.ELECTRICITY, 50,
                Damage.TOXIN, -25,
                Damage.BLAST, 75,
                Damage.VIRAL, -25
        }),
        FLESH = new Health("Flesh", new Object[]{
                Damage.IMPACT, -25,
                Damage.SLASH, 25,
                Damage.TOXIN, 50,
                Damage.GAS, -25,
                Damage.VIRAL, 50
        }),
        SHIELD = new Health("Shield", new Object[]{
                Damage.IMPACT, 50,
                Damage.PUNCTURE, -20,
                Damage.COLD, 50,
                Damage.MAGNETIC, 75,
                Damage.RADIATION, -25
        }),
        PROTOSHIELD = new Health("Proto-Shield", new Object[]{
                Damage.IMPACT, 15,
                Damage.PUNCTURE, -50,
                Damage.HEAT, -50,
                Damage.CORROSIVE, -50,
                Damage.MAGNETIC, 75
        }),
        ROBOTIC = new Health("Robotic", new Object[]{
                Damage.PUNCTURE, 25,
                Damage.SLASH, -25,
                Damage.ELECTRICITY, 50,
                Damage.TOXIN, -25,
                Damage.RADIATION, 25
        }),
        INFESTED = new Health("Flesh", new Object[]{
                Damage.SLASH, 25,
                Damage.HEAT, 25,
                Damage.GAS, 75,
                Damage.RADIATION, -50,
                Damage.VIRAL, -50
        }),
        INFESTEDFLESH = new Health("Infested Flesh", new Object[]{
                Damage.SLASH, 50,
                Damage.COLD, -50,
                Damage.HEAT, 50,
                Damage.GAS, 50
        }),
        FOSSILIZED = new Health("Fossilized", new Object[]{
                Damage.SLASH, 15,
                Damage.COLD, -25,
                Damage.TOXIN, -50,
                Damage.BLAST, 50,
                Damage.CORROSIVE, 75,
                Damage.RADIATION, -75
        }),
        SINEW = new Health("Sinew", new Object[]{
                Damage.PUNCTURE, 25,
                Damage.COLD, 25,
                Damage.BLAST, -50,
                Damage.RADIATION, 50
        });

    /**
     * This is the name of the type.
     */
    private final String name;

    /**
     * Effect buff table.
     */
    private final Map<Damage, Integer> effect;

    /**
     * This constructor builds the map from the array.
     * @param name
     * @param effector
     */
    private Health(String name, Object[] effector) {
        this.name = name;
        this.effect = new HashMap<>();
        boolean isName = true;
        Damage dmg = null;
        for (Object o : effector){
            if (isName){
                dmg = (Damage)o;
            } else {
                this.effect.put(dmg, (Integer)o);
            }
            isName = !isName;
        }
    }

    /**
     * Direct construction.
     * @param name
     * @param effect
     */
    public Health(String name, Map<Damage, Integer> effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public Map<Damage, Integer> getEffect() {
        return effect;
    }
}
