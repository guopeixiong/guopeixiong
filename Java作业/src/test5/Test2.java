package test5;

public class Test2 {
    public static double getMoney(String s){
        String[] split = s.split("\n");
        double sum=0.0;
        for (int i=0;i<split.length;i++){
            String s1 = split[i].replaceAll("[^0-9.]","*");
            if (!s1.matches("[*]+?")){
            String[] split1 = s1.split("[*]+");
                //返回的字符串数组中单价和总数在三个第二和第所以下面的计算使用的下标是1和2
                sum+=Double.parseDouble(split1[1])*Double.parseDouble(split1[2]);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        double money = getMoney("物品\t单价\t数量\r\n铅笔\t1.5\t10\r\n苹果\t5.6\t4\r\n青菜\t2.0\t5");
        System.out.println("总价:"+money);
    }
}
