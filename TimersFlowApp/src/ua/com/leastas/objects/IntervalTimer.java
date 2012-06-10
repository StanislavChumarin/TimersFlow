package ua.com.leastas.objects;

import android.content.Context;
import android.content.res.Resources;
import ua.com.leastas.R;

/**
 * Created with IntelliJ IDEA.
 * User: stanislavchumarin
 * Date: 10.06.12
 * Time: 01:25
 * This is actual timer that will be started.
 */
public class IntervalTimer {
    public String name = "";
    public int hours;
    public int minutes;
    public int seconds;

    /**
     * This method is used to format time.
     *
     * @param whatToShow defines whether show hours, minutes or seconds in output string
     *                   1 - returns only seconds
     *                   2 - returns minutes and seconds
     *                   3 - returns hours, minutes and seconds
     *                   0 - shows only non-zero elements.
     * @param context    application context
     * @return string that contains time formatted in "hh %hours_short_name% mm %minutes_short_name% ss %seconds_short_name%"
     */
    public String getFormattedTime(byte whatToShow, Context context) {
        StringBuilder result = new StringBuilder();
        Resources rb = context.getResources();
        String space = " ";
        switch (whatToShow) {
            case 0:
                showNonZeros(result, rb);
                break;
            case 3:
                result.append(hours).append(rb.getString(R.string.hours_short));
            case 2:
                result.append(space).append(pad(minutes)).append(rb.getString(R.string.minutes_short));
            case 1:
                result.append(space).append(pad(seconds)).append(rb.getString(R.string.seconds_short));
        }

        return result.toString().trim();
    }

    private void showNonZeros(StringBuilder output, Resources resources) {
        if (hours != 0)
            output.append(hours).append(resources.getString(R.string.hours_short));
        if (minutes != 0)
            output.append(" ").append(pad(minutes)).append(resources.getString(R.string.minutes_short));
        if (seconds != 0)
            output.append(" ").append(pad(seconds)).append(resources.getString(R.string.seconds_short));
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}
