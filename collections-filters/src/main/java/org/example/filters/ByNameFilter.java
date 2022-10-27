package org.example.filters;

import org.example.interfaces.IFilterPeople;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class ByNameFilter implements IFilterPeople {

    private SearchParameters searchParameters;

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean canFilter() {
        if(searchParameters == null || searchParameters.getName() == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<Person> filter(List<Person> sampleData) {
        return sampleData.stream()
                .filter(person -> person.getName().equals(searchParameters.getName()))
                .collect(Collectors.toList());
    }
}
