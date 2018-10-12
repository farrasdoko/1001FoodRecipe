package com.farrasabiyyu12.a1001foodrecipe.Model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResultsItem{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("ingredients")
	private String ingredients;

	@SerializedName("href")
	private String href;

	@SerializedName("title")
	private String title;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setIngredients(String ingredients){
		this.ingredients = ingredients;
	}

	public String getIngredients(){
		return ingredients;
	}

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

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",href = '" + href + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}