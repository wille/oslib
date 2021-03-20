package nu.redpois0n.oslib;

public enum Arch {

    x86("x86", "i386", "i486", "i586", "i686"),
    x86_64("x86_64", "amd64", "k8"),
    ARM("ARM", "arm64"),
    UNKNOWN("Unknown");

    private final String[] search;

    Arch(String... search) {
        this.search = search;
    }

    public String getName() {
        return search[0];
    }

    public String[] getSearch() {
        return search;
    }

    /**
     * Gets arch, either 64-bit or x86
     */
    public static Arch getArch(String s) {
        for (Arch arch : Arch.values()) {
            for (String search : arch.getSearch()) {
                if (s.equalsIgnoreCase(search)) {
                    return arch;
                }
            }
        }

        return Arch.UNKNOWN;
    }

    /**
     * Gets this machines arch
     */
    public static Arch getArch() {
        return getArch(getArchString());
    }

    /**
     * Same as System.getProperty("os.arch");
     */
    public static String getArchString() {
        return System.getProperty("os.arch");
    }

}
