package com.argochamber.games.damage20.sources;

/**
 * Created by Pablo on 03/07/2016.
 */
public class Sources extends java.util.ArrayList<Source> {

    public static final Sources
            IMPACT = new Sources(),
            PUNCTURE = new Sources(),
            SLASH = new Sources(),
            COLD = new Sources(),
            ELECTRICITY = new Sources(),
            HEAT = new Sources(),
            TOXIN = new Sources(),
            BLAST = new Sources(),
            CORROSIVE = new Sources(),
            GAS = new Sources(),
            MAGNETIC = new Sources(),
            RADIATION = new Sources(),
            VIRAL = new Sources();

    static {
        IMPACT.add(Mod.MOD_RUPTURE);
        IMPACT.add(Mod.MOD_CRASHCOURSE);
    }

}
