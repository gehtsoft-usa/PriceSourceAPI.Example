// Get all available instruments

let JSClient = require('./node_modules/price-archive/Gehtsoft.PriceArchive.JSClient.min.js');
let client = new JSClient('https://pricearchive-fxcm-api.gehtsoft.com');

client.GetInstruments(function (result) {
   if (typeof result.Instruments !== 'undefined' && result.Instruments !== null && result.Instruments.length > 0) {
       for (let i = 0; i < result.Instruments.length; i++) {
           // instrument name
           let instrument = result.Instruments[i];
           console.log(instrument);
       }
   } else {
       // error
       console.log(result);
   }
 });
