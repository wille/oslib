package com.redpois0n.oslib;

import com.redpois0n.oslib.distro.CommandContainsType;
import com.redpois0n.oslib.distro.FileContainsType;
import com.redpois0n.oslib.distro.FileExistsType;

public enum Distro {
	
	ALPINE("Alpine Linux", "alpine"),
	ARCH_LINUX("Arch Linux", "archlinux"),
	CHAKRA("Chakra"),
	CENTOS("CentOS", new FileExistsType("/etc/centos-release")),
	DEBIAN("Debian"),
	CRUNCHBANG("Crunchbang", new FileExistsType("/etc/crunchbang-lsb-release"), new FileExistsType("/etc/lsb-release-crunchbang")),
	RASPBIAN("Raspbian", new FileContainsType("/etc/os-release", "Raspbian")),
	ELEMENTARY_OS("elementary OS", "elementary"),
	EVOLVE_OS("EvolveOS"),
	KAOS("KaOS", "kaos"),
	FEDORA("Fedora"),
	FRUGALWARE("Frugalware"),
	FUNTOO("Funtoo", new CommandContainsType(new String[] { "lsb_release", "-sd" }, "funtoo")),
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
	SLACKWARE("Slackware"),
	SOLUSOS("SolusOS"),
	STEAMOS("SteamOS", "steam"),
	TRISQUEL("Trisquel"),
	UBUNTU("Ubuntu"),
	VIPERR("Viperr"),
	UNKNOWN("");
	
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

}
