package calculatorProject.step3;

    public enum OperatorType {
        // Enum 상수 생성
        PLUS('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');


        private final char symbol;


        OperatorType(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }

        public static OperatorType fromSymbol(char symbol) {
            for (OperatorType op : OperatorType.values()) {
                if (op.getSymbol() == symbol) {
                    return op;
                }
            }
            throw new IllegalArgumentException("잘못된 연산 기호입니다.");
        }
    }


