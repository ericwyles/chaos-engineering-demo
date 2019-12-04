In this version, the app is unchanged, but we've introduced a [WireMock](http://wiremock.org/) between the app and the remote service.

![branch2](branch.png)

To run this version you will need an api key for AlphaVantage.

You can get a license key here: https://www.alphavantage.co/support/#api-key

And set it in the ALPHAVANTAGE_API_KEY environment variable when launching the app.

With this version, all calls to alphavantage to through a wiremock.

Start it using this command from the 'wiremock' directory

```
./run_wire_mock.sh
```

With the wire mock in place we can now simulate failures of the service and see how our app behaves.

