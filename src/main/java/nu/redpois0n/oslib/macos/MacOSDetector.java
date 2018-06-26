package nu.redpois0n.oslib.macos;

import nu.redpois0n.oslib.OperatingSystem;
import nu.redpois0n.oslib.Utils;

import java.io.File;
import java.util.List;

public class MacOSDetector {

    public static boolean detect(boolean fallback) {
        File file = new File("/usr/bin/sw_vers");

        try {
            List<String> lines = Utils.readFile(file);

            for (String line : lines) {
                if (line.contains(OperatingSystem.MACOS.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fallback) {
            String os = System.getProperty("os.name").toLowerCase();

            return os.contains("mac os x") || os.contains("macos");
        }

        return false;
    }

}
