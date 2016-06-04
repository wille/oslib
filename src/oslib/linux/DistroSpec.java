package oslib.linux;

import java.io.Serializable;


public class DistroSpec implements Serializable {
	
	private static final long serialVersionUID = 6006116784555675971L;
	
	private Distro d;
	private String release;
	private String codename;
	
	public DistroSpec(Distro d) {
		this.d = d;
	}
	
	public Distro getDistro() {
		return d;
	}
	
	public String getCodename() {
		return this.codename;
	}
	
	public void setCodename(String codename) {
		this.codename = codename;
	}
	
	public String getRelease() {
		return this.release;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}

}
