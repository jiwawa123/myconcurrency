package com.ji.concurrency.chapter11;/*
    user ji
    data 2019/3/12
    time 7:44 PM
*/


public class ExecutionTask implements Runnable {
    private QueryFromDBAction queryAction = new QueryFromDBAction();
    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        Context context = ActionContext.getActionContext().getContext();
        queryAction.execute();
        System.out.println("query name successful");
        queryFromHttpAction.execute();
        System.out.println("query address successful ");
        System.out.println(context.getName()+" "+context.getAddress());
    }
}
