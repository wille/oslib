package oslib.macos;

import java.io.Serializable;

import oslib.Arch;
import oslib.OperatingSystem;
import oslib.UnixOperatingSystem;

public class MacOSOperatingSystem extends UnixOperatingSystem implements Serializable {

	private static final long serialVersionUID = 1929142018487788734L;
	
	private MacOSVersion version;
	
	public MacOSOperatingSystem() {
		this(MacOSVersion.getFromString());
	}
	
	public MacOSOperatingSystem(MacOSVersion version, Arch arch) {
		super(OperatingSystem.MACOS, arch);
		this.version = version;
	}
	
	public MacOSOperatingSystem(MacOSVersion version) {
		this(version, Arch.getArch());
	}
	
	public void setVersion(MacOSVersion version) {
		this.version = version;
	}

	public MacOSVersion getVersion() {
		return this.version;
	}

	@Override
	public String getDisplayString() {
		String display;

		if (version.isOSX()) {
			display = "Mac OS X";
		} else {
			display = "macOS";
		}

		if (version != null) {
			if (version.getDisplay() != null) {
				display += " " + version.getDisplay();
			}

			if (version.getVersion() != null) {
				display += " " + version.getVersion();
			}
		}

		return display;
	}

	@Override
	public String getDetailedString() {
		return this.getDisplayString();
	}

}
