package oslib;


public abstract class UnixOperatingSystem extends AbstractOperatingSystem {

	private String detailed;
	
	public UnixOperatingSystem(OperatingSystem os, Arch arch) {
		super(os, arch);
	}

	@Override
	public String getDetailedString() {
		return detailed == null ? getDisplayString() : detailed;
	}
	
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

}
