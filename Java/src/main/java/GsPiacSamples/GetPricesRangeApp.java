package GsPiacSamples;
import gehtsoft.pricearchive.client.PriceArchiveClient;
import gehtsoft.pricearchive.client.PriceArchiveException;
import gehtsoft.pricearchive.client.Range;
import gehtsoft.pricearchive.client.Timeframe;
import java.io.IOException;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_Grid;
import de.vandermeer.asciithemes.TA_GridConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class GetPricesRangeApp {
    public static void main( String[] args ) throws PriceArchiveException, IOException, ParseException
    {
        PriceArchiveClient client = new PriceArchiveClient("https://pricearchive-fxcm-api.gehtsoft.com");
        String instrument = "EURUSD";
        Timeframe timeframe = Timeframe.OneMinute;
        Range range =  client.GetPricesRange(instrument, timeframe);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        AsciiTable at = new AsciiTable();
        TA_Grid myGrid = TA_Grid.create("grid using UTF-8 light border characters")
                .addCharacterMap(TA_GridConfig.RULESET_NORMAL, ' ', '-', '|', '+', '+', '+', '+', '+', '+', '+', '+', '+');

        System.out.println( "Price range:" );
        at.addRule();
        at.addRow("Instrument", "Timeframe", "From", "To");
        at.addRule();
        String fromStr = dateFormat.format(range.From);
        String toStr = dateFormat.format(range.To);
        at.addRow(instrument, timeframe.toString(), fromStr, toStr);
        at.addRule();
        at.getContext().setGrid(myGrid);
        System.out.println(at.render());
    }
}
