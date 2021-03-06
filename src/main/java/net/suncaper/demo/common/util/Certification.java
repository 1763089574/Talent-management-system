package net.suncaper.demo.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;




public class Certification {

    public static void main(String[] args)  {
        String appcode = "f9d7ccf5fc9d400092b7e76e713360c0";
        String url = "http://yingye.market.alicloudapi.com/CreditValid";
        String imageurl = "http://storage.api51.cn/demo/yyzz.jpg";
        String params= "image="+imageurl;

        //发送 POST 请求
        String sr=Certification.sendPost(url, params,appcode);
        System.out.println(sr);
        /*
		返回示例
		{
			"code": 1000,
			"name": "西安网极网络科技有限公司",
			"credit": "91610138397119703K",
			"ifCreditValid": true,//是否通过验证，验证营业执照有效性！
			"expirationDate": "2014年05月30日至长期",
			"establishDate": "2014年05月30日",
			"address": "陕西省西安市国家民用航天产业基地神舟四路239号2栋5层501-A04",
			"companyType": "有限责任公司(自然人投资或控股)",
			"capital": "壹佰万元人民币",
			"businessScope": "软件设计与开发;企业信息化服务;网络工程设计施工;网站设计与开发;计算机软硬件销售;计算机技术开发、技术服务;商标、版权、著作权、专利的代理及转让;广告的设计、制作、代理、发布.(依法须经批准的项目,经相关部门批准后方可开展经营活动)",

		}
		*/




    }
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, String appcode) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Authorization", "APPCODE "+appcode);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }





}