
package br.com.supplyradar.usuario.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static java.lang.Integer.valueOf;

public class DateUtils {
	public static final String _MASK_SQLSERVER = "yyyyMMdd";
	public static final String _MASK_DDMMYY    = "dd/MM/yy";
	public static final String _MASK_DDMMYYYY  = "dd/MM/yyyy";

    public static int getCurrentYear(){
    	return getYear(getCurrentDate());
    }
    public static int getCurrentMonth(){
    	return getMonth(getCurrentDate());
    }
    public static int getCurrentDay(){
    	return getDay(getCurrentDate());
    }
    public static int getCurrentTrimester(){
    	return getTrimester(getCurrentDate());
    }
    public static int getYear(Date data){
        DateFormat df = new SimpleDateFormat("yyyy");
        df.setLenient(false);
        return Integer.parseInt(df.format(data));
    }
    public static int getMonth(Date data){
    	DateFormat df = new SimpleDateFormat("MM");
    	df.setLenient(false);
    	return Integer.parseInt(df.format(data));
    }
    public static int getDay(Date data){
    	DateFormat df = new SimpleDateFormat("dd");
    	df.setLenient(false);
    	return Integer.parseInt(df.format(data));
    }
    public static int getTrimester(Date data){
    	DateFormat df = new SimpleDateFormat("MM");
    	df.setLenient(false);
    	int valor = Integer.parseInt(df.format(data));

    	if ( (valor >= 1) && (valor <= 3) ) {
    		return 1;
    	} else
    		if ( (valor >= 4) && (valor <= 6) ) {
    			return 2;
    		} else
    			if ( (valor >= 7) && (valor <= 9) ) {
    				return 3;
    			} else {
    				return 4;
    			}

    }
    public static Date getCurrentDate(){
        return new Date(System.currentTimeMillis());
    }
    public static String formatCurrentDate(){
        return formatDate(getCurrentDate(), null);
    }
    public static String formatCurrentDate(String mask){
        return formatDate(getCurrentDate(), mask);
    }
    public static String formatDate(Date date){
        return formatDate(date, null);
    }
    
    public static String formatDate(Date date, String mask){
        if(date == null){
            return null;
        }

        if(Objects.isNull(mask)){
            mask = _MASK_DDMMYYYY;
        }
        try{
            //instancia um DateFormat
            DateFormat df = new SimpleDateFormat(mask);
            //df.setLenient(false);

            //tenta retornar o String como Date
            return df.format(date);
        }
        catch(Exception exc){
            return "#ERRO#";
        }
    }
}
