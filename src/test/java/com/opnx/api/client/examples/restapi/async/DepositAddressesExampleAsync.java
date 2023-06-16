package com.opnx.api.client.examples.restapi.async;


import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.config.OpnxApiConfig;


public class DepositAddressesExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getDepositAddresses("USDT", "0xD25bCD2DBb6114d3BB29CE946a6356B49911358e",
                response -> System.out.println(response));

    }

}
