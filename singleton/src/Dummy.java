import java.io.File;


public class Dummy
{
	static String filePath="E://New folder";
	static int s=1;
	static String fileName;
	public static void main(String a[])
	{
		File f = new File( filePath );
		for(File ft : f.listFiles())
		{
			fileName=ft.getParentFile().getAbsolutePath() + "\\Image0"+s+".jpg";
			s++;
			ft.renameTo( new File(fileName) );
			System.out.println(fileName);
		}
	}
}
