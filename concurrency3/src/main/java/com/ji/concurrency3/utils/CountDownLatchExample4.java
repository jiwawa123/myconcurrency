package com.ji.concurrency3.utils;/*
    user ji
    data 2019/3/24
    time 3:11 PM
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample4 {
    private static Random random = new Random(System.currentTimeMillis());

    static class Event {
        private int id;

        public Event(int id) {
            this.id = id;
        }
    }

    static class Table {
        String tableName;
        long sourceRecordCount = 10;
        long targetCount;
        String colunmSchema = "<table name='a'><colunm name='coll' type=''varchar2'/></table>";
        String target = "";

        public Table(String tableName, long targetCount) {
            this.tableName = tableName;
            this.targetCount = targetCount;
        }
    }

    private static List<Table> capture(Event event) {
        List<Table> list = new ArrayList<Table>();
        for (int i = 0; i < 10; i++) {
            list.add(new Table("table-" + event.id + "-" + i, i * 1000));
        }
        return list;
    }

    public static void main(String[] args) {
        Event[] events = {new Event(1), new Event(2)};
        for (Event event : events
                ) {
            ExecutorService service = Executors.newFixedThreadPool(5);
            List<Table> tables = capture(event);
            for (Table table : tables) {
                TrustSourceRecordCount count = new TrustSourceRecordCount(table);
                Trust trust = new Trust(table);
                service.submit(count);
                service.submit(trust);
            }
        }

    }

    static class TrustSourceRecordCount implements Runnable {

        private final Table table;

        TrustSourceRecordCount(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetCount = table.sourceRecordCount;
            System.out.println("check count is ok");

        }
    }

    static class Trust implements Runnable {

        private final Table table;

        Trust(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.target = table.colunmSchema;
            System.out.println("check colunm is ok");
        }
    }


}
