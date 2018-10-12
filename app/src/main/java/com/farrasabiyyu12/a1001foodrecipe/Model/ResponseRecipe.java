package com.farrasabiyyu12.a1001foodrecipe.Model;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseRecipe{

	@SerializedName("href")
	private String href;

	@SerializedName("title")
	private String title;

	@SerializedName("version")
	private double version;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setVersion(double version){
		this.version = version;
	}

	public double getVersion(){
		return version;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRecipe{" + 
			"href = '" + href + '\'' + 
			",title = '" + title + '\'' + 
			",version = '" + version + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}