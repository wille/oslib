package nu.redpois0n.oslib;

import nu.redpois0n.oslib.bsd.BSDOperatingSystem;
import nu.redpois0n.oslib.linux.DistroSpec;
import nu.redpois0n.oslib.linux.LinuxOperatingSystem;
import nu.redpois0n.oslib.macos.MacOSOperatingSystem;
import nu.redpois0n.oslib.solaris.SolarisOperatingSystem;
import nu.redpois0n.oslib.windows.WindowsOperatingSystem;

public class Debug {

    public static void main(String[] args) {
        AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();

        String display = os.getDisplayString();
        String detailed = os.getDetailedString();

        System.out.println("Type: " + os.getType().name());

        if (os.getType() == OperatingSystem.WINDOWS) {
            WindowsOperatingSystem wos = (WindowsOperatingSystem) os;

            System.out.println("Windows Version: " + wos.getVersion().getSearch());
        } else if (os.getType() == OperatingSystem.MACOS) {
            MacOSOperatingSystem xos = (MacOSOperatingSystem) os;

            System.out.println("macOS Version: " + xos.getVersion().getDisplay() + ", " + xos.getVersion()
                                                                                             .getVersion());
        } else if (os.getType() == OperatingSystem.LINUX) {
            LinuxOperatingSystem los = (LinuxOperatingSystem) os;

            DistroSpec d = los.getDistroSpec();

            System.out.println("Distro: " + d.getDistro().getDisplayString());
            System.out.println("Codename: " + d.getCodename());
            System.out.println("Release: " + d.getRelease());
        } else if (os.getType() == OperatingSystem.BSD) {
            BSDOperatingSystem bos = (BSDOperatingSystem) os;

            System.out.println("Flavor: " + bos.getFlavor().getName());
        } else if (os.getType() == OperatingSystem.SOLARIS) {
            SolarisOperatingSystem sos = (SolarisOperatingSystem) os;

        }

        System.out.println("Display: " + display);
        System.out.println("Detailed: " + detailed);
    }

}
