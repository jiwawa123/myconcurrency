package com.ji.concurrency.chapter8;/*
    user ji
    data 2019/3/12
    time 9:49 AM
*/

/*
future 代表未来的一个凭据，用来拿结果使用，接受返回结果
futureTask 将自己的调用逻辑进行了隔离：线程里面的任务执行
futureService 起到了桥接作用
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
//        String result = get();
//        System.out.println(result );
        FutureService fs = new FutureService();
        Future<String> future = fs.submit(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        }, System.out::println);

        System.out.println("===============");
        System.out.println("do other thing");
        System.out.println("===============");
        Thread.sleep(1000);
        System.out.println("===============");
        System.out.println("===============");
        //System.out.println(future.get());

    }

//    private static String get() {
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "FINISH";
//    }

}
