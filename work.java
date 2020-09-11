package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class work {
	public static void main(String[] args) {
		File file1 = new File("C://Text//yp_in.txt");
		File file2 = new File("C://Text//yp_out.txt");
		FileWriter fwriter = null;
		FileReader freader = null;
		try {
			freader = new FileReader(file1);//			创建freader读入文件
			fwriter = new FileWriter(file2);//			创建fwriter写入文件
			char ch[] = new char[9999];//               创建字符数组ch[]
			String sh[] = new String[9999];//           创建字符串数组ch[]
			int count, j, sum, n = 0;
			count = freader.read(ch);//                 读出字符个数
			String z,a = "省";
			char b = a.charAt(0);//			提取关键字省

			for (int i = 0; i < count; i++) {
				if (ch[i + 2] == b) {
					z = String.valueOf(ch[i]) + String.valueOf(ch[i + 1]);//        导出省份前两个字
					i += 3;
					sum = 0;
					for (j = 0; j <= n; j++) {
						if (z.equals(sh[j])) {
							sum++;//            通过sum是否等于0判断是否为新的省
						}
					}
					if (sum == 0) {
						sh[n] = z;
						fwriter.write('\r' + z + a + '\r');// 写入新的省
					}
					n++;
				} else
					while (ch[i + 3] != b && i <= count) {
						fwriter.write(ch[i]); //  写出省外的内容
						i++;
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
