using System;
using Gehtsoft.PriceArchive.Client;

namespace GetInstruments
{
    class Program
    {
        static void Main(string[] args)
        {
            PriceArchiveClient client = new PriceArchiveClient("https://pricearchive-fxcm-api.gehtsoft.com");
            string[] instruments = client.GetInstruments();
            foreach(string instrument in instruments)
            {
                Console.WriteLine(instrument);
            }
        }
    }
}
