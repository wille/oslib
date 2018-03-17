package nu.redpois0n.oslib.linux;

import nu.redpois0n.oslib.OperatingSystem;

public class LinuxDetector {

    public static boolean detect(boolean fallback) {
        if (fallback) {
            return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.LINUX.getPrimarySearch());
        }

        return false;
    }

}
