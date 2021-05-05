package text7;

import java.io.*;
import java.util.Scanner;

public class CopyPic {
    private String srcPath,dstPath;
    public CopyPic(String srcPath,String dstPath){
        this.srcPath = srcPath;
        this.dstPath = dstPath;
    }
    //判断源文件是否存在且目的地址是一个目录
    public int detect(){
        File src = new File(this.srcPath);
        File des = new File(this.dstPath);
        if (src.exists() && src.isFile()){
            if (des.isDirectory()){
                return 1;
            }
            return 0;
        }
        return 0;
    }
    public int copy(){
        //返回判断后的值后续判断是否进行复制
        int i=this.detect();
        InputStream in = null;
        OutputStream out = null;
        //判断后地址及文件无误,开始复制
        if (i==1){
            try {
                in = new FileInputStream(new File(srcPath));
                //获取复制路径后获取复制的文件类型,在复制目的地中被复制的文件文件名与源文件相同但在文件名前加了个(复制版)
                out = new FileOutputStream(new File(dstPath+"\\(复制版)"+getCopyFiletype(srcPath)));
                byte[] buffer=new byte[1024];
                int len;//记录每次读取的字节数,方便后续写入
                while ((len=in.read(buffer))!=-1){
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
    //获取要复制的文件的类型
    public static String getCopyFiletype(String str){
        return str.substring(str.lastIndexOf("\\")+1);
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
        CopyPic copy = new CopyPic(src,dst);
        System.out.println(copy.copy());
        scanner.close();
    }
}
