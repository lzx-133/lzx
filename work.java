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
			freader = new FileReader(file1);//			����freader�����ļ�
			fwriter = new FileWriter(file2);//			����fwriterд���ļ�
			char ch[] = new char[9999];//               �����ַ�����ch[]
			String sh[] = new String[9999];//           �����ַ�������ch[]
			int count, j, sum, n = 0;
			count = freader.read(ch);//                 �����ַ�����
			String z,a = "ʡ";
			char b = a.charAt(0);//			��ȡ�ؼ���ʡ

			for (int i = 0; i < count; i++) {
				if (ch[i + 2] == b) {
					z = String.valueOf(ch[i]) + String.valueOf(ch[i + 1]);//        ����ʡ��ǰ������
					i += 3;
					sum = 0;
					for (j = 0; j <= n; j++) {
						if (z.equals(sh[j])) {
							sum++;//            ͨ��sum�Ƿ����0�ж��Ƿ�Ϊ�µ�ʡ
						}
					}
					if (sum == 0) {
						sh[n] = z;
						fwriter.write('\r' + z + a + '\r');// д���µ�ʡ
					}
					n++;
				} else
					while (ch[i + 3] != b && i <= count) {
						fwriter.write(ch[i]); //  д��ʡ�������
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
