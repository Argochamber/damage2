package com.argochamber.games.damage20.sources;

/**
 * This is used if want to be a source of damage.
 * Created by Pablo on 03/07/2016.
 */
public abstract class Source {

    /**
     * The name of the source of damage.
     */
    protected final String name;

    /**
     * The description of the source of damage.
     */
    protected final String desc;

    public Source(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}
