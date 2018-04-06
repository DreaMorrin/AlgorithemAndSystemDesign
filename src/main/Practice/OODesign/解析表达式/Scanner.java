package main.Practice.OODesign.解析表达式;

import java.io.InputStream;

public class Scanner {
    private enum EToken {
        TOKEN_COMMAND,
        TOKEN_ERROR,
        TOKEN_END,
        TOKEN_NUMBER,
        TOKEN_IDENTIFIER,
        TOKEN_PLUS,
        TOKEN_MINUS,
        TOKEN_MUTIPLY,
        TOKEN_DIVIDE,
        TOKEN_LPARENTHESIS,
        TOKEN_RPARENTHESIS,
        TOKEN_ASSIGN;
    }

    private InputStream input;
    private boolean isEmpty;
    private EToken token;
    private double number;
    private String symbol;
    private int look;
    private void readChar() {

    }

    public Scanner(InputStream input) {
        this.input = input;
    }

    public void accept() {

    }

    public void acceptCommand() {

    }

    public void cleanStream() {

    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public boolean isCommand() {
        return false;
    }

    public String getSymbol() {
        return null;
    }

    public EToken token() {
        return null;
    }
}
