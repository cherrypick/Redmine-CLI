package com.xeonlab.redmine.cli.response;

import org.json.JSONObject;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-23
 */
final public class EnumeratedValue {
    private int id;
    private String name;

    public EnumeratedValue(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EnumeratedValue() {
    }

    public EnumeratedValue(JSONObject values) {
        this.id = values.getInt("id");
        if (values.has("name")) {
            this.name = values.getString("name");
        }
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}
