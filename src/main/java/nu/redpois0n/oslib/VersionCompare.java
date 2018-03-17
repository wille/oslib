package nu.redpois0n.oslib;

public interface VersionCompare {

    /**
     * Checks if current version is newer than e
     */
    boolean isNewer(Enum<?> e);

    /**
     * Checks if current version is older than e
     */
    boolean isOlder(Enum<?> e);

}
