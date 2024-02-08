package com.carina.demo.enums;

public enum AvailablePages {
    LOGIN("//a[@href='/login']"),
    DROPDOWN("//a[@href='/dropdown']"),
    KEY_PRESSES("//a[@href='/key_presses']");

    private final String xpath;

    AvailablePages(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
