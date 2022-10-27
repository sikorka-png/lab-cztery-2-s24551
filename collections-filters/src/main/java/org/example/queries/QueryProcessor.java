package org.example.queries;

import org.example.interfaces.ICalculate;
import org.example.interfaces.ICutToPage;
import org.example.interfaces.IFilterPeople;
import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    List<IFilterPeople> filters = new ArrayList<>();
    List<ICalculate> calculators = new ArrayList<>();
    List<ICutToPage> cutters = new ArrayList<>();

    public Results GetResults(SearchParameters parameters, List<Person> data){
        Results results = new Results();

        for (IFilterPeople f: filters) {
            f.setSearchParameters(parameters);
            if (f.canFilter()) {
                data = f.filter(data);
            }
        }
        results.setItems(data);

        List<FunctionResult> functionResults = new ArrayList<>();
        for (ICalculate c: calculators) {
            for (FunctionsParameters f: parameters.getFunctions()) {
                c.calculate(f, data);
            }
        }

        for (ICutToPage c: cutters) {
            data = c.cut(parameters.getPage(), data);
        }
        System.out.println(data.size());
        return results;
    }

    public QueryProcessor addFilter(IFilterPeople newFilter) {
        filters.add(newFilter);
        return this;
    }

    public QueryProcessor addCalculation(ICalculate newCalculator) {
        calculators.add(newCalculator);
        return this;
    }

    public QueryProcessor addPageCutter(ICutToPage newCutter) {
        cutters.add(newCutter);
        return this;
    }
}
