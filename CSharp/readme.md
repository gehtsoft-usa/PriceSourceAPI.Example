PriceHistory C# samples

Brief
==================================================================================
These sample C# projects show how to do basic operations with the PriceHistory 
service (https://pricearchiveapi.gehtsoft.com)

1. GetInstruments
   This sample shows how to get a list of available instruments. 

2. GetAllRanges
   This sample shows how to get a list of instruments with available timeframes 
   and time periods for getting historical prices.

3. GetPricesRange
   This sample shows how to get the available time period for getting historical 
   prices for a specified instrument and timeframe.

4. GetPrices
   This sample shows how to load historical prices for a specified instrument, 
   timeframe and time period.

Dependencies
==================================================================================
Gehtsoft.PriceArchive.Client.dll
This library is stored in Gehtsoft public nuget repository.
It is set in NuGet.config

ConsoleTable.dll
This library is stored in nuget.org repository.
It is set in NuGet.config

Installation
==================================================================================
Load this solution in VS 2019 and build all.

Running samples
==================================================================================
...\CSharp\GetInstruments\bin\Debug\netcoreapp3.1\GetInstruments.exe
...\CSharp\GetAllRanges\bin\Debug\netcoreapp3.1\GetAllRanges.exe
...\CSharp\GetPricesRange\bin\Debug\netcoreapp3.1\GetPricesRange.exe
...\CSharp\GetPrices\bin\Debug\netcoreapp3.1\GetPrices.exe

Documentation 
==================================================================================
http://docs.gehtsoftusa.com/pricesourceapi/web-content.html#cs.html

License
==================================================================================
All examples published in this repository are under Apache 2.0 license. 
