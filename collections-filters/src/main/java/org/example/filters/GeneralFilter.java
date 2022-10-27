package org.example.filters;

import org.example.interfaces.IFilterPeople;
import org.example.interfaces.MyPredicate;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GeneralFilter implements IFilterPeople {

    Predicate<SearchParameters> predicate;
    MyPredicate<SearchParameters, Person> myPredicate;
    SearchParameters searchParameters;


    public GeneralFilter(Predicate<SearchParameters> predicate, MyPredicate<SearchParameters, Person> myPredicate) {
        this.predicate = predicate;
        this.myPredicate = myPredicate;
    }

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean canFilter() {
        return predicate.test(searchParameters);
    }

    @Override
    public List<Person> filter(List<Person> sampleData) {
        return sampleData.stream()
                .filter(person -> myPredicate.test(searchParameters, person))
                .collect(Collectors.toList());
    }
}
