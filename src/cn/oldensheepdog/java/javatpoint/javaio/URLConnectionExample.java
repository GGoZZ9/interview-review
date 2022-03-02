package cn.oldensheepdog.java.javatpoint.javaio;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 * http status code 不在http header里
 *
 * */
public class URLConnectionExample {
    public static void main(String[] args) {
        try{
            URL url=new URL("http://www.baidu.com");
            URLConnection urlcon=url.openConnection();
            InputStreamReader stream=new InputStreamReader(urlcon.getInputStream(), "UTF-8");
            int i;
            while((i=stream.read())!=-1){
                System.out.print((char)i);
            }
        }catch(Exception e){System.out.println(e);}

        System.out.println("+++++++++++++++++++++++++++++++++++\n");
        try{
            URL url=new URL("http://www.baidu.com");
            HttpURLConnection huc=(HttpURLConnection)url.openConnection();
            for(int i=1;i<=8;i++){
                System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));
            }
            huc.disconnect();
        }catch(Exception e){System.out.println(e);}

        System.out.println("+++++++++++++++++++++++++++++++++++\n");

        try{
            InetAddress ip= InetAddress.getByName("www.javatpoint.com");

            System.out.println("Host Name: "+ip.getHostName());
            System.out.println("IP Address: "+ip.getHostAddress());
        }catch(Exception e){System.out.println(e);}
    }


}

