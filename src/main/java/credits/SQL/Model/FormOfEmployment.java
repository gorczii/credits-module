package credits.SQL.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FormOfEmployment {
    PERM_CONTRACT("Umowa o pracę"),
    FIXED_TERM_CONTRACT("Umowa o pracę na czas określony"),
    CIVIL_LAW_CONTRACT("Umowa cywilnoprawna"),
    SELF_EMPLOYED("Samozatrudnienie"),
    DISABLEMENT_PENSION("Renta"),
    PENSION("Emerytura"),
    UNEMPLOYED("Bezrobotny");

    private final String form;

    public static String[] getForms() {
        List<String> collect = Arrays.stream(FormOfEmployment.values()).map(item -> item.form).collect(Collectors.toList());
        String[] forms = new String[collect.size()];
        collect.toArray(forms);
        return forms;
    }

    FormOfEmployment(String status) {
        this.form = status;
    }

    public String getForm() {
        return form;
    }
}
