This version of the app is quite a bit different.

The WireMock and ChaosToolkit are gone. Now we have Chaos Moneky For Spring Boot running inside the app randomly introducing failures and delays.

![branch](branch.png?raw=true)

The configuration from the application yaml is:

```
chaos:
  monkey:
    enabled: true
    watcher:
      component: true
      controller: true
      repository: true
      rest-controller: true
      service: true
    assaults:
      level: 3
      latency-active: true
      latency-range-end: 10000
      latency-range-start: 3500
      exceptions-active: true
      watched-custom-services:
      - com.ericwyles.chaosengineeringdemo.alphavantage.AlphaVantageService.getPrice
```


To run this version you will need an api key for AlphaVantage.

You can get a license key here: https://www.alphavantage.co/support/#api-key

And set it in the ALPHAVANTAGE_API_KEY environment variable when launching the app.

With this version, all calls to alphavantage go through a wiremock.


To run this version you will need an api key for WorldTradingData.

You can get a license key here: https://www.worldtradingdata.com/

And set it in the WORLDTRADINGDATA_API_KEY environment variable when launching the app.


Start the app. The app should still handle faults well but the faults will be random. Use postman and observer the application logs.
