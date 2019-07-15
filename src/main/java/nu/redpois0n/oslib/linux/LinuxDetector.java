package nu.redpois0n.oslib.linux;

import nu.redpois0n.oslib.Arch;
import nu.redpois0n.oslib.OperatingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LinuxDetector {

    public static boolean detect(boolean fallback) {
        if (fallback) {
            return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.LINUX.getPrimarySearch());
        }

        return false;
    }

    public static Arch getLinuxArch() {
        InputStream is = null;
        try {
            final Process process = Runtime.getRuntime().exec(new String[]{"uname", "-m"});
            is = process.getInputStream();
            return Arch.getArch(convert(is));
        } catch (IOException exception) {
            return Arch.getArch(System.getProperty("os.arch"));
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String convert(InputStream inputStream) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        return stringBuilder.toString();
    }
}
