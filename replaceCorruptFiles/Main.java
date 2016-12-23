

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Main {

	public static void main(String[] args){
		Main main = new Main();
		main.run();

	}
	
	private void run(){
		
		
		LsRepMini ls = new LsRepMini();

		System.out.println("dossier 1");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("dossier 2");
		String a = keyboard.next();
		Scanner keyboard2 = new Scanner(System.in);

		String b = keyboard2.next();
		ArrayList<File> fichierARelative = ls.getRelativeFile(a);
		ArrayList<File> fichierBRelative = ls.getRelativeFile(b);
		for(File f : fichierARelative){
			if(f.length()<1){	
				remplacerFile(f,fichierBRelative);
			}
			System.out.println(f);
		}
	
		
		
		
		
	}
	
	
	private void remplacerFile(File f,ArrayList<File> b) {
		for(File ff : b){
			if(ff.length()>0 && ff.toString().substring(ff.toString().indexOf("/")).equals(f.toString().substring(f.toString().indexOf("/")))){
				try{
					System.out.println("copie en cour");
				copy(ff,f);
				}catch (Exception e) {
					System.out.println("erreur dans la recopie du fichier "+ff.getAbsolutePath()+e);
					// TODO: handle exception
				}
			
			}
			System.out.println(ff.toString().substring(ff.toString().indexOf("/"))+" vs "+f.toString().substring(f.toString().indexOf("/")));
		}
		
		// TODO Auto-generated method stub
		
	}



	public void copy(File ff,File f) throws IOException{
			 byte[] data= new byte[1];
			 RandomAccessFile inFile;	
			 inFile = new RandomAccessFile(ff.getAbsolutePath(),"r");
			 RandomAccessFile outFile=new RandomAccessFile(f.getAbsolutePath(),"rw");
			 while(outFile.length()!=ff.length()){
				 inFile.read(data);
				 outFile.write(data);
			 }
			 inFile.close();
			 outFile.close();
			 System.out.println("fichier "+ff+" copier a la place de "+f);
		
	
	}
	
	
	public ArrayList<String> filesToStrings(ArrayList<File> fs){
		ArrayList<String> liste = new ArrayList<String>();
		for(File f : fs)
			liste.add(f.toString());
		return liste;
	}
	
	
	
}
