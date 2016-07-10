package oslib.osx;

import java.io.Serializable;

import oslib.Arch;
import oslib.OperatingSystem;
import oslib.UnixOperatingSystem;

public class OSXOperatingSystem extends UnixOperatingSystem implements Serializable {

	private static final long serialVersionUID = 1929142018487788734L;
	
	private OSXVersion version;
	
	public OSXOperatingSystem() {
		this(OSXVersion.getFromString());
	}
	
	public OSXOperatingSystem(OSXVersion version, Arch arch) {
		super(OperatingSystem.OSX, arch);
		this.version = version;
	}
	
	public OSXOperatingSystem(OSXVersion version) {
		this(version, Arch.getArch());
	}
	
	public void setVersion(OSXVersion version) {
		this.version = version;
	}

	public OSXVersion getVersion() {
		return this.version;
	}

	@Override
	public String getDisplayString() {
		String s = "Mac OS X";

		if (version != null) {
			if (version.getDisplay() != null) {
				s += " " + version.getDisplay();
			}

			if (version.getVersion() != null) {
				s += " " + version.getVersion();
			}
		}

		return s;
	}

	@Override
	public String getDetailedString() {
		return this.getDisplayString();
	}

}
