package oslib.osx;

import oslib.VersionCompare;

public enum OSXVersion implements VersionCompare {

    CHEETAH("Cheetah", "10.0", true),
    PUMA("Puma", "10.1", true),
    JAGUAR("Jaguar", "10.2", true),
    PANTHER("Panther", "10.3", true),
    TIGER("Tiger", "10.4", true),
    LEOPARD("Leopard", "10.5", true),
    SNOW_LEOPARD("Snow Leopard", "10.6", true),
    LION("Lion", "10.7", true),
    MOUNTAIN_LION("Mountain Lion", "10.8", true),
    MAVERICKS("Mavericks", "10.9", true),
    YOSEMITE("Yosemite", "10.10", true),
    EL_CAPITAN("El Capitan", "10.11", true),
    SIERRA("Sierra", "10.12");

    private String search;
    private String version;
    private boolean isX;

    private OSXVersion(String search, String version) {
        this(search, version, false);
    }

    private OSXVersion(String search, String version, boolean isX) {
        this.search = search;
        this.version = version;
        this.isX = isX;
    }

    /**
     * Returns codename, such as Yosemite
     *
     * @return
     */
    public String getDisplay() {
        return search;
    }

    /**
     * Version of OS X, such as 10.10
     *
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * Indicates if this is Mac OS X or the newer macOS
     * @return if Mac OS X (<= 10.11)
     */
    public boolean isOSX() {
        return this.isX;
    }

    /**
     * Gets OSXVersion for this machine
     *
     * @return
     */
    public static OSXVersion getFromString() {
        return getFromString(System.getProperty("os.version"));
    }

    /**
     * Gets OSXVersion from string
     * Will detect "10.11.*" if parameter search is is "10.11"
     *
     * @param search Can either be version or display name ("10.10", "yosemite")
     * @return
     */
    public static OSXVersion getFromString(String search) {
        for (OSXVersion v : OSXVersion.values()) {
            if (search.startsWith(v.getVersion()) || v.getDisplay().toLowerCase().contains(search.toLowerCase())) {
                return v;
            }
        }

        return null;
    }

    public static OSXVersion getExact(String display, String version) {
        for (OSXVersion v : OSXVersion.values()) {
            if (v.getDisplay().equals(display) && v.getVersion().equals(version)) {
                return v;
            }
        }

        return null;
    }

    @Override
    public boolean isNewer(Enum<?> e) {
        return e.ordinal() > this.ordinal();
    }

    @Override
    public boolean isOlder(Enum<?> e) {
        return e.ordinal() < this.ordinal();
    }
}
