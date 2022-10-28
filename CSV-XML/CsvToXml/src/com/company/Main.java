package com.company;
import com.csvreader.CsvReader;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static com.company.MapToXml.createXml;


public class Main {

    public static void main(String[] args) throws TemplateException {

        try {

            Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("input.csv").toURI()));
            CsvReader input = new CsvReader(reader);
            input.readHeaders();

            HashMap<String, Contact> csvtoxml = new HashMap<>();

            while (input.readRecord()){

                String username = input.get("username");
                String firstname = input.get("firstname");
                String lastname = input.get("lastname");
                String email = input.get("email");
                String role = input.get("role");
                List<String> roller = new ArrayList<>();
                roller.add(role);

                if (csvtoxml.containsKey(username)) {
                    csvtoxml.get(username).addRole(role);
                } else {
                    Contact contact = new Contact(username, firstname, lastname, email, roller);
                    csvtoxml.put(username, contact);
                }
            }

            input.close();
            createXml(csvtoxml);

        } catch (URISyntaxException | CsvReader.CatastrophicException | CsvReader.FinalizedException | IOException e) {
            e.printStackTrace();
        }
    }
}




