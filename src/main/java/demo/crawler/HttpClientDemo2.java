package demo.crawler;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Project: SomethingAboutJava
 * Package: demo.crawler
 * Author: Alan Ruan
 * Date: 2019-04-30  15:43
 * Description: //TODO  返回响应
 */
public class HttpClientDemo2 {

    public static void main(String[] args) {

        //创建客户端
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        //创建请求get实例
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //添加头部信息模拟浏览器访问
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml," +
                "application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36" +
                " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        try {
            //客户端执行httpGet方法,返回响应
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);

            //得到服务响应状态码
            if (response.getStatusLine().getStatusCode() == 200){
                //得到响应实体
                String entity = EntityUtils.toString(response.getEntity(), "utf-8");

            }else {
                //如果是其他状态码则做其他处理
            }
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
