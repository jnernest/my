package utils;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class ClientUtils {

    public static ClientConfig newConfig() {
        ClientConfig config = new ClientConfig()
                .connectorProvider(new ApacheConnectorProvider())
                .property(ClientProperties.CONNECT_TIMEOUT, 10000)
                .property(ClientProperties.READ_TIMEOUT, 100000);

        ConfigUtils.getProxy().ifPresent(p -> config.property(ClientProperties.PROXY_URI, p));

        return config;
    }

    public static Client newClient() {
        return ClientBuilder.newBuilder()
                .withConfig(newConfig())
                .sslContext(newContext())
                .hostnameVerifier((h, s) -> true)
                .build();
    }

    public static SSLContext newContext() {
        try {
            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String auth) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String auth) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, null);
            return context;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Response get(String uri, Object... args) {
        return newClient().target(String.format(uri, args)).request().get();
    }
}
