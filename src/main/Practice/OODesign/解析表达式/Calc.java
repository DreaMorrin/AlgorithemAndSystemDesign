package main.Practice.OODesign.解析表达式;

public class Calc {
    private SymbolTable symbolTable;
    private FunctionTable functionTable;
    private Storage storage;
    public int findSymbol(String str) {
        return symbolTable.find(str);
    }

    public double getVariableValue(int id) {
        return storage.getValue(id);
    }

    public Function getFuncation(int id) {
        return functionTable.getFunction(id);
    }
}
