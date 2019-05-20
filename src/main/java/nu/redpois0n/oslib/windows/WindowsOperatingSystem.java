package nu.redpois0n.oslib.windows;

import nu.redpois0n.oslib.AbstractOperatingSystem;
import nu.redpois0n.oslib.Arch;
import nu.redpois0n.oslib.OperatingSystem;

import java.io.Serializable;

public class WindowsOperatingSystem extends AbstractOperatingSystem implements Serializable {

    private static final long serialVersionUID = 3629947448937163693L;

    private final WindowsVersion version;

    public WindowsOperatingSystem() {
        this(WindowsVersion.getFromString(), WindowsDetector.getArchWindows());
    }

    public WindowsOperatingSystem(String name, Arch arch) {
        this(WindowsVersion.getFromString(name), arch);
    }

    public WindowsOperatingSystem(String name) {
        this(WindowsVersion.getFromString(name), WindowsDetector.getArchWindows());
    }

    public WindowsOperatingSystem(WindowsVersion version, Arch arch) {
        super(OperatingSystem.WINDOWS, arch);
        this.version = version;
    }

    public WindowsOperatingSystem(WindowsVersion version) {
        this(version, WindowsDetector.getArchWindows());
    }

    public WindowsVersion getVersion() {
        return this.version;
    }

    @Override
    public String getDisplayString() {
        return version.getSearch();
    }

    @Override
    public String getDetailedString() {
        return version.getSearch();
    }

}
