package nu.redpois0n.oslib.windows;

import nu.redpois0n.oslib.OperatingSystem;

public class WindowsDetector {

    public static boolean detect(boolean fallback) {
        if (fallback) {
            return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.WINDOWS.getPrimarySearch());
        }

        return false;
    }

}
