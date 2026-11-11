package calculatorProject.step3;

import java.util.ArrayList;

public class ArithmeticCalculator<T extends Number> {
    private ArrayList<Double> results = new ArrayList<>();

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public double calculate(T num1, T num2, OperatorType operator) {
        double result;
        switch (operator) {
            case PLUS:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case MINUS:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("입력값이 0이 될 수 없습니다.");
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
            default:
                System.out.println("잘못된 입력값 입니다.");
                return 0;
        }
        results.add(result);
        return result;

    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }


}
