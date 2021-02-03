using System;
using Gehtsoft.PriceArchive.Client;
using Gehtsoft.PriceArchive.PriceCollection.History;

namespace GetPricesRange
{
    class Program
    {
        static void Main(string[] args)
        {
            string instrument = "EURUSD";
            Timeframe timeframe = Timeframe.OneMinute;
            PriceArchiveClient client = new PriceArchiveClient("https://pricearchiveapi.gehtsoft.com");
            PriceArchiveClient.Range range = client.GetPricesRange(instrument, timeframe);
            Console.WriteLine($"Instrument='{instrument}' Timeftrame='{timeframe}' From='{range.From}' To='{range.To}'");
        }
    }
}
