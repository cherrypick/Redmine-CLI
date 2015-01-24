package com.xeonlab.redmine.cli.response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-23
 */
public class RedmineJsonResponseParser implements ResponseParser {

    private final ObjectMapper mapper;

    public RedmineJsonResponseParser() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    @Override
    public Response parse(Reader reader) {
        try {
            return mapper.readValue(reader, Response.class);
        } catch (IOException e) {
            System.err.println("Could not parse json!");
            e.printStackTrace();
            System.exit(3);
            return null;
        }
    }
}
