package GsPiacSamples;
import gehtsoft.pricearchive.client.PriceArchiveClient;
import gehtsoft.pricearchive.client.PriceArchiveException;
import java.io.IOException;

public class GetInstrumentsApp
{
    public static void main( String[] args ) throws PriceArchiveException, IOException
    {
        PriceArchiveClient client = new PriceArchiveClient("https://pricearchiveapi.gehtsoft.com");
        String[] instruments = client.GetInstruments();
        System.out.println( "Available instruments:");
        for (int i = 0; i < instruments.length; i++) {
            // instrument name
           String instrument = instruments[i];
           System.out.println(instrument);
        }
    }
}
