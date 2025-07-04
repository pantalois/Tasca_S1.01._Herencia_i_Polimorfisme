package TascaS1_01.Exercici_1;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Company {
    public Map<Editor, List<News>> companyStruct;

    public Company() {
        this.companyStruct = new HashMap<>();
    }

    public Map<Editor, List<News>> getCompanyStruct() {
        return companyStruct;
    }

    public Set<Editor> getEditors() {
        return companyStruct.keySet();
    }

    public Collection<List<News>> getAllNewsLists() {
        return companyStruct.values();
    }

    @Override
    public String toString() {
        return companyStruct.toString();
    }
}
