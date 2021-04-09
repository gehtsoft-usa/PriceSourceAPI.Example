using System;
using ConsoleTables;
using Gehtsoft.PriceArchive.Client;
using Gehtsoft.PriceArchive.PriceCollection.History;

namespace GetPrices
{
    class Program
    {
        static void Main(string[] args)
        {
            string instrument = "EURUSD";
            Timeframe timeframe = Timeframe.OneMinute;
            DateTime from = new DateTime(2009, 10, 20, 15, 30, 0);
            DateTime to = new DateTime(2009, 10, 20, 15, 45, 0);
            PriceArchiveClient client = new PriceArchiveClient("https://pricearchive-fxcm-api.gehtsoft.com");
            BarHistory history = client.GetPrices(instrument, timeframe, from, to) as BarHistory;
            Console.WriteLine($"Instrument='{history.Instrument}' Timeftrame='{history.Timeframe}' Precision='{history.Precision}'");
            ConsoleTable table = new ConsoleTable("Start", "Bid.Open", "Bid.High", "Bid.Low", "Bid.Close", "Volume");
            for (int i=0; i < history.Count; i++)
            {
                table.AddRow(history.Start(i),
                    Math.Round(history[i].Bid.Open, history.Precision),
                    Math.Round(history[i].Bid.High, history.Precision),
                    Math.Round(history[i].Bid.Low, history.Precision),
                    Math.Round(history[i].Bid.Close, history.Precision),
                    history[i].Bid.Volume);
            }
            table.Write();
        }
    }
}
