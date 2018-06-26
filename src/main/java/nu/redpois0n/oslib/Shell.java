package nu.redpois0n.oslib;

import java.io.File;

public enum Shell {

    COMMAND_PROMPT("cmd"),
    TCSH("/bin/tcsh"),
    BASH("/bin/bash"),
    DEFAULT("/bin/sh");

    private final String path;

    Shell(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    /**
     * Gets default shell for this operating system
     */
    public static Shell getShell() {
        return getShell(OperatingSystem.getOperatingSystem());
    }

    /**
     * Gets shell from operating system
     *
     * @param os the os to check for
     *
     * @return Default shell, or /bin/sh if not found
     */
    public static Shell getShell(AbstractOperatingSystem os) {
        Shell shell;

        if (os.getType() == OperatingSystem.WINDOWS) {
            shell = COMMAND_PROMPT;
        } else if (os.getType() == OperatingSystem.BSD) {
            shell = TCSH;
        } else {
            shell = BASH;
        }

        if (os.getType() != OperatingSystem.WINDOWS) {
            File file = new File(shell.getPath());

            if (!file.exists()) {
                shell = DEFAULT;
            }
        }

        return shell;
    }

}
