package calculatorProject2.step1;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

        while (true) {
            int num1;
            int num2 = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            if (scanner.hasNextInt()) {
                num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scanner.next();
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            if (scanner.hasNextInt()) {
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력하세요.");
                    continue;
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scanner.next();
                continue;
            }

            double result;

            System.out.print("연산자(+, -, *, /)를 입력하세요: ");
            char operator = scanner.next().charAt(0);
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("나눗셈에서 분모(두 번째 숫자)는 0이 될 수 없습니다.");
                        continue;
                    }
                    result = (double) num1 / num2;
                }
                default -> {
                    System.out.println("지원하지 않는 연산자입니다.");
                    continue;
                }
            }
            System.out.println("결과값: " + result);

            System.out.println("종료하시겠습니까? 종료: eixt / 이어하기: 아무 키");
            if (scanner.next().equals("eixt")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }


        }
    }
}



