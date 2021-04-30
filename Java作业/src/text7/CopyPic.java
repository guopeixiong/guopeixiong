package text7;

import java.io.*;
import java.util.Scanner;

public class CopyPic {
    private String srcPath,dstPath;
    public CopyPic(String srcPath,String dstPath){
        this.srcPath = srcPath;
        this.dstPath = dstPath;
    }
    public int detect(){
        File src = new File(this.srcPath);
        File des = new File(this.dstPath);
        if (src.exists() && src.isFile()){
            return 1;
        }
        return 0;
    }
    public int copy(){
        int i=this.detect();
        InputStream in = null;
        OutputStream out = null;
        if (i==1){
            try {
                in = new FileInputStream(new File(srcPath));
                out = new FileOutputStream(new File(dstPath+"\\(复制版)"+copyFiletype(srcPath)));
                byte[] buffer=new byte[1024];
                int len;
                while ((len=in.read(buffer))!=-1){
                    out.write(buffer,0,len);
                }
                return 1;
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
    public static String copyFiletype(String str){
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
    }
}
