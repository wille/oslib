package nu.redpois0n.oslib;

import nu.redpois0n.oslib.bsd.BSDOperatingSystem;
import nu.redpois0n.oslib.bsd.Flavor;
import nu.redpois0n.oslib.bsd.FlavorDetector;
import nu.redpois0n.oslib.linux.DistroDetector;
import nu.redpois0n.oslib.linux.LinuxDetector;
import nu.redpois0n.oslib.linux.LinuxOperatingSystem;
import nu.redpois0n.oslib.macos.MacOSDetector;
import nu.redpois0n.oslib.macos.MacOSOperatingSystem;
import nu.redpois0n.oslib.solaris.SolarisDetector;
import nu.redpois0n.oslib.solaris.SolarisOperatingSystem;
import nu.redpois0n.oslib.windows.WindowsDetector;
import nu.redpois0n.oslib.windows.WindowsOperatingSystem;

public enum OperatingSystem {

    WINDOWS("Windows", "win"),
    MACOS("macOS", "mac"),
    LINUX("Linux", "linux"),
    SOLARIS("Solaris", "solaris", "sunos"),
    BSD("BSD"),
    UNKNOWN("unknown", "unknown");

    private static AbstractOperatingSystem cache;

    private final String name;
    private final String[] search;

    OperatingSystem(String name, String... search) {
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

    /**
     * Gets the operating system (Not linux distro)
     */
    public static OperatingSystem getOperatingSystem(String str) {
        str = str.toLowerCase();

        OperatingSystem os = null;

        for (OperatingSystem o : OperatingSystem.values()) {
            if (os != null) {
                break;
            }

            if (o.getName().equalsIgnoreCase(str)) {
                os = o;
                break;
            }

            for (String s : o.getSearch()) {
                if (str.contains(s)) {
                    os = o;
                    break;
                }
            }
        }

        return os;
    }

    public static AbstractOperatingSystem getOperatingSystem() {
        return getOperatingSystem(true);
    }

    /**
     * Gets this machines operating system
     */
    public static AbstractOperatingSystem getOperatingSystem(boolean b) {
        AbstractOperatingSystem os = null;

        if (cache == null) {
            Flavor flavor = FlavorDetector.detect(b);

            if (flavor != null) {
                os = new BSDOperatingSystem(flavor);
            }

            if (LinuxDetector.detect(b)) {
                os = new LinuxOperatingSystem(DistroDetector.detect());
            }

            if (MacOSDetector.detect(b)) {
                os = new MacOSOperatingSystem();
            }

            if (WindowsDetector.detect(b)) {
                os = new WindowsOperatingSystem();
            }

            if (SolarisDetector.detect(b)) {
                os = new SolarisOperatingSystem();
            }

            if (os == null) {
                os = new UnknownOperatingSystem();
            }

            if (os instanceof UnixOperatingSystem) {
                UnixOperatingSystem uos = (UnixOperatingSystem) os;
                uos.setDetailed(Utils.getUname());
            }
            cache = os;
        } else {
            os = cache;
        }

        return os;
    }

    /**
     * Forces reloading of data next time retreiving operating system
     */
    public static void clearCache() {
        cache = null;
    }

    public static boolean isUnix() {
        return isUnix(getOperatingSystem().getType());
    }

    public static boolean isUnix(OperatingSystem os) {
        return os == BSD || os == MACOS || os == LINUX || os == SOLARIS;
    }

}
