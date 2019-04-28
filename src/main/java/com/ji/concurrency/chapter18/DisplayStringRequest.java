package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:31 PM
*/

/*
{@link ActiveObject#DisplayString(int,char)}
 */
public class DisplayStringRequest extends MethodRequest {

    private final String text;

    protected DisplayStringRequest(Servant servant, String text) {
        super(servant, null);
        this.text = text;

    }

    @Override
    public void execute() {
        this.servant.displayString(text);
    }
}
