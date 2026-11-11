package calculatorProject.step2;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        while (true) {
            int num1;
            int num2;
            char operator = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            if (scanner.hasNextInt()) {
                num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("양의 정수를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자만 입력이 가능합니다.");
                scanner.next();
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            if (scanner.hasNextInt()) {
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("0보다 큰 정수를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자만 입력이 가능합니다.");
                scanner.next();
                continue;
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = scanner.next().charAt(0);


            try {
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
                } else {
                    System.out.println("값이 존재하지 않습니다.");
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