package calculatorProject2.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    private List<Double> results = new ArrayList<>();

    public List<Double> getResults() {
        return results;
    }

    public void setResults(int index, double newValue) {
        results.set(index, newValue);
    }


    public <T extends Number, U extends Number> double calculate(T num1, U num2, OperatorType operator) {
        double double1 = num1.doubleValue();
        double double2 = num2.doubleValue();
        double result = operator.apply(double1, double2);

        System.out.println("결과값: " + result);

        results.add(result);
        return result;
    }

    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0);
        }

    }

    public static double readStandard(Scanner scanner) {
        while (true) {
            System.out.print("기준값을 입력하세요: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("숫자를 입력하세요.");
                scanner.next();
                continue;
            }

            double standard = scanner.nextDouble();
            if (!Double.isFinite(standard)) {
                System.out.println("유한한 숫자를 입력하세요.");
                continue;
            }
            return standard;
        }
    }

    public List<Double> findResultsGreaterThan(double standard) {
        return results.stream()
                .filter(result -> result > standard)
                .collect(Collectors.toList());
    }

}

