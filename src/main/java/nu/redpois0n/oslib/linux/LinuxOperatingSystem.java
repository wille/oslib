package nu.redpois0n.oslib.linux;

import nu.redpois0n.oslib.Arch;
import nu.redpois0n.oslib.OperatingSystem;
import nu.redpois0n.oslib.UnixOperatingSystem;

import java.io.Serializable;

public class LinuxOperatingSystem extends UnixOperatingSystem implements Serializable {

    private static final long serialVersionUID = -1997336870542013705L;

    private final DistroSpec ds;

    public LinuxOperatingSystem(Distro d) {
        this(new DistroSpec(d), LinuxDetector.getArchLinux());
    }

    public LinuxOperatingSystem(DistroSpec ds, Arch arch) {
        super(OperatingSystem.LINUX, arch);
        this.ds = ds;
    }

    public LinuxOperatingSystem() {
        this(Distro.getLocalDistroSpec(), LinuxDetector.getArchLinux());
    }

    public LinuxOperatingSystem(DistroSpec ds) {
        this(ds, LinuxDetector.getArchLinux());
    }

    public Distro getDistro() {
        return this.ds.getDistro();
    }

    public DistroSpec getDistroSpec() {
        return this.ds;
    }

    @Override
    public String getDisplayString() {
        Distro d = ds.getDistro();

        String name = d.getDisplayString();

        if (ds.getRelease() != null) {
            name += " " + ds.getRelease();
        }

        return name;
    }

}
