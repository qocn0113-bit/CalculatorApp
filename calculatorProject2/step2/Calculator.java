package calculatorProject2.step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> results = new ArrayList<>();

    public List<Double> getResults() {
        return results;
    }

    public void setResults(int index, double newValue) {
        results.set(index, newValue);
    }

    public void calculate(int num1, int num2, char operator) {

        double result;
        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈에서 분모(두 번째 숫자)는 0이 될 수 없습니다.");
                } else {
                    result = (double) num1 / num2;
                }
            }
            default -> {
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
            }
        }
        System.out.println("결과값: " + result);

        results.add(result);

    }

    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0);
        }

    }

}
