package com.alishahidi.sqlspringcountry;

import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class Utils {

    public List<String> readLines(String resourcePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(SqlSpringCountryApplication.class.getResourceAsStream(resourcePath))))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLines(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
