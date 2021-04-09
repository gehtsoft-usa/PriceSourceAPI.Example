// Get all ranges (info about all instruments with available timeframes and ranges)

let JSClient = require('./node_modules/price-archive/Gehtsoft.PriceArchive.JSClient.min.js');
let client = new JSClient('https://pricearchive-fxcm-api.gehtsoft.com');

client.GetAllRanges(function (result) {
  if (typeof result.Ranges !== 'undefined' && result.Ranges !== null && result.Ranges.length > 0) {
      let ranges = [];

      for (let i = 0; i < result.Ranges.length; i++) {
          let instrumentName = result.Ranges[i].Instrument;
          let timeframe = result.Ranges[i].Timeframe;
          let from = result.Ranges[i].From;
          let to = result.Ranges[i].To;

          let range = ranges.find(o => o.from === from && o.to === to);
          if (typeof (range) === 'undefined'){
              range = {}
              range.from = from;
              range.to = to;
              range.timeframes = [];
              ranges.push(range);
          }
          
          range.timeframes[instrumentName] = typeof (range.timeframes[instrumentName]) === 'undefined' ? 
          timeframe : range.timeframes[instrumentName] + " " + timeframe;
       }
       
       ranges.forEach(function(range){
             console.log(`From: ${range.from}\nTo: ${range.to}`);
             console.table(range.timeframes);});
  } else {
      // error
      console.log(result);
  }
 });
