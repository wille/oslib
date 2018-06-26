package nu.redpois0n.oslib.linux;

import nu.redpois0n.oslib.Utils;

import java.util.List;

public class CommandContainsType extends SearchType {

    private final String[] cmd;
    private final String needle;

    public CommandContainsType(String[] cmd, String needle) {
        this.cmd = cmd;
        this.needle = needle;
    }

    @Override
    public boolean detect() {
        try {
            List<String> raw = Utils.readProcess(cmd);

            for (String line : raw) {
                if (line.toLowerCase().contains(needle.toLowerCase())) {
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
