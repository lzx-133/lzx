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
		System.out.println("�������ַ");
		String dizi=in.next();
		File file2 = new File(dizi);
		FileWriter fwriter = null;
		FileReader freader = null;
		try {
			freader = new FileReader(file1);// ����freader�����ļ�
     		fwriter = new FileWriter(file2);// ����fwriterд���ļ�
			char ch[] = new char[9999];// �����ַ�����ch[]
			String fh[] = new String[9999];
			String sh[] = new String[9999];// �����ַ�������ch[]
			int count, j, sum, n = 0;
			count = freader.read(ch);// �����ַ�����
			String z, a= "ʡ";;
			char b = a.charAt(0);// ��ȡ�ؼ���ʡ
			for(int s=0;s<count;s++){
				fh[s]="";
			}
			for (int i = 0; i < count; i++) {
						z = String.valueOf(ch[i]) + String.valueOf(ch[i + 1]);// ����ʡ��ǰ������		
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
			System.out.println("������Ҫ�����ʡ�ݣ� ");
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
