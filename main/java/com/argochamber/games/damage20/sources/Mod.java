package com.argochamber.games.damage20.sources;

/**
 * Created by Pablo on 03/07/2016.
 */
public class Mod extends Source {

    public static final Mod
        MOD_HELLFIRE = new Mod("Hellfire",
                "+90% of heat",
                Polarity.NARAMON,
                20,
                11,
                WType.RIFLE),
        MOD_RUPTURE = new Mod("Rupture",
                "+30% Impact",
                Polarity.NARAMON,
                20,
                9,
                WType.RIFLE),
        MOD_CRASHCOURSE = new Mod("Crash Course",
                "+120% Impact",
                Polarity.NARAMON,
                20,
                11,
                WType.RIFLE);

    /**
     * Polarity type for the mod.
     */
    private final Polarity polarity;

    /**
     * Conclave points.
     */
    private final int conclave;

    /**
     * The points that the mod consumes.
     */
    private final int points;

    /**
     * The weapon type.
     */
    private final WType type;

    public Mod(String name, String desc, Polarity polarity, int conclave, int points, WType type) {
        super(name, desc);
        this.polarity = polarity;
        this.conclave = conclave;
        this.points = points;
        this.type = type;
    }

    public enum Polarity {
        MADURAI,
        VAZARIN,
        NARAMON,
        ZENURIK,
        PENJAGA,
        KONEKSI,
        UNAIRU
    }
    public enum WType {
        RIFLE,
        PISTOL,
        SHOTGUN,
        MELEE,
        ARCH_GUN,
        ARCH_MELEE,
        WARFRAME,
        SENTINEL
    }
}
