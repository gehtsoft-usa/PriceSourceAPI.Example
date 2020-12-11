// Get prices by instrument, timeframe and period

let JSClient = require('./node_modules/price-archive/Gehtsoft.PriceArchive.JSClient.min.js');
let client = new JSClient('https://pricearchiveapi.gehtsoft.com');

let instrument = "EURUSD";
let timeframe = "1m";
// parameter dates in format "2011-08-16 23:59"
let from = "2009-10-20 15:30";
let to = "2009-10-20 16:00";
let precision = 5;
client.GetPrices(function (result) {
    var bars = result.History.Bars;
    var history = [];
    for (let i = 0; i < bars.length; i++) {
        let bar = bars[i];
    history.push({ "Date": bar.Start, 
                       "Bid.Open": bar.Bid.Open.toFixed(precision),
                       "Bid.High": bar.Bid.High.toFixed(precision),
                       "Bid.Low": bar.Bid.Open.toFixed(precision),
                       "Bid.Close": bar.Bid.High.toFixed(precision),
                       "Volume": bar.Bid.Volume.toFixed()
        });
    }
    console.table(history);

}, instrument, timeframe, from, to);
