/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {
	
	private static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
	
	private static SimpleDateFormat formatMomth = new SimpleDateFormat("MM");
	
	private static SimpleDateFormat formatDay = new SimpleDateFormat("dd");

	/**
	 * 将String类型的值转换成Date类型的值，当参数值是   空  或者是  null，将返回  null
	 * @param strTime
	 * @return
	 */
	public static Date stringToDate(String strTime) {
		
		SimpleDateFormat forMater = null;
		Date data = null;
		
		if(StringUtils.isBlank(strTime)){
			return null;
		}
		
		if ((strTime.indexOf(" ") < 0)) {
			forMater = new SimpleDateFormat("yyyyMMddHHmmss");
		} else if ((strTime.indexOf("/") > -1) && (strTime.indexOf(" ") > -1) && (strTime.indexOf(":") > -1)) {
			forMater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		} else if ((strTime.indexOf("-") > -1) && (strTime.indexOf(" ") > -1) && (strTime.indexOf(":") > -1)) {
			forMater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if ((strTime.indexOf("/") > -1)) {
			forMater = new SimpleDateFormat("yyyy/MM/dd");
		} else if ((strTime.indexOf("-") > -1)) {
			forMater = new SimpleDateFormat("yyyy-MM-dd");
		}

		try {
			data = forMater.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}
	
	/**
	 * 将Date类型的值转换成指定格式的String类型的值,当两个参数中任意一个参数的值是 空 或者是 空字符串，将返回    空字符串
	 * @param date 需要转换的日期值
	 * @param formatStr 需要转换的日期值格式
	 * @return
	 */
	public static String dateToString(Date date, String formatStr) {
		
		SimpleDateFormat forMater = null;
		String stringDate = null;
		
		if(StringUtils.isBlank(formatStr) || date == null){
			return "";
		}
		
		if("yyyyMMddHHmmss".equals(formatStr)){
			forMater = new SimpleDateFormat("yyyyMMddHHmmss");
		}else if("yyyy/MM/dd HH:mm:ss".equals(formatStr)){
			forMater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		}else if("yyyy-MM-dd HH:mm:ss".equals(formatStr)){
			forMater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if("yyyy/MM/dd".equals(formatStr)){
			forMater = new SimpleDateFormat("yyyy/MM/dd");
		}else if("yyyy-MM-dd".equals(formatStr)){
			forMater = new SimpleDateFormat("yyyy-MM-dd");
		}

		stringDate = forMater.format(date);

		return stringDate;
	}
	
	@SuppressWarnings("deprecation")
	public static Date asDate(String dateMat) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateMat);
			return date;
		} catch (Exception e) {}
		
		try {
			date = new SimpleDateFormat("yyyy.MM.dd").parse(dateMat);
			return date;
		} catch (Exception e) {}
		
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(dateMat);
			return date;
		} catch (Exception e) {
		}
		try {
			Date date_temp=new Date(dateMat);
			String datestr=new SimpleDateFormat("yyyy/MM/dd").format(date_temp);
			date = new SimpleDateFormat("yyyy/MM/dd").parse(datestr);
			return date;
		} catch (Exception e) {
		}
		
		try {
			date = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK).parse(dateMat);
			String temp = new SimpleDateFormat("yyyy/MM/dd").format(date);
			date = new SimpleDateFormat("yyyy/MM/dd").parse(temp);
			return date;
		} catch (Exception e) {}
		
		return date;
	}
	
	/**
	 *获取日期和时间
	 * @param date
	 * @return
	 */
	public static String getDatetoString(Date date){
		if(date == null){
			return "";
		}
		return format1.format(date);
	}
	
	/**
	 * 获取年
	 * @param transformationStr
	 * @return
	 */
	public static String getSpecialFormatTransformationYear(String transformationStr){
		if(StringUtils.isNotBlank(transformationStr)){
			Date date = asDate(transformationStr);
			return formatYear.format(date);
		}
		return "";
	}
	
	/**
	 * 获取月
	 * @param transformationStr
	 * @return
	 */
	public static String getSpecialFormatTransformationMomth(String transformationStr){
		if(StringUtils.isNotBlank(transformationStr)){
			Date date = asDate(transformationStr);
			return formatMomth.format(date);
		}
		return "";
	}
	
	/**
	 * 获取日
	 * @param transformationStr
	 * @return
	 */
	public static String getSpecialFormatTransformationDay(String transformationStr){
		if(StringUtils.isNotBlank(transformationStr)){
			Date date = asDate(transformationStr);
			return formatDay.format(date);
		}
		return "";
	}
	
	/**
	 * 获取带中文的年月日
	 * @param transformationStr
	 * @return
	 */
	public static String getChineseDate(Date date){
		String year = getSpecialFormatTransformationYear(getDatetoString(date));
		String month = getSpecialFormatTransformationMomth(getDatetoString(date));
		String day = getSpecialFormatTransformationDay(getDatetoString(date));
		String strDate = year + "年" + month + "月" + day +"日";
		return strDate;
	}
}