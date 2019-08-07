package demo.crawler;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Project: SomethingAboutJava
 * Package: demo.crawler
 * Author: Alan Ruan
 * Date: 2019-04-30  14:53
 * Description: //TODO  请求URL
 */
public class HttpClientDemo {

    public static void main(String[] args) throws Exception {

        //创建默认的客户端实例
        CloseableHttpClient  httpClient = HttpClients.createDefault();

        //创建get请求实例
        HttpGet httpGet = new HttpGet("http://www.bing.com");
        System.out.println("executing request " + httpGet.getURI());

        try{

            //客户端执行get请求返回响应
            CloseableHttpResponse response = httpClient.execute(httpGet);

            //服务器响应状态行
            System.out.println(response.getStatusLine().toString());

            Header[] headers = response.getAllHeaders();
            System.out.println(response.getHeaders("Content-Type"));

            //打印所有响应头
            for (Header header : headers){
                System.out.println(header.getName() + ":" + header.getValue());
            }

        }finally {
            httpClient.close();
        }

    }

}
