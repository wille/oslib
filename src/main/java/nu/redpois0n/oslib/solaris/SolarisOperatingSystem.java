package nu.redpois0n.oslib.solaris;

import nu.redpois0n.oslib.Arch;
import nu.redpois0n.oslib.OperatingSystem;
import nu.redpois0n.oslib.UnixOperatingSystem;

import java.io.Serializable;

public class SolarisOperatingSystem extends UnixOperatingSystem implements Serializable {

    private static final long serialVersionUID = -9050140134144959153L;

    public SolarisOperatingSystem() {
        this(Arch.getArch());
    }

    public SolarisOperatingSystem(Arch arch) {
        super(OperatingSystem.SOLARIS, arch);
    }

    @Override
    public String getDisplayString() {
        return "Solaris";
    }

}
