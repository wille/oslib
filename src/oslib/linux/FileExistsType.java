package oslib.linux;

import java.io.File;

public class FileExistsType extends SearchType {
	
	private File file;
	
	public FileExistsType(String file) {
		this(new File(file));
	}
	
	public FileExistsType(File file) {
		this.file = file;
	}

	@Override
	public boolean detect() {
		return file.exists();
	}

}
