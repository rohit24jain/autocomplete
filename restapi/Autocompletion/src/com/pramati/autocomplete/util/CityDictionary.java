package com.pramati.autocomplete.util;

import java.util.ArrayList;
import java.util.List;

import com.pramati.autocomplete.model.City;
/*
 *  assumption :  cityName to have first letter capital and other characters small 
 *  and space(" ") also possible.
 *  
 *  Using Trie DS to create a dictionary of cities.
 */
public class CityDictionary {
       
	private static int MAX_CHAR = 27 ; 
	CityDictionary[] children = new CityDictionary[MAX_CHAR];
	boolean isLeafNode = false;
	City city ;
	static CityDictionary root = new CityDictionary();
	
	private CityDictionary(){
	}
	public static CityDictionary getRoot(){
		return root;
	}
	
	public void insertCity(String cityName){
		
		CityDictionary cityDictionary = getRoot();
		char ch;
		int index;
		for(int i=0; i<cityName.length(); i++){
			ch = cityName.charAt(i);
			index = getIndex(ch,i,true);
			
			
			if(cityDictionary.children[index] == null){
				cityDictionary.children[index] = new CityDictionary();
			}
			cityDictionary = cityDictionary.children[index];
		}
		cityDictionary.isLeafNode = true;
		cityDictionary.city = new City(cityName);
		//System.out.println("inserted in the trie.."+cityName);
	}
	
	/*
	 * params : start=Sm & atmost=2
	 * result : Simni
                Simulia [if no city starting with 'Sm']
                
       if want to show cities starting with 'Sm' only then return null instead of break;
	 */
	public List<String> searchCity(String cityName, int atmost){
		List<String> list = null;
		char[] chArr = cityName.toCharArray();
		CityDictionary cityDictionary = getRoot();
		int index;
		for(int i=0; i<chArr.length; i++){
			 index = getIndex(chArr[i],i,false);
			 
			if( cityDictionary.children[index] == null){
				break;
			}else{
				cityDictionary = cityDictionary.children[index];
			}
		}
		
		if(cityDictionary != null){
			list = applyDfs(cityDictionary , atmost, 0, new ArrayList<String>(atmost));
		}
		return list;
	}
	private List<String> applyDfs(CityDictionary cityDictionary, int atmost,int count, List<String> list ) {
		CityDictionary node = cityDictionary;
		
		if(count == atmost){
			return list;
		}
		if(cityDictionary.isLeafNode){
			count++;
			list.add(cityDictionary.city.getName());
		}
		for(int i=0; i<MAX_CHAR; i++){
			
			if(node.children[i] != null){
				List<String> cityList = applyDfs(node.children[i], atmost, count, list);
				if(cityList.size()==atmost){
					break;
				}
			}
		}
		return list;
	}

	public static int getIndex(char ch, int i, boolean isInsert){
		int index = 0;
		//System.out.println("char .."+ch+"..index .."+i);
		if(i==0 && isInsert){ //first place
			index = ch-'A';
		}else{
			index = ch-'a';
		}
				
		if(index < 0){  // for space[ascii code 32]
			index = 26;
		}
		return index;
	}
}
