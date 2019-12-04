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

Start the app. The app should still handle faults well but the faults will be random.

Use postman and observe the application logs. You should see failures happening randomly but the application should handle them and give you a stock price.

