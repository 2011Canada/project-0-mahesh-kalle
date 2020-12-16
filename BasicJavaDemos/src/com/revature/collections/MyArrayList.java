package com.revature.collections;

public class MyArrayList<T> {

	
	//it has an array
	//when that array gets full it makes a new bigger one and copies over the old values
	 T [] dataHolder;
	
	 public T[] getdata() {
		 return this.dataHolder;
	 }
	 
	 public void setData(T [] newData) {
		 this.dataHolder = newData;
	 }
	
}
