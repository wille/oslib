package oslib.windows;

import java.io.Serializable;

import oslib.AbstractOperatingSystem;
import oslib.Arch;
import oslib.OperatingSystem;

public class WindowsOperatingSystem extends AbstractOperatingSystem implements Serializable {

	private static final long serialVersionUID = 3629947448937163693L;
	
	private WindowsVersion version;
	
	public WindowsOperatingSystem() {
		this(WindowsVersion.getFromString(), Arch.getArch());
	}
	
	public WindowsOperatingSystem(String name, Arch arch) {
		this(WindowsVersion.getFromString(name), arch);
	}
	
	public WindowsOperatingSystem(String name) {
		this(WindowsVersion.getFromString(name), Arch.getArch());
	}
	
	public WindowsOperatingSystem(WindowsVersion version, Arch arch) {
		super(OperatingSystem.WINDOWS, arch);
		this.version = version;
	}
	
	public WindowsOperatingSystem(WindowsVersion version) {
		this(version, Arch.getArch());
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
