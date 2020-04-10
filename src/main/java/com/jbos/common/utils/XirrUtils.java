package com.jbos.common.utils;

import org.decampo.xirr.Transaction;
import org.decampo.xirr.Xirr;

public class XirrUtils {
    public static double analysis(double x){
        double rate = new Xirr(
                new Transaction(-175000000, "2019-03-22"),
                new Transaction(2711301.36986301, "2019-06-17"),
                new Transaction(2867123.28767123, "2019-09-17"),
                new Transaction( 2835958.90410959, "2019-12-17"),
                new Transaction( 966095.890410959, "2020-01-17"),
                new Transaction( 966095.890410959, "2020-02-17"),
                new Transaction(  175000000+x, "2020-03-17")
        ).xirr();
        return rate*100;
    }
}
