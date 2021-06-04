package text11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author guopeixiong
 * @Date 2021/6/4 13:17
 */
public class Sever {
    public static void main(String[] args) {
        ServerSocket serverForClient;
        Socket socketOnServer;
        BufferedReader br;
        String str;
        try {
            System.out.println("等待客户端呼叫...");
            serverForClient = new ServerSocket(4500);
            socketOnServer = serverForClient.accept();
            br = new BufferedReader(new InputStreamReader(socketOnServer.getInputStream()));
            System.out.println("客户连接成功...");
            while ((str=br.readLine())!=null){
                System.out.println("收到客户端消息:"+str);
                Thread.sleep(1000);
            }
            br.close();
            System.out.println("客户断开连接...");
        } catch (Exception e) {
            System.out.println("客户连接失败...");
        }
    }
}
class Client{
    public static void main(String[] args) {
        Socket socket;
        String strs[]={"你好","我是客户端"};
        BufferedWriter bw;
        try {
            socket = new Socket("localhost",4500);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("连接服务器成功...");
            for (int i =0;i<strs.length;i++){
                bw.write(strs[i]);
                bw.newLine();
                System.out.println("向服务器发送消息:"+strs[i]);
                Thread.sleep(500);
            }
            bw.close();
            System.out.println("断开服务器连接...");
        } catch (Exception e) {
            System.out.println("连接服务器失败...");
        }
    }
}
