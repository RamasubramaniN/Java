import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileReplace
{
	HashMap<String, String> keyHash = new HashMap<String, String>();

	private static void fillMap( File file ) throws IOException
	{
		String s = new String();
		if ( file.isDirectory() )
		{
			for ( File filePath : file.listFiles() )
			{
				String path = filePath.getAbsolutePath();
				File file1 = new File( path.substring( 0, path.length() - 5 ).concat( "1.txt" ) );
				FileWriter fwr = new FileWriter( file1 );
				FileReader f = new FileReader( filePath );
				BufferedReader bufReader = new BufferedReader( f );
			   /* BufferedReader reads text from a character-input stream, buffering characters so as to provide 
				  for the efficient reading of characters, arrays, and lines. The buffer size may be specified, 
				  or the default size may be used. The default is large enough for most purposes */
				do
				{
					s = ( bufReader.readLine() );
					if ( s != null )
					{
						s = s.toString().replace( "Array", "Structure" );
						fwr.write( s.toString() );
					}
				}
				while ( s != null );
				bufReader.close();
				f.close();
				fwr.close();
				System.out.println( filePath.delete() );
				System.out.println( file1.renameTo( filePath ) );
			}
		}
	}

	public static void main( String a[] ) throws IOException
	{
		File file = new File( "C://Users/ramasubramanin/Desktop/super" );
		fillMap( file );
		System.out.println( "completed" );
	}
}
