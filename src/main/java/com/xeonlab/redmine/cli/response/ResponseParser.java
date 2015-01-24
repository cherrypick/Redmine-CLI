package com.xeonlab.redmine.cli.response;

import java.io.Reader;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-24
 */
public interface ResponseParser {
    Response parse(Reader reader);
}
