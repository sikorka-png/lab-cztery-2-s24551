package org.example;

import org.example.interfaces.ICutToPage;
import org.example.model.Person;
import org.example.queries.search.Page;

import java.util.List;
import java.util.stream.Collectors;

public class PageCutter implements ICutToPage {
    @Override
    public List<Person> cut(Page page, List<Person> data) {
        return data.stream()
                .skip((long) (page.getPageNumber() - 1) * page.getSize())
                .limit(page.getSize())
                .collect(Collectors.toList());
    }
}
