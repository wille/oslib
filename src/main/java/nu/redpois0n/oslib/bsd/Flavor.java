package nu.redpois0n.oslib.bsd;

import nu.redpois0n.oslib.UnsupportedOperatingSystemException;

public enum Flavor {

    FREEBS("FreeBSD"),
    OPENBSD("OpenBSD"),
    NETBSD("NetBSD"),
    DRAGONFLYBSD("DragonFlyBSD", "DragonFly"),
    UNKNOWN("Unknown BSD", "BSD");

    private final String name;
    private final String[] search;

    Flavor(String name, String... search) {
        this.name = name;
        this.search = search;
    }

    public String getName() {
        return this.name;
    }

    public String[] getSearch() {
        return this.search;
    }

    public String getPrimarySearch() {
        return this.search[0];
    }

    public static Flavor getFlavorFromString(String s) {
        for (Flavor d : values()) {
            if (d.getName().toLowerCase().contains(s.toLowerCase())) {
                return d;
            }

            for (String search : d.getSearch()) {
                if (search.toLowerCase().contains(s.toLowerCase())) {
                    return d;
                }
            }
        }

        return null;
    }

    public static Flavor getLocalFlavor() throws UnsupportedOperatingSystemException {
        return FlavorDetector.detect(true);
    }
}
