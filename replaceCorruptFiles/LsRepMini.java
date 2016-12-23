

import java.io.*;

import java.util.ArrayList;

import java.util.Scanner;

//Ceci importe toutes les classes du package java.util

import java.util.*;

/**
 * @author 
 *class a refaire car pas propre
 */
public class LsRepMini
 {
	
	 ArrayList<File> liste = new ArrayList<File>();//liste 
	 ArrayList<File> liste2 = new ArrayList<File>();//liste 
	 
	 
	 
	 /**
	 * @param chemin
	 * @return
	 * faire un ls des fichier qui sort avec le chemin absolue 
	 */
	public ArrayList<File> getAbsoluteFiles(String chemin){		 		 
		 liste = new ArrayList<File>();
		 walk(chemin,"fichier");
		 return liste;	 
	 }
	 /**
	 * @param chemin
	 * @return
	 * faire un ls des dossiers qui sort avec le chemin absolue 
	 */
	public ArrayList<File> getAbsoluteFolders(String chemin){		 		 
		 liste = new ArrayList<File>();
		 walk(chemin,"fichier");
		 return liste;	 
	 } 
	 
	 
	 /**
	 * @param chemin
	 * @return
	 * faire un ls des fichier qui sort avec le chemin relatif  
	 */
	public ArrayList<File> getRelativeFile(String chemin){		 		 
		 liste = new ArrayList<File>();
		 walk(chemin,"fichier");
		 return getRelative(liste);	 
	 }
	 /**
	 * @param chemin
	 * @return
	 * faire un ls des dossiers qui sort avec le chemin relatif 
	 */
	public ArrayList<File> getRelativeFolder(String chemin){		 		 
		 liste = new ArrayList<File>();
		 walk(chemin,"fichier");
		 return getRelative(liste);	 
	 } 
	 
	 
	 /**
	 * @param files
	 * @return
	 * faire un ls des fichiers qui sort avec le chemin relatif 
	 */
	private ArrayList<File> getRelative(ArrayList<File> files){
		 liste2 = new ArrayList<File>();
		  String curDir = System.getProperty("user.dir");

		 int lgRelative=curDir.length()+1;
		 for (File f : files){
			 liste2.add(new File(f.getAbsolutePath().substring(lgRelative)));
			 
			 
		 }
		return liste2;
		 
	 }
	 
	 /**
	 * @return
	 * retourne le chemin actuel
	 */
	public String getChemin(){
		 return System.getProperty("user.dir");
	 }
	 
	  /**
	 * @param path
	 * @param type
	 * fonction recursive avec path le chemin et type qui est fichier ou dossier
	 */
	private void walk(String path,String type) {// fonction de recursivite
	        File root = new File( path );
	        if (root.isFile()){
	        	if(type.equals("fichier"))
	        		liste.add(root.getAbsoluteFile());
				return;
			}
	        else{
	        	if(type.equals("dossier"))
	        		liste.add(root.getAbsoluteFile());
		        File[] list = root.listFiles();
		        for(File f : list)
		        	walk( f.getAbsolutePath(),type ); 	
	        }
	        
	  }
	        
	        
	        
	
}


