This is a sample application demonstrating the use of a few different libraries and tools for resilience and chaos engineering.

The features are introduced gradually using the following branches:

* [01_SimpleService](../../tree/01_Simple_Service)
* [02_WireMock](../../tree/02_WireMock)
* [03_ChaosToolkit](../../tree/03_ChaosToolkit)
* [04_Resilience4j_Faults](../../tree/04_Resilience4j_Faults)
* [05_Resilience4j_Faults_And_Delays](../../tree/05_Resilience4j_Faults_And_Delays)
* [06_ChaosMonkey](../../tree/06_ChaosMonkey)


Each branch contains a Spring Boot application with progressively more fleshed out app code and configuration to handle faults and simulate faults for testing.

The app consists of 1 REST controller that returns a stock price. To retrieve stock prices two different free services are used.

* AlphaVantage: https://www.alphavantage.co/
* WorldTradingData: https://www.worldtradingdata.com/

To execute the samples you will need to register for a free account on both sites and pass the following environment variables to the app:
* ALPHAVANTAGE_API_KEY
* WORLDTRADINGDATA_API_KEY

If you have questions reach out to me here or connect on [LinkedIn](https://www.linkedin.com/in/ericwyles/).

Continue to [01_SimpleService](../../tree/01_Simple_Service)



