import java.io.File;
import java.util.ArrayList;

public class FileHelper
{

	String key = null;
	String rootFolder = null;
	ArrayList<String> fileNames;
	ArrayList<String> directoryNames;

	FileHelper( String key, String directoryPath )
	{
		this.key = key;
		this.rootFolder = directoryPath;
		fileNames = new ArrayList<String>();
		directoryNames = new ArrayList<String>();
	}

	void getFileNames()
	{
		getFileNames( rootFolder );
		System.out.println( "----------------------------Files------------------------------" );
		for ( String s : fileNames )
			System.out.println( s );
		System.out.println( "----------------------------Directories------------------------------" );
		for ( String s : directoryNames )
			System.out.println( s );
		System.out.println( "Total Files : " + fileNames.size() );
		System.out.println( "Total Directories : " + directoryNames.size() );
	}

	void getFileNames( String path )
	{

		File file = new File( path );
		if ( file.isDirectory() )
		{
			for ( File f : file.listFiles() )
			{
				if ( f.isDirectory() )
				{
					directoryNames.add( f.getAbsolutePath() );
					this.getFileNames( f.getAbsolutePath() );
				}
				else if ( f.isFile() )
					fileNames.add( f.getAbsolutePath() );
			}
		}
		else
			System.out.println( "Please enter valid directory path" );
	}
}
