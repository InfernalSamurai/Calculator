package ru.hei;

class Calculator {
    private final String string;
    private final Stack<Double> stack;

    public Calculator(String string) {
        this.string = new PreparedString(string).prepareAndGet();
        stack = new Stack<>();
    }

    public double calculate() {
        for (String symbol : string.split("\\s")) {
            Type type = Type.getType(symbol);
            if (type == Type.NUMBER) {
                try {
                    stack.put(Double.parseDouble(symbol));
                } catch (NumberFormatException e) {
                    System.out.println("Не удалось преобразовать символ в число, проверьте правильность ввода!");
                    System.exit(1);
                }
            } else {
                double i = stack.pop();
                double y = stack.pop();
                stack.put(type.operate(y, i));
            }
        }

        return stack.firstElement();
    }
}
