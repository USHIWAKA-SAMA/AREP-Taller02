package edu.escuelaing.arep.statistics;

import java.util.List;

/**
 * Class for utility statistics methods
 */
public class StatisticUtils {

    /**
     * Calculates the mean of a set of real numbers
     * @param numbers List of real numbers
     * @return The mean of the given list
     */
    public static double calculateMean(List<Double> numbers){
        int total = numbers.size();
        double sum = 0;
        for (Double num : numbers){
            sum += num;
        }
        return sum/total;
    }

    /**
     * Calculates the standard deviation of a set of real numbers
     * @param numbers List of real numbers
     * @return The standard deviation of the given list
     */
    public static double calculateStandardDeviation(List<Double> numbers){
        double total = numbers.size();
        double avg = calculateMean(numbers);
        double numMinusAvgSquared = 0;
        for (Double num : numbers) {
            numMinusAvgSquared += Math.pow(num - avg, 2);
        }
        return Math.sqrt(numMinusAvgSquared/(total-1));
    }

}
