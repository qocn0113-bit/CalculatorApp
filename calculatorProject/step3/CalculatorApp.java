package calculatorProject.step3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculatorApp {

    public static void main(String[] args) {

        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        while (true) {
            double num1;
            double num2;
            OperatorType operator;
            Scanner scanner = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
                if (num1 < 0) {
                    System.out.println("양의 숫자를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자만 입력이 가능합니다.");
                scanner.next();
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
                if (num2 < 0) {
                    System.out.println("0보다 큰 숫자를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자만 입력이 가능합니다.");
                scanner.next();
                continue;
            }
            System.out.print("사칙연산 기호를 입력하세요: ");

            try {
                operator = OperatorType.fromSymbol(scanner.next().charAt(0));
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과값: " + result);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두 번째 숫자)는 0이 될 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력값 입니다.");
            }

            System.out.println("현재 저장된 값: " + calculator.getResults());
            System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? 삭제: yes / 넘어가기: 아무 키");
            String delete = scanner.next();
            if (delete.equals("yes")) {
                if (!calculator.getResults().isEmpty()) {
                    calculator.removeResult();
                    System.out.println("가장 먼저 저장된 결과를 삭제한 후: " + calculator.getResults());
                }
                else {
                    System.out.println("삭제할 데이터가 없습니다.");
                }
            }
            System.out.println("특정 값보다 큰 숫자를 조회하시겠습니까? 조회: yes / 넘어가기: 아무 키 ");
            String get = scanner.next();
            if (get.equals("yes")) {
                if (calculator.getResults().isEmpty()) {
                    System.out.println("값이 존재하지 않습니다.");
                } else {
                    System.out.println("기준 값을 입력하세요: ");
                    Double standard = scanner.nextDouble();
                    List<Double> filteredList = calculator.getResults().stream()
                            .filter(result -> result > standard)
                            .collect(Collectors.toList());
                    System.out.println(filteredList);
                    long count = calculator.getResults().stream()
                            .filter(result -> result > standard)
                            .count();
                    if (count == 0) {
                        System.out.println("조건에 맞는 결과가 없습니다.");
                    }
                }
            }

            System.out.println("종료: exit, 이어하기: 아무 키");
            String out = scanner.next();
            if (out.equals("exit")) {
                break;
            }


        }
    }
}