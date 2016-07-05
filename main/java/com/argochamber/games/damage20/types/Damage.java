package com.argochamber.games.damage20.types;

import com.argochamber.games.damage20.sources.Source;
import com.argochamber.games.damage20.sources.Sources;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Pablo on 03/07/2016.
 */
public class Damage implements Serializable {

    public static final class DamageSet extends java.util.ArrayList<Map.Entry<Damage, Integer>> {

    }

    public static final Damage
            IMPACT = new Damage("Impact",
            "Physical impact damage",
            "Stagger",
            "impact",
            Sources.IMPACT),
            PUNCTURE = new Damage("Puncture",
                    "Physical piercing damage",
                    "Damage",
                    "pierce",
                    Sources.PUNCTURE),
            SLASH = new Damage("Slash",
                    "Physical slash damage",
                    "Bleed",
                    "slash",
                    Sources.SLASH),
            COLD = new Damage("Cold",
                    "Elemental cold damage",
                    "Slowdown",
                    "cold",
                    Sources.COLD),
            ELECTRICITY = new Damage("Electricity",
                    "Elemental electric damage",
                    "Chain Attack Stun",
                    "electrify",
                    Sources.ELECTRICITY),
            HEAT = new Damage("Heat",
                    "Elemental fire damage",
                    "Fire DoT Panic",
                    "heat",
                    Sources.HEAT),
            TOXIN = new Damage("Toxin",
                    "Elemental toxic damage",
                    "Health DoT",
                    "toxin",
                    Sources.TOXIN),
            BLAST = new Damage("Blast",
                    "Combined explosive damage",
                    "Knockdown",
                    "blast",
                    Sources.BLAST),
            CORROSIVE = new Damage("Corrosive",
                    "Combined corrosion damage",
                    "(-) Armor",
                    "corrode",
                    Sources.CORROSIVE),
            GAS = new Damage("Gas",
                    "Combined gas damage",
                    "Toxin AoE",
                    "gas",
                    Sources.GAS),
            MAGNETIC = new Damage("Magnetic",
                    "Combined magnetic damage",
                    "(-) Max Shields",
                    "magnet",
                    Sources.MAGNETIC),
            RADIATION = new Damage("Radiation",
                    "Combined radioactive damage",
                    "(-) Accuracy, Friendly fire",
                    "radiation",
                    Sources.RADIATION),
            VIRAL = new Damage("Viral",
                    "Combined virus damage",
                    "(-) Max Health",
                    "virus",
                    Sources.VIRAL);

    /**
     * The name of the damage type.
     */
    protected final String name;

    /**
     * A brief description of the damage type.
     */
    protected final String desc;

    /**
     * The icon name of the damage.
     */
    protected final String icon;

    /**
     * The effect description.
     */
    protected final String effect;

    /**
     * The list of the possible sources for this damage type.
     */
    protected final java.util.List<Source> sources;

    /**
     * This will initialize all at once.
     * @param name
     * @param desc
     * @param effect
     * @param icon
     * @param sources
     */
    public Damage(String name, String desc, String effect, String icon, java.util.List<Source> sources) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.effect = effect;
        this.sources = sources;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getIcon() {
        return icon;
    }

    public String getEffect() {
        return effect;
    }

    public List<Source> getSources() {
        return sources;
    }

}
