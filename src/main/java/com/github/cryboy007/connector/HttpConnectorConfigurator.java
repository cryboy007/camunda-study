package com.github.cryboy007.connector;

import connectjar.org.apache.http.impl.client.CloseableHttpClient;
import connectjar.org.apache.http.impl.client.HttpClients;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.impl.AbstractHttpConnector;
import org.camunda.connect.spi.ConnectorConfigurator;

/**
 * @ClassName HttpConnectorConfigurator
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/14 15:13
 */
public class HttpConnectorConfigurator implements ConnectorConfigurator<HttpConnector> {
    public Class<HttpConnector> getConnectorClass() {
        return HttpConnector.class;
    }

    public void configure(HttpConnector connector) {
        CloseableHttpClient client = HttpClients.custom()
                .setMaxConnPerRoute(10)
                .setMaxConnTotal(200)
                .build();
        ((AbstractHttpConnector) connector).setHttpClient(client);
    }
}
