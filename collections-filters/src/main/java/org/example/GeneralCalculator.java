package org.example;

import org.example.interfaces.ICalculate;
import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GeneralCalculator implements ICalculate {
    String name;
    Function<Person, Number> function;

    public GeneralCalculator(String name, Function<Person, Number> function) {
        this.name = name;
        this.function = function;
    }

    @Override
    public double calculate(FunctionsParameters fp, List<Person> data) {
        if (name.equals(fp.getFieldName())) {
            data.stream()
                    .map(function)
                    .collect(Collectors.toList());
                    .summaryStatistics();
        }
        return 0;
    }
}
