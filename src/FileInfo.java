import java.util.Scanner;


public class FileInfo {
	String path;
	String file_mask;
	Scanner sn = new Scanner(System.in);

	public void data_read()
	{
		System.out.println("Enter file path: "); //method to get file path and mask from user
		path=sn.nextLine();
		System.out.println("Enter file mask: ");
		file_mask=sn.nextLine();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileFinder file_f = new FileFinder(); 
		FileInfo fi = new FileInfo(); 
		fi.data_read();  // calling method to retrieve file data from user
		file_f.get_files_list(fi.path,fi.file_mask); // calling method that will return list of files based on file path and mask
	}

}
