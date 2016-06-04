package oslib.linux;

import oslib.UnsupportedOperatingSystemException;

public enum Distro {
	
	ALPINE("Alpine Linux", "alpine", new FileExistsType("/etc/arch-release")),
	ANTERGOS("Antergos"),
	ARCH_LINUX("Arch Linux", "archlinux", "archarm"),
	BLAG("BLAG"),
	CHAKRA("Chakra", new FileExistsType("/etc/chakra-release")),
	CENTOS("CentOS", new FileExistsType("/etc/centos-release"), new FileContainsType("/etc/redhat-release", "CentOS")),
	CRUNCHBANG("Crunchbang", new FileExistsType("/etc/crunchbang-lsb-release"), new FileExistsType("/etc/lsb-release-crunchbang")),
	DEBIAN("Debian"),
	RASPBIAN("Raspbian", new FileContainsType("/etc/os-release", "Raspbian")),
	ELEMENTARY_OS("elementary OS", "elementary"),
	EVOLVE_OS("Evolve OS", "EvolveOS", new FileExistsType("/etc/evolveos-release")),
	KAOS("KaOS", "kaos"),
	FEDORA("Fedora", new FileContainsType("/etc/fedora-release", "fedora")),
	FRUGALWARE("Frugalware"),
	FUNTOO("Funtoo", new FileContainsType("/etc/gentoo-release", "funtoo"), new CommandContainsType(new String[] { "lsb_release", "-sd" }, "funtoo")),
	GENTOO("Gentoo", new FileContainsType("/etc/gentoo-release", "gentoo")),
	JIYUU("Jiyuu", "Jiyuu"),
	DEEPIN("Deepin", "LinuxDeepin", new FileContainsType("/etc/issue/", "LinuxDeepin")),
	KALI("Kali Linux", "Kali", "Debian Kali Linux"),
	KORORA("Korora", new FileContainsType("/etc/fedora-release", "korora")),
	MAGEIA("Mageia", new FileExistsType("/etc/mageia-release")),
	MANDRIVA("Mandriva", "MandrivaLinux", new FileExistsType("/etc/mandriva-release")),
	MANDRAKE("Mandrake", new FileExistsType("/etc/mandrake-release")),
	MANJARO("Manjaro", "ManjaroLinux"),
	MINT("Linux Mint", "LinuxMint", "mint"),
	NIXOS("NixOS", new FileExistsType("/etc/NIXOS")),
	LMDE("LMDE"),
	LUNAR("Lunar Linux", "Lunar"),
	OPENSUSE("openSUSE", "SUSE LINUX", "openSUSE project", new FileExistsType("/etc/SuSE-release")),
	PARABOLA("Parabola", "Parabola GNU/Linux-libre", new FileContainsType("/etc/issue", "Parabola GNU/Linux-libre")),
	PEPPERMINT("Peppermint"),
	REDHAT_ENTERPRISE("Redhat Enterprise", "RedHatEnterprise", new FileContainsType("/etc/redhat-release", "Red Hat")),
	SABAYON("Sabayon", new FileExistsType("/etc/sabayon-edition")),
	SCIENTIFICLINUX("Scientific Linux", new FileContainsType("/etc/system-release", "Scientific Linux")),
	SLACKWARE("Slackware", new FileExistsType("/etc/slackware-version")),
	SOLUSOS("SolusOS", new FileContainsType("/etc/issue", "SolusOS")),
	STEAMOS("SteamOS", "steam"),
	TINYCORE("TinyCore", new FileExistsType("/usr/share/doc/tc/release.txt")),
	TRISQUEL("Trisquel"),
	UBUNTU("Ubuntu"),
	VIPERR("Viperr"),
	CRUX("Crux", new CommandExistsType("crux")),
	GNEWSENSE("gNewSense", new FileContainsType("/etc/issue", "gNewSense")),
	DRAGORA("Dragora", new FileExistsType("/etc/dragora-version")),
	CHAPEAU("Chapeau"),
	KDE_NEON("neon", "KDE neon"),
	ORACLE_LINUX("Oracle Linux", "ol", "Ol", new FileExistsType("/etc/oracle-release"), new FileContainsType("/etc/system-release", "Oracle Linux")),
	QUBES("Qubes", new FileExistsType("/etc/qubes-rpc")),
	UNKNOWN("Unknown");
	
	private String name;
	private Object[] searchTypes;
	
	private Distro(String name, Object... s) {
		this.name = name;
		this.searchTypes = s;
	}
	
	public Object[] getSearchTypes() {
		return this.searchTypes;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayString() {
		if (this == UNKNOWN) {
			return "Unknown Linux";
		} else if (!name.toLowerCase().contains("linux")) {
			return name + " Linux";
		}
		
		return name;
	}
	
	public static Distro getDistroFromName(String s) {
		for (Distro d : values()) {
			if (d.getName().equalsIgnoreCase(s)) {
				return d;
			}
		}
		
		return Distro.UNKNOWN;
	}
	
	public static Distro getDistroFromString(String s) {
		for (Distro d : values()) {
			if (d.getName().equalsIgnoreCase(s)) {
				return d;
			}
			
			for (Object o : d.getSearchTypes()) {
				if (o instanceof String) {
					String s1 = (String) o;
					
					if (s1.contains(s)) {
						return d;
					}
				}
			}
		}
		
		return Distro.UNKNOWN;
	}
	
	public static Distro getLocalDistro() throws UnsupportedOperatingSystemException {
		return DistroDetector.detect().getDistro();
	}
	
	public static DistroSpec getLocalDistroSpec() throws UnsupportedOperatingSystemException {
		return DistroDetector.detect();
	}

}
