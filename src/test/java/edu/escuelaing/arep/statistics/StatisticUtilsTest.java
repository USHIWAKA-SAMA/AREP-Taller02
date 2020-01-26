package edu.escuelaing.arep.statistics;

import static org.junit.Assert.*;

import edu.escuelaing.arep.collections.LinkedList;
import org.decimal4j.util.DoubleRounder;
import org.junit.Test;

import java.util.List;

public class StatisticUtilsTest {

    @Test
    public void shouldGiveSameMeanAndStdAsTheData01(){
        List<Double> linkedList = new LinkedList<>();
        linkedList.add(160d);
        linkedList.add(591d);
        linkedList.add(114d);
        linkedList.add(229d);
        linkedList.add(230d);
        linkedList.add(270d);
        linkedList.add(128d);
        linkedList.add(1657d);
        linkedList.add(624d);
        linkedList.add(1503d);
        double mean = StatisticUtils.calculateMean(linkedList);
        double stdv = StatisticUtils.calculateStandardDeviation(linkedList);
        assertEquals(550.6, DoubleRounder.round(mean, 2), 0.0);
        assertEquals(572.03, DoubleRounder.round(stdv, 2), 0.0);
    }

    @Test
    public void shouldGiveSameMeanAndStdAsTheData02(){
        List<Double> linkedList = new LinkedList<>();
        linkedList.add(15.0);
        linkedList.add(69.9);
        linkedList.add(6.5);
        linkedList.add(22.4);
        linkedList.add(28.4);
        linkedList.add(65.9);
        linkedList.add(19.4);
        linkedList.add(198.7);
        linkedList.add(38.8);
        linkedList.add(138.2);
        double mean = StatisticUtils.calculateMean(linkedList);
        double stvd = StatisticUtils.calculateStandardDeviation(linkedList);
        assertEquals(60.32, DoubleRounder.round(mean,2),0.0);
        assertEquals(62.26, DoubleRounder.round(stvd,2),0.0);
    }

}
