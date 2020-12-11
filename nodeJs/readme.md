PriceHistory NodeJs samples

Brief
==================================================================================
These samples show how to do basic operations with the PriceHistory 
service (https://pricearchiveapi.gehtsoft.com)

1. GetInstruments.js
   This sample shows how to get a list of available instruments. 

2. GetAllRanges.js
   This sample shows how to get a list of instruments with available timeframes 
   and time periods for getting historical prices.

3. GetPricesRange.js
   This sample shows how to get the available time period for getting historical 
   prices for a specified instrument and timeframe.

4. GetPrices.js
   This sample shows how to load historical prices for a specified instrument, 
   timeframe and time period.

Dependencies
==================================================================================
To run these samples, you will need the last stable version of Node.js 
You can download Node.js from https://nodejs.org/en/download/

Installation
==================================================================================
npm install price-archive

The file .npmrc contains an alternative path to the package manager which contains 
the priceHistory nodeJs client.

Running samples
==================================================================================
node GetInstruments.js
node GetAllRanges.js
node GetPricesRange.js
node GetPrices.js

Documentation 
==================================================================================
http://docs.gehtsoftusa.com/pricesourceapi/web-content.html#js.html

License
==================================================================================
All examples published in this repository are under Apache 2.0 license. 
