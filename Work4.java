package homework1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class Work4 {
	String sheng;
	String shi;
	int num;

	public void setsheng(String sheng) {
		this.sheng = sheng;
	}

	public void setshi(String shi) {
		this.shi = shi;
	}

	public void setnum(int i) {
		this.num = i;
	}

	public String getsheng() {
		return sheng;
	}

	public String getshi() {
		return shi;
	}

	public int getnum() {
		return num;
	}

	public static void main(String[] args) {
		Collator collator=Collator.getInstance(Locale.CHINA);
		char ch[] = new char[10000];
		int sum1[]=new int[1000];//每个省的位置
		int sum[] =new int[1000];//每个省的个数
		int sum2[]=new int[99];//每个省的总和
		int n = 0,m=0;
		String z ="";
		Scanner in = new Scanner(System.in);
		File file1 = new File("C://Text//yp_in.txt");
		 File file2 = new File("C://Text//yp_out_05.txt");
		FileWriter fwriter = null;
		FileReader freader = null;
		try {
			Work[] work = new Work[1000];
			freader = new FileReader(file1);
			 fwriter=new FileWriter(file2);
			int count = freader.read(ch);

			for (int i = 0; i < count;) {
				work[n] = new Work();

				while (ch[i] != '	') {
					z += String.valueOf(ch[i]);
					i++;
				}
				work[n].setsheng(z);
				

				z = "";
				i++;

				while (ch[i] != '	') {
					z += String.valueOf(ch[i]);

					i++;
				}
				work[n].setshi(z);
				z = "";
				i++;

				while (ch[i] >= 48 && ch[i] <= 57) {
					z += String.valueOf(ch[i]);
					i++;
				}
				work[n].setnum(Integer.parseInt(z));
				z = "";

				n++;
			}
			
			
			int k=0,i=0;sum2[i]=0;
			String a=work[0].getsheng();
			for(i=0;i<n;i++){
				sum2[k]+=work[i].getnum();
				if(!work[i].getsheng().equals(a)){
					sum[k]=i-m;	sum1[k]=i;
					m=i;
					k++;
			
					a=work[i].getsheng();
				
				}
			}
			
			sum[k]=i-m;sum1[k]=i;
			
			Work work1=new Work();
	int j=0;int l;
			for(i=0;i<=k;i++){
				int n1=0;
				for(;n1<=sum[i];j++){
					n1++;
					
					for(l=j+1;l<sum1[i];l++){
			
						if(work[l].getnum()>work[j].getnum()){
							
							work1=work[j];
							work[j]=work[l];
							work[l]=work1;
							
						}
						else if(work[l].getnum()==work[j].getnum()){
									
							if(collator.compare(work[j].getshi(), work[l].getshi())>0){								
								work1=work[l];
								work[l]=work[j];
								work[j]=work1;
							}
						}
							
					}
				}
				
			}
			j=0;
for(i=0;i<=k;i++){
	fwriter.write(work[j].getsheng()+"	"+sum2[i]+'\r');
	for(;j<sum1[i];j++){
		fwriter.write(work[j].getshi()+"	"+work[j].getnum()+'\r');
		
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