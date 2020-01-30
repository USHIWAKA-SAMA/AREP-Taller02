package edu.escuelaing.arep;

import edu.escuelaing.arep.collections.LinkedList;
import edu.escuelaing.arep.statistics.StatisticUtils;
import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

import org.decimal4j.util.DoubleRounder;

/**
 * Spark web application class for calculating the mean and standard deviation of a set of real numbers.
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> indexPage(req, res));
        post("/calculate", (req, res) -> calculatePage(req, res));
    }

    /**
     * Gets the index page of the application
     *
     * @param req Provides information about the HTTP request
     * @param res Provides information about the HTTP response
     * @return The index in html page
     */
    private static String indexPage(Request req, Response res) {
        return "<html>\n" +
                "<head>\n" +
                "  <title>StatisticsApp</title>\n" +
                "</head>\n" +
                "<body style=\"background-color:#d9ffb3\">\n" +
                "  <div style=\"margin:auto\">\n" +
                "    <h1>Mean and Standard Deviation Calculator</h1>\n" +
                "    <form method=\"post\" action=\"/calculate\">\n" +
                "      <p><b>Instructions:</b> Insert a set of real numbers separated by commas (,) and hit the 'Calculate' button.</p>\n" +
                "      <p><b>Example:</b> 1, 2, 3.5 , ...</p>\n" +
                "      <input type=\"text\" required=\"true\" name=\"numbers\"/>\n" +
                "      <input type=\"submit\" value=\"Calculate\"/>\n" +
                "    </form>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
    }

    /**
     * Gets the calculation page of the application
     *
     * @param req Provides information about the HTTP request
     * @param res Provides information about the HTTP response
     * @return The calculation page with the mean and standard deviation of the set of data
     */
    private static String calculatePage(Request req, Response res) {
        String numbersParam = req.queryParams("numbers");
        String[] numbers = numbersParam.split("\\s*(,)\\s*");
        List<Double> linkedList = new LinkedList<>();
        for (String num : numbers) {
            try {
                linkedList.add(Double.parseDouble(num));
            } catch (NumberFormatException e) {
                return "<html>\n" +
                        "<head>\n" +
                        "  <title>StatisticsApp</title>\n" +
                        "</head>\n" +
                        "<body style=\"background-color:#d9ffb3\">\n" +
                        "  <div style=\"margin:auto\">\n" +
                        "    <h1>Mean and Standard Deviation Calculator</h1>\n" +
                        "    <p><b>Invalid input:</b> " + numbersParam + " </p>\n" +
                        "    <form action=\"/\">\n" +
                        "      <input type=\"submit\" value=\"Return\"/>\n" +
                        "    </form>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                        "</html>";
            }
        }
        double mean = StatisticUtils.calculateMean(linkedList);
        double std = StatisticUtils.calculateStandardDeviation(linkedList);
        return "<html>\n" +
                "<head>\n" +
                "  <title>StatisticsApp</title>\n" +
                "</head>\n" +
                "<body style=\"background-color:#d9ffb3\">\n" +
                "  <div style=\"margin:auto\">\n" +
                "    <h1>Mean and Standard Deviation Calculator</h1>\n" +
                "    The results for the data set <b>" + Arrays.toString(numbers) + "</b>  are:\n" +
                "    <table style=\"width:25%;border: 2px solid black\">\n" +
                "      <tr >\n" +
                "        <th style=\"border:1px solid black\">Mean</th>\n" +
                "        <th style=\"border:1px solid black\">Std. Dev</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td align=\"center\" style=\"border:1px solid black\">" + DoubleRounder.round(mean, 2) + "</td>\n" +
                "        <td align=\"center\" style=\"border:1px solid black\">" + DoubleRounder.round(std, 2) + "</td>\n" +
                "    </table>\n" +
                "    <br/>\n" +
                "    <form action=\"/\">\n" +
                "      <input type=\"submit\" value=\"Return\"/>\n" +
                "    </form>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * @return The port variable if set, else 4567 as default
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
