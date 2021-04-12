package GsPiacSamples;
import gehtsoft.pricearchive.client.PriceArchiveClient;
import gehtsoft.pricearchive.client.PriceArchiveException;
import gehtsoft.pricearchive.client.InstrumentRange;
import java.io.IOException;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_Grid;
import de.vandermeer.asciithemes.TA_GridConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.TimeZone;

public class GetRangesApp 
{
    public static void main( String[] args ) throws PriceArchiveException, IOException, ParseException
    {
        //
        // All dates returned by PriceArchiveClient methods are in UTC
        //
        TimeZone timezone = TimeZone.getTimeZone("UTC");
        PriceArchiveClient client = new PriceArchiveClient("https://pricearchive-fxcm-api.gehtsoft.com");
        InstrumentRange[] ranges =  client.GetAllRanges();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setTimeZone(timezone);
        AsciiTable at = new AsciiTable();
        TA_Grid myGrid = TA_Grid.create("grid using UTF-8 light border characters")
                .addCharacterMap(TA_GridConfig.RULESET_NORMAL, ' ', '-', '|', '+', '+', '+', '+', '+', '+', '+', '+', '+');

        System.out.println( "Available price ranges:" );
        at.addRule();
        at.addRow("Instrument", "Timeframe", "From", "To");
        at.addRule();
        for (InstrumentRange range : ranges)
        {
            String fromStr = dateFormat.format(range.Range.From);
            String toStr = dateFormat.format(range.Range.To);
            at.addRow(range.Instrument, range.Timeframe.toString(), fromStr, toStr);
            at.addRule();
        }
        at.getContext().setGrid(myGrid);
        System.out.println(at.render());
    }
}
