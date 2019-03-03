package com.example.horoscope.base_model.model;

public class Meta{
	private String intensity;
	private String mood;
	private String keywords;

	public void setIntensity(String intensity){
		this.intensity = intensity;
	}

	public String getIntensity(){
		return intensity;
	}

	public void setMood(String mood){
		this.mood = mood;
	}

	public String getMood(){
		return mood;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public String getKeywords(){
		return keywords;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"intensity = '" + intensity + '\'' + 
			",mood = '" + mood + '\'' + 
			",keywords = '" + keywords + '\'' + 
			"}";
		}
}
