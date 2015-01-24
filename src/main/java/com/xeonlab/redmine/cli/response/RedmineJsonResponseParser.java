package com.xeonlab.redmine.cli.response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
