package com.example.practise.demo.service;

import org.springframework.stereotype.Service;
/**
 * This class holds the business logic to add days in particular date
 * @author Vidhi Bansal
 *
 */
@Service
public class AddDaysService {
/**
 * 
 * @param date expects the date in the format dd-mm-yyyy 
 * @param n expects n number of days 
 * @return new date after adding days to it
 */
	public static String addDays(String date, int n) {
		int[] daysInNormalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] daysInLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] sArray = date.split("-");
		int dd = Integer.valueOf(sArray[0]);
		int mm = Integer.valueOf(sArray[1]);
		int yy = Integer.valueOf(sArray[2]);
		String updatedDate = "";
		dd = dd + n;
		if (calculateLeapYear(yy) == true) {
			int maxDayinMonth = daysInLeapYear[mm - 1];
			updatedDate = printFinalDate(dd, mm, yy, maxDayinMonth);
		} else {
			int maxDayinMonth = daysInNormalYear[mm - 1];
			updatedDate = printFinalDate(dd, mm, yy, maxDayinMonth);
		}
		return updatedDate;
	}
/**
 * 
 * @param year pass the input as year
 * @return boolean value which representwhether the year is leap or not
 */
	public static boolean calculateLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
/**
 * 
 * @param dd accept input as day
 * @param mm accept input as month
 * @param yy accept input as year
 * @param maxDayinMonth represent the maximum number of days in particular month
 * @return expected date
 */
	public static String printFinalDate(int dd, int mm, int yy, int maxDayinMonth) {
		String updatedDate = "";
		if (dd > maxDayinMonth) {
			dd = dd - maxDayinMonth;
			mm++;
			if (mm > 12) {
				yy++;
				mm = 1;
			}
		}

		if (dd <= 9 && mm <= 9) {
			updatedDate = "0" + dd + "/0" + mm + "/" + yy;
		} else if (mm <= 9 && dd > 9) {
			updatedDate = "" + dd + "/0" + mm + "/" + yy;
		} else if (mm > 9 && dd <= 9)
			updatedDate = "0" + dd + "/" + mm + "/" + yy;
		else {
			updatedDate = "" + dd + "/" + mm + "/" + yy;
		}
		return updatedDate;
	}

	
}