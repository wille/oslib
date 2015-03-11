package com.redpois0n.oslib;

public enum Distro {
	
	ARCH_LINUX("Arch Linux", "archlinux"),
	CHAKRA("Chakra"),
	CENTOS("CentOS"),
	DEBIAN("Debian"),
	CRUNCHBANG("Crunchbang", "file:/etc/crunchbang-lsb-release", "file:/etc/lsb-release-crunchbang"),
	RASBIAN("Raspbian", "fcontains:/etc/os-release=Raspbian"),
	ELEMENTARY_OS("elementary OS", "elementary"),
	EVOLVE_OS("EvolveOS"),
	KAOS("KaOS", "kaos"),
	FEDORA("Fedora"),
	FRUGALWARE("Frugalware"),
	FUNTOO("Funtoo", "ccontains:lsb_release -sd=funtoo"),
	GENTOO("Gentoo"),
	JIYUU("Jiyuu", "Jiyuu Linux"),
	DEEPIN("Deepin", "LinuxDeepin"),
	KALI("Kali", "Debian Kali Linux"),
	KORORA("Korora"),
	MAGEIA("Mageia"),
	MANDRIVA("Mandriva", "MandrivaLinux"),
	MANJARO("Manjaro", "ManjaroLinux"),
	MINT("Mint", "LinuxMint"),
	LMDE("Mint Debian", "codename:debian"),
	OPENSUSE("openSUSE", "SUSE LINUX", "openSUSE project"),
	PARABOLA("Parabola", "Parabola GNU/Linux-libre"),
	PEPPERMINT("Peppermint"),
	REDHAT_ENTERPRISE("Redhat Enterprise", "RedHatEnterprise"),
	SABAYON("Sabayon"),
	SOLUSOS("SolusOS"),
	TRISQUEL("Trisquel"),
	UBUNTU("Ubuntu"),
	VIPERR("Viperr"),
	
	UBUNTU("ubuntu"),
	KALI("kali"),
	BACKTRACK("backtrack"),
	CENTOS("centos"),
	DEBIAN("debian"),
	ELEMENTARYOS("elementary os"),
	MINT("mint"),
	SLACKWARE("slackware"),
	GENTOO("gentoo"),
	RASPBIAN("raspbian"),
	STEAMOS("steam"),
	FEDORA("fedora"),
	CRUNCHBANG("crunchbang"),
	LXLE("lxle"),
	MAGEIA("mageia"),
	ALPINE("alpine"),
	UNKNOWN("");
	
	private String name;
	private Object[] s;
	
	private Distro(String name, Object... s) {
		this.name = name;
		this.s = s;
	}
	
	public Object[] getIdentifier() {
		return this.s;
	}
	
	public Object getPrimaryIdentifier() {
		return this.s[0];
	}
	
	public String getName() {
		return this.name;
	}

	/**
	 * Gets this machine linux distro
	 * @return
	 */
	public static Distro getDistro() {
		return getDistro(OperatingSystem.getShortOperatingSystem());
	}

	/**
	 * Returns linux distro found from search string
	 * @return Distro.UNKNOWN if no known distro is found, null if not even Linux is detected from search
	 */
	public static Distro getDistro(String search) {
		Distro distro;
		
		for (Distro d : Distro.values()) {
			if (search.toLowerCase().contains(d.getIdentifier())) {
				return d;
			}
		}
		
		if (OperatingSystem.getOperatingSystem(search) != OperatingSystem.LINUX) {
			distro = null;
		} else {
			distro = UNKNOWN;
		}
		
		return distro;
	}
	
}
