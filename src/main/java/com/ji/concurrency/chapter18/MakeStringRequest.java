package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:31 PM
*/
/*
{@link ActiveObject#makeString(int,char ) }
 */

public class MakeStringRequest extends MethodRequest {
    private final int count;
    private final char fillChar;

    protected MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result result =   servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
