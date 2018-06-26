package nu.redpois0n.oslib.linux;

import java.io.File;

public class FileExistsType extends SearchType {

    private final File file;

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
