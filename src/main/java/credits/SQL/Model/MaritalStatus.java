package credits.SQL.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MaritalStatus {
    MARRIED("Zamężny/Zamężna"),
    WIDOWED("Wdowiec/Wdowa"),
    SEPARATED("W Separacji"),
    DIVORCED("Rozwodnik/Rozwódka"),
    SINGLE("Wolny/Wolna");

    private final String status;

    public static String[] getStatues() {
        List<String> collect = Arrays.stream(MaritalStatus.values()).map(item -> item.status).collect(Collectors.toList());
        String[] statuses = new String[collect.size()];
        collect.toArray(statuses);
        return statuses;
    }

    MaritalStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
