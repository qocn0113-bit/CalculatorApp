package calculatorProject2.step2;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        int num1;
        int num2;
        char operator;
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(true) {
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

            System.out.print("연산자(+, -, *, /)를 입력하세요: ");

            try {
                operator = scanner.next().charAt(0);
                calculator.calculate(num1, num2, operator);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("현재 저장된 결과값: " + calculator.getResults());

            System.out.println("저장된 값을 수정하시겠습니까? 수정: yes , 넘어가기: 아무 키");
            String update = scanner.next();
            if (update.equals("yes")) {
                System.out.print("수정할 값의 순서를 입력하세요: ");
                if (scanner.hasNextInt()) {
                    int turn = scanner.nextInt();
                    if (turn < 1 || turn > calculator.getResults().size()) {
                        System.out.println("잘못된 순서입니다.");
                        continue;
                    }
                    System.out.print("새로운 값으로 수정하세요.");
                    if (scanner.hasNextDouble()) {
                        double value = scanner.nextDouble();
                        calculator.setResults(turn-1, value);
                        System.out.println("수정 후 결과값: " + calculator.getResults());
                    } else {
                        System.out.println("숫자만 입력이 가능합니다.");
                        scanner.next();
                        continue;
                    }

                } else {
                    System.out.println("숫자만 입력이 가능합니다.");
                    scanner.next();
                    continue;
                }
            }

            System.out.println("가장 먼저 저장된 값을 삭제하시겠습니까? 삭제: yes , 넘어가기: 아무 키");
            String delete = scanner.next();
            if (delete.equals("yes")) {
                if (calculator.getResults().isEmpty()) {
                    System.out.println("값이 존재하지 않습니다.");
                } else {
                    calculator.removeResults();
                    System.out.println("가장 먼저 저장된 값을 삭제한 후: " + calculator.getResults());
                }
            }

            System.out.println("종료하시겠습니까? 종료: exit , 이어하기: 아무 키");
            String exit = scanner.next();
            if (exit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }


    }

}
