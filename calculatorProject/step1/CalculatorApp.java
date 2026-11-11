package calculatorProject.step1;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        while (true) {
            int num1;
            int num2;
            Scanner scanner = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            if (scanner.hasNextInt()) {
                num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("양의 정수를 입력하세요.");
                    continue;
                }
            }
            else {
                System.out.println("숫자만 입력이 가능합니다.");
                scanner.next();
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            if (scanner.hasNextInt()) {
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("양의 정수를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자만 입력이 가능합니다.");
                scanner.next();
                continue;
            }


            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);
            if (operator == '+') {
                int plus = (num1 + num2);
                System.out.println("결과값: " + plus);
            } else if (operator == '-') {
                int minus = (num1 - num2);
                System.out.println("결과값: " + minus);
            } else if (operator == '*') {
                int mul = (num1 * num2);
                System.out.println("결과값: " + mul);
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 숫자)는 0이 될 수 없습니다.");
                } else {
                    double div = ((double) num1 / num2);
                    System.out.println("결과값: " + div);
                }
            } else {
                System.out.println("잘못된 입력값 입니다.");
            }
            System.out.println("종료: exit, 이어하기: 아무 키");
            String out = scanner.next();
            if (out.equals("exit")) {
                break;
            }


        }


    }
}
