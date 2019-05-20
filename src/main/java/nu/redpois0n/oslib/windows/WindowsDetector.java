package nu.redpois0n.oslib.windows;

import nu.redpois0n.oslib.Arch;
import nu.redpois0n.oslib.OperatingSystem;

public class WindowsDetector {

    public static boolean detect(boolean fallback) {
        if (fallback) {
            return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.WINDOWS.getPrimarySearch());
        }

        return false;
    }

    public static Arch getArchWindows() {
        if (System.getenv("ProgramFiles(x86)") != null) {
            return Arch.x86_64;
        }

        return Arch.getArch(System.getProperty("os.arch"));
    }

}
