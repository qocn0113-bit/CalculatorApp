package calculatorProject2.step3;

public enum OperatorType {
    ADD('+') {
        @Override
        public double apply(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUB('-') {
        @Override
        public double apply(double num1, double num2) {
            return num1 - num2;
        }
    },
    MUL('*') {
        @Override
        public double apply(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIV('/') {
        @Override
        public double apply(double num1, double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("나눗셈에서 분모(두 번째 숫자)는 0이 될 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromChar(char operator) {
        for (OperatorType op : values()) {
            if (op.symbol == operator) {
                return op;   // OperatorType Enum 값을 반환
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    public abstract double apply(double num1, double num2);



}

