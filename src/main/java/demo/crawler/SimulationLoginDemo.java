package demo.crawler;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: SomethingAboutJava
 * Package: demo.crawler
 * Author: Alan Ruan
 * Date: 2019-04-30  17:22
 * Description: //TODO  * 模拟登录人人网
 *  *
 *  * 提示：我们在模拟登录之前都要先手动登录然后通过抓包查看登录成功需要给对方服务器发送哪些参数，
 *  然后我们将这些参数进行提取，通过Post方法发送给对方服务器
 *
 */
public class SimulationLoginDemo {

    public static void main(String[] args) {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.renren.com");

        //创建参数列表
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("domain", "renren.com"));
        nameValuePairs.add(new BasicNameValuePair("isplogin", "true"));
        nameValuePairs.add(new BasicNameValuePair("submit", "登录"));
        nameValuePairs.add(new BasicNameValuePair("email", ""));
        nameValuePairs.add(new BasicNameValuePair("passwd", ""));

        try{
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF8"));
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);

            //如果模拟登录成功
            if (response.getStatusLine().getStatusCode() == 200){
                Header[] headers = response.getAllHeaders();

                for (Header header : headers){
                    System.out.println(header.getName() + ": " + header.getValue());
                }

            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //释放资源
            httpPost.abort();
        }

    }

}
