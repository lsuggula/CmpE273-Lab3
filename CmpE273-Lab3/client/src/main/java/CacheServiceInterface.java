public interface CacheSInterface {
    public String get(long key);

    public void put(long key, String value);

    public String getServerURL();
}
