using System;
using ConsoleTables;
using Gehtsoft.PriceArchive.Client;

namespace GetAllRanges
{
    class Program
    {
        static void Main(string[] args)
        {
            PriceArchiveClient client = new PriceArchiveClient("https://pricearchive-fxcm-api.gehtsoft.com");
            PriceArchiveClient.InstrumentRange[] ranges = client.GetAllRanges();
            if(ranges != null)
            {
                ConsoleTable table = new ConsoleTable("Instrument", "Timeftrame", "From", "To");
                foreach (PriceArchiveClient.InstrumentRange range in ranges)
                {
                    table.AddRow(range.Instrument, range.Timeframe, range.Range.From, range.Range.To);
                }
                table.Write();
            }
        }
    }
}
