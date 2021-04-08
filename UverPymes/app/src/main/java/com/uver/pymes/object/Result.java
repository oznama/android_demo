package com.uver.pymes.object;

public class Result {

    private boolean result;

    public Result() {
        result = false;
    }

    public boolean getResult(){
        return result;
    }

    public void setResult(boolean result){
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                '}';
    }
}
