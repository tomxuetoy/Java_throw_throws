// The original code below is from web link: http://blog.csdn.net/microtong/article/details/4769646
package cn.edu.uibe.exp;  
  
class MyExp extends Exception{  
  
    private static final long serialVersionUID = 1L;  
      
    MyExp(){  
        super("自定义异常");  
    }  
      
}  
public class Exp2 {  
  
    public void f1(int n) {  
        System.out.println("f1前面");  
        f2(n);  
        System.out.println("f1后面");  
  
    }  
  
    public void f2(int n) {  
        System.out.println("f2前面");  
        try{  
           System.out.println("try的前面");  
           f3(n);  
           System.out.println("try的后面"); //发生异常时不会输出  
        }catch(MyExp e){  
            System.err.println(e.getMessage());  
        }finally{  
            System.out.println("无论是否发生异常");  
        }  
        System.out.println("f2后面");  
    }  
  
    public void f3(int n) throws MyExp{  
        System.out.println("f3前面");  
        f4(n);  
        System.out.println("f3后面"); //发生异常时不会输出  
    }  
  
    public void f4(int n) throws MyExp{  
        System.out.println("f4前面");  
        if(n<0){  
            throw new MyExp();  
        }  
        System.out.println(n); //发生异常时不会输出  
        System.out.println("f4后面"); //发生异常时不会输出  
    }  
  
    public static void main(String[] args) {  
          
        Exp2 exp = new Exp2();  
        exp.f1(-4);  
  
    }  
  
}  
