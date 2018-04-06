package main.Practice.OODesign.解析表达式;

public class Parser {
    private enum STATUS {
        STATUS_OK,
        STATUS_ERROR,
        STATUS_QUIT,
    }

    private Scanner scanner;
    private Node tree;
    private STATUS status;
    private Calc calc;


    public Parser(Scanner scanner, Calc calc) {
        this.scanner = scanner;
        this.calc = calc;
    }

    public STATUS parse() {
        //parse expression and place into expression tree;
        // split into parts -> -4+1+x-1+sin(20 * 3)
        /**
         * parse expression and place into expression tree;
         * split into parts -> -4+1+x-1+(sin(30) + 3)
         *         +
         * -4      1    x-1        (sin(30) + 3)
         * -1 * 4       x   -1     sin(30)   3
         *                         sin() 30
         *
         */
        return STATUS.STATUS_OK;
    }

    public Node expr() {
        return null;
    }

    public Node term() {
        return null;
    }


    public Node factor() {
        return null;
    }

    public double calculate() {
        return 0.0;
    }
}
