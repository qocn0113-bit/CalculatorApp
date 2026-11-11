package calculatorProject.step2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Double> results = new ArrayList<>();

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public double calculate(int num1, int num2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 숫자)는 0이 될 수 없습니다.");
                } else {
                    result = (double) num1 / num2;
                    break;
                    }
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
