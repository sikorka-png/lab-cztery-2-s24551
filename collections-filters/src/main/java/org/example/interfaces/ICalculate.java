package org.example.interfaces;

import org.example.model.Person;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;

import java.util.List;

public interface ICalculate {
    double calculate(FunctionsParameters fp, List<Person> data);
}
