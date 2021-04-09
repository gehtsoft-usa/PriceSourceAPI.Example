PriceHistory Java samples

Brief
==================================================================================
These sample Java projects show how to do basic operations with the PriceHistory 
service (https://pricearchive-fxcm-api.gehtsoft.com)

1. GetInstrumentsApp
   This sample shows how to get a list of available instruments. 

2. GetAllRangesApp
   This sample shows how to get a list of instruments with available timeframes 
   and time periods for getting historical prices.

3. GetPricesRangeApp
   This sample shows how to get the available time period for getting historical 
   prices for a specified instrument and timeframe.

4. GetPricesApp
   This sample shows how to load historical prices for a specified instrument, 
   timeframe and time period.

Dependencies
==================================================================================
gehtsoft.pricearchive.client
This library is stored in Gehtsoft public maven repository.

de.vandermeer
This library is stored in central maven repository.

Installation
==================================================================================
To build:
 - Have JDK 12+
 - Have maven
 - Have javac and mvn available via path

Build jar for running samples:
 - mvn clean package

Running samples
==================================================================================
GetInstruments.bat
GetAllRanges.bat
GetPricesRange.bat
GetPrices.bat

Documentation 
==================================================================================
http://docs.gehtsoftusa.com/pricesourceapi

License
==================================================================================
All examples published in this repository are under Apache 2.0 license. 
