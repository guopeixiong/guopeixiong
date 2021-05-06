package test8;

import java.io.*;
import java.util.Scanner;

public class CopyPic {
    private String srcPath;
    private String dstPath;
    public CopyPic(String srcPath,String dstPath){
        this.srcPath = srcPath;
        this.dstPath = dstPath;
    }
    //判断源文件是否存在且目的地址是一个目录
    public int detect(){
        File src = new File(this.srcPath);
        File des = new File(this.dstPath);
        if (src.exists() && src.isFile()){
            if (des.exists() && des.isDirectory()){
                return 1;
            }
            return 0;
        }
        return 0;
    }
    public int copy(){
        //返回判断后的值后续判断是否进行复制
        int i = this.detect();
        FileReader in = null;
        FileWriter out = null;
        File src = null;
        File dst = null;
        //判断后地址及文件无误,开始复制
        if (i == 1){
            try {
                in = new FileReader(src = new File(srcPath));
                //获取复制路径后获取复制的文件名,在复制目的地中被复制的文件文件名与源文件相同但在文件名前加了个(复制版)
                out = new FileWriter(dst = new File(dstPath+"\\"+"(复制版)"+src.getName()));
                char[] buffer = new char[128];
                int len;//记录每次读取的字节数,方便后续写入
                while ((len = in.read(buffer)) != -1){
                    out.write(buffer,0,len);
                }
                return 1;//复制结束,返回1
            }catch (IOException e){
                return 0;
            }finally {
                if (in != null){
                    try {
                        in.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if (out != null){
                    try {
                        out.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return 0;
    }
    public  String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getDstPath() {
        return dstPath;
    }

    public void setDstPath(String dstPath) {
        this.dstPath = dstPath;
    }
}
class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件地址:");
        String src = scanner.nextLine();
        System.out.println("请输入复制目的地址:");
        String dst = scanner.nextLine();
        text7.CopyPic copy = new text7.CopyPic(src,dst);
        System.out.println(copy.copy());
        scanner.close();
    }
}
