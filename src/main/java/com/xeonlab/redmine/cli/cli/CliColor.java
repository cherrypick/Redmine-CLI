package com.xeonlab.redmine.cli.cli;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-24
 */
public enum CliColor {
    /**
     * Foreground colors
     */
    FG_BLACK("0;30"),
    FG_DARK_GRAY("1;30"),
    FG_BLUE("0;34"),
    FG_LIGHT_BLUE("1;34"),
    FG_GREEN("0;32"),
    FG_LIGHT_GREEN("1;32"),
    FG_CYAN("0;36"),
    FG_LIGHT_CYAN("1;36"),
    FG_RED("0;31"),
    FG_LIGHT_RED("1;31"),
    FG_PURPLE("0;35"),
    FG_LIGHT_PURPLE("1;35"),
    FG_BROWN("0;33"),
    FG_YELLOW("1;33"),
    FG_LIGHT_GRAY("0;37"),
    FG_WHITE("1;37"),

    /**
     * Background colors
     */
    BG_BLACK("40"),
    BG_RED("41"),
    BG_GREEN("42"),
    BG_YELLOW("43"),
    BG_BLUE("44"),
    BG_MAGENTA("45"),
    BG_CYAN("46"),
    BG_LIGHT_GRAY("47");

    /**
     * Escaping sequence for coloring
     */
    private final static String ESCAPE_SEQUENCE_START = "\u001B[";
    private final static String ESCAPE_SEQUENCE_END = "m";

    private final String code;

    CliColor(String code) {
        this.code = code;
    }

    /**
     * Returns the code representing the color.
     */
    public String getCode() {
        return code;
    }

    /**
     * Colors a given string.
     *
     * @param str string to color
     * @return colored string
     */
    public String color(String str) {
        return ESCAPE_SEQUENCE_START + code + ESCAPE_SEQUENCE_END + str + ESCAPE_SEQUENCE_START + ESCAPE_SEQUENCE_END;
    }
}
