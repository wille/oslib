package oslib;

import java.io.Serializable;


public abstract class AbstractOperatingSystem implements Serializable {

	private static final long serialVersionUID = 7993846066826992068L;
	
	protected OperatingSystem type;
	protected Arch arch;
	protected DesktopEnvironment de;

	public AbstractOperatingSystem(OperatingSystem type, Arch arch) {
		this.type = type;
		this.arch = arch;
	}
	
	public OperatingSystem getType() {
		return this.type;
	}
	
	public Arch getArch() {
		return this.arch;
	}
	
	public void setArch(Arch arch) {
		this.arch = arch;
	}
	
	public DesktopEnvironment getDesktopEnvironment() {
		if (de == null) {
			de = DEDetector.detect();
		}
		
		return de;
	}
	
	public void setDesktopEnvironment(DesktopEnvironment de) {
		this.de = de;
	}
	
	/**
	 * Returns display string
	 * @return
	 */
	public abstract String getDisplayString();
	
	/**
	 * Returns detailed string
	 * @return
	 */
	public abstract String getDetailedString();
	
	public final boolean isUnix() {
		return type == OperatingSystem.BSD || type == OperatingSystem.OSX || type == OperatingSystem.LINUX || type == OperatingSystem.SOLARIS;
	}

}
