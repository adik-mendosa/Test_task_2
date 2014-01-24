import java.io.File;
import java.io.IOException;

public class FileFinder {
	File file_path;
	FileInfo fi = new FileInfo();
	Boolean noerr = false;
	String regex;

	public void get_files_list (String path, String mask) {
		// checking received data if path or mask invalid then exception will be throwed.
		do	
			try 
		{
				file_path= new File(path);
				if (file_path.exists() && mask.matches("[^!@#$%&()+=`].*[a-zA-Zà-ÿÀ-ÿ]*[^!@#$%&()+=`]" ) || (file_path.exists() && mask.equals("*")))	
					noerr=true;
				else
					throw new IOException();	
		}
		catch (Exception e) //catching exception if data invalid, user will see message and reenter data.
		{
			System.out.println("Incorrect input data please try again...");
			fi.data_read();
			path=fi.path;
			mask=fi.file_mask;
		} while (noerr==false);

		File[] file_list = file_path.listFiles(); //creating array of Files that includes info about files 

		if (file_list == null)   return;
		for ( File f : file_list ) 
		{
			if ( f.isDirectory() ) {
				get_files_list( f.getAbsolutePath(),mask); //if directory found method get_file_list calls again with directory name
				                                          // forming recursion 
			}
			else {
				regex="("+mask.replace("_",".")+")"; //if file found file's name compares with reg.exp. formed by mask if matches 
				regex=regex.replace("*",".*");      //program will retrieve and print out info about this file absolute path + name.
				if(f.getName().toString().matches(regex))
					System.out.println(f.getAbsoluteFile());
			}
		}
	}


}


