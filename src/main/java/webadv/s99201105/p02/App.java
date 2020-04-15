package webadv.s99201105.p02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) throws IOException {
//        if (args.length < 1) {
//            System.err.println("Please provide an input!");
//            System.exit(0);
//        }
//        System.out.println(sha256hex(args[0]));
    	Scanner sc = new Scanner(System.in);
    	System.out.println("input acount..");
    	String acount = sc.nextLine();
    	System.out.println("input password..");
    	String psw = sc.nextLine();
    	if(check(acount,psw)) {
    		System.out.println("登录成功");
    	}
    	else {
    		System.out.println("密码输入错误");
    	}

    }
    
    public static boolean check(String acount,String psw) throws IOException {
    	FileInputStream fo = new FileInputStream("data.txt");
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fo));
        String line;
        while ((line=bufferedReader.readLine()) != null){
            String[] c = line.split(" ");
            if(c[0].equals(acount) && c[1].equals(sha256hex(psw))) {
            	return true;
            }
        }
        return false;
    }
    
    
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
