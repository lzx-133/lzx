package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class work3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		File file1 = new File("C://Text//yp_in.txt");
		System.out.println("请输入地址");
		String dizi=in.next();
		File file2 = new File(dizi);
		FileWriter fwriter = null;
		FileReader freader = null;
		try {
			freader = new FileReader(file1);// 创建freader读入文件
     		fwriter = new FileWriter(file2);// 创建fwriter写入文件
			char ch[] = new char[9999];// 创建字符数组ch[]
			String fh[] = new String[9999];
			String sh[] = new String[9999];// 创建字符串数组ch[]
			int count, j, sum, n = 0;
			count = freader.read(ch);// 读出字符个数
			String z, a= "省";;
			char b = a.charAt(0);// 提取关键字省
			for(int s=0;s<count;s++){
				fh[s]="";
			}
			for (int i = 0; i < count; i++) {
						z = String.valueOf(ch[i]) + String.valueOf(ch[i + 1]);// 导出省份前两个字		
					sum = 0;
					if(ch[i+2]==b){
					for (j = 0; j <= n; j++) {
						
					if ((z+a).equals(sh[j])) {
							sum++;
							i+=4;}
					
				}	
						if (sum == 0) {
							sh[n] = z+a;
							i += 4;	
						
							n++;
						}}
						fh[n-1]+=String.valueOf(ch[i]);	
					}
			System.out.println("请输入要输出的省份： ");
			String Namee = in.next();
			for (int k = 0; k <= n; k++) {
				if (Namee.equals(sh[k])) {

					System.out.println(sh[k]+'\r'+fh[k]);
					fwriter.write(sh[k]+'\r'+fh[k]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fwriter != null) {
				try {
					fwriter.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
}
