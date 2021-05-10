package ru.hei;

class PreparedString {
    private final String string;

    public PreparedString(String string) {
        this.string = string;
    }

    public String prepareAndGet() {
        return string.replace("( - ", "( 0 - ")
                .replace("( + ", "( 0 + ")
                .replace(", - ", ",0 - ")
                .replace(", + ", ", 0 + ")
                .trim();
    }
}
