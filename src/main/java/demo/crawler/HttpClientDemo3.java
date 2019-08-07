package demo.crawler;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Project: SomethingAboutJava
 * Package: demo.crawler
 * Author: Alan Ruan
 * Date: 2019-04-30  17:03
 * Description: //TODO 添加头部cookie模拟登录
 */
public class HttpClientDemo3 {

    public static void main(String[] args) throws Exception{
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //设置头部信息进行模拟登录（添加登录后的Cookie）
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml," +
                "application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");

        httpGet.setHeader("Cookie", "BAIDUID=6AF2EE8C0C96488A306D58DDE5F83205:FG=1; BIDUPSID=6AF2EE8C0C96488A306D58DDE5F83205; PSTM=1544770270; BDUSS=1J4YkViQkJOcUVUaTZZOWRBNEM3NE5uOHN0Q05DQzE0c1Y5UHpRNFgtWnpYNXhjQUFBQUFBJCQAAAAAAAAAAAEAAAAcsKlr0rvI57n-uf65~rn-AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHPSdFxz0nRcc; pgv_pvi=8758500352; BD_HOME=1; H_PS_PSSID=26522_1450_21089_20698_28767_28722_28964_28830_28585; BD_UPN=12314753; sugstore=0");

        httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36" +
                " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");



        try {
            //客户端执行httpGet方法，返回响应
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

            //得到服务响应状态码
            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
                //打印所有响应头
                Header[] headers = closeableHttpResponse.getAllHeaders();
                for (Header header : headers) {
                    System.out.println(header.getName() + ": " + header.getValue());
                }
            }
            else {
                //如果是其他状态码则做其他处理
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeableHttpClient.close();
        }
    }

    }


