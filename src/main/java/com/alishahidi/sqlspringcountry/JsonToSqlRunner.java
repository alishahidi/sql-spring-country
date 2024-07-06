package com.alishahidi.sqlspringcountry;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsonToSqlRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String jsonString = String.join("", Utils.readLines("/countries.json"));
        ObjectMapper mapper = new ObjectMapper();

        CountriesDto countries = mapper.readValue(jsonString, CountriesDto.class);
        List<String> sqls = new ArrayList<>();
        Integer id = 4;
        for (CountryDto country : countries.getCountries()) {
            sqls.add(String.format("INSERT INTO \"MED_COUNTRY\" (\"COUNTRY_ID\", \"COUNTRY_CODE\", \"COUNTRY_NAME\", \"CREATED_BY\", \"CREATION_TIME\", \"LAST_UPDATE_TIME\", \"LAST_UPDATED_BY\", \"LOGICALLY_DELETED\") VALUES ('%d', '%d', '%s', 'root', TO_TIMESTAMP('2023-09-18 11:40:56.976000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP('2023-09-18 11:41:10.704000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), NULL, '0');", id, id, country.getName()));
            id++;
        }

        Utils.writeLines("countries-sql.sql", sqls);
    }
}
