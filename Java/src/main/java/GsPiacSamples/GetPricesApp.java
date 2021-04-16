package GsPiacSamples;
import gehtsoft.pricearchive.client.PriceArchiveClient;
import gehtsoft.pricearchive.client.PriceArchiveException;
import gehtsoft.pricearchive.client.BarCollection;
import gehtsoft.pricearchive.client.Bar;
import gehtsoft.pricearchive.client.Timeframe;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_Grid;
import de.vandermeer.asciithemes.TA_GridConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;

public class GetPricesApp {
    public static void main( String[] args ) throws PriceArchiveException, IOException, ParseException
    {
        PriceArchiveClient client = new PriceArchiveClient("https://pricearchiveapi.gehtsoft.com");
        String instrument = "EURUSD";
        Timeframe timeframe = Timeframe.OneMinute;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date from = dateFormat.parse("2009-10-20 15:30");                
        Date to = dateFormat.parse("2009-10-20 16:00");                


        BarCollection history = client.GetBarPrices(instrument, timeframe, from, to);

        if (history == null) {
            System.out.println("No data for " +  instrument + " " + timeframe.toString() + " from " + dateFormat.format(from) + " to " + dateFormat.format(to));
            return;
        }

        int precision = history.getPrecision();
        String decimalFormatStr = "0.";
        for(int i=0; i < precision; i++) decimalFormatStr += "0";
        DecimalFormat decimalFormat = new DecimalFormat(decimalFormatStr);

        AsciiTable at = new AsciiTable();
        TA_Grid myGrid = TA_Grid.create("grid using UTF-8 light border characters")
                .addCharacterMap(TA_GridConfig.RULESET_NORMAL, ' ', '-', '|', '+', '+', '+', '+', '+', '+', '+', '+', '+');

        System.out.println( "Prices for " +  instrument + " " + timeframe.toString() + " from " + dateFormat.format(from) + " to " + dateFormat.format(to) + " :");
        at.addRule();
        at.addRow("Date", "Bid.Open", "Bid.High", "Bid.Low", "Bid.Close", "Volume");
        at.addRule();
        for (Bar bar : history)
        {
            at.addRow(dateFormat.format(bar.getStart()),
                decimalFormat.format(bar.getBid().getOpen()),
                decimalFormat.format(bar.getBid().getHigh()),
                decimalFormat.format(bar.getBid().getLow()),
                decimalFormat.format(bar.getBid().getClose()),
                (new DecimalFormat("0")).format(bar.getBid().getVolume())
            );
            at.addRule();
        }
        at.getContext().setGrid(myGrid);
        System.out.println(at.render());
    }
    
}
