// Get prices range by instrument and timeframe

let JSClient = require('./node_modules/price-archive/Gehtsoft.PriceArchive.JSClient.min.js');
let client = new JSClient('https://pricearchive-fxcm-api.gehtsoft.com');

let instrument = "EURUSD";
let timeframe = "1m";
client.GetPricesRange(function (result) {
    if(result.Code === 0) {
       // dates in format "2011-08-16T23:59:00"
       var from = result.From;
       var to = result.To;
    
       console.table({"Instrument": instrument, 
                      "Timeframe": timeframe, 
                      "From": result.From, 
                      "To": result.To}
       );
    } else {
      console.log(result);
    }

 }, instrument, timeframe);
