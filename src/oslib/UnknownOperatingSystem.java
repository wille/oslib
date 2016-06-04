package oslib;

public class UnknownOperatingSystem extends AbstractOperatingSystem {
	
	public UnknownOperatingSystem(Arch arch) {
		super(OperatingSystem.UNKNOWN, arch);
	}
	
	public UnknownOperatingSystem() {
		this(Arch.getArch());
	}

	@Override
	public String getDisplayString() {
		return "Unknown";
	}

	@Override
	public String getDetailedString() {
		return "Unknown";
	}

}
