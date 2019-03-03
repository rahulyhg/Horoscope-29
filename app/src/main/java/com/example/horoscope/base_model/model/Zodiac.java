package com.example.horoscope.base_model.model;

public class Zodiac {
	private String date;
	private String horoscope;
	private Meta meta;
	private String credit;
	private String sunsign;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setHoroscope(String horoscope){
		this.horoscope = horoscope;
	}

	public String getHoroscope(){
		return horoscope;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setCredit(String credit){
		this.credit = credit;
	}

	public String getCredit(){
		return credit;
	}

	public void setSunsign(String sunsign){
		this.sunsign = sunsign;
	}

	public String getSunsign(){
		return sunsign;
	}

	@Override
 	public String toString(){
		return 
			"Zodiac{" +
			"date = '" + date + '\'' + 
			",horoscope = '" + horoscope + '\'' + 
			",meta = '" + meta + '\'' + 
			",credit = '" + credit + '\'' + 
			",sunsign = '" + sunsign + '\'' + 
			"}";
		}
}
