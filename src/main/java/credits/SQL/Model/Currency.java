package credits.SQL.Model;

public class Currency {
    private final int id;
    private final String shortName;
    private final String name;

    public Currency(int id, String shortName, String name) {
        this.id = id;
        this.shortName = shortName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
