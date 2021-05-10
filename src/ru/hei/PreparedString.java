package ru.hei;

class PreparedString {
    private final String string;

    public PreparedString(String string) {
        this.string = string;
    }

    public String prepareAndGet() {
        return string.replaceAll("\\(\\s?-", "(0-")
                .replaceAll("\\(\\s?\\+", "(0+")
                .replaceAll("^-", "0-")
                .replaceAll("^\\+", "0+")
                .trim();
    }
}
