package com.example.practise.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.practise.demo.service.AddDaysService;
/**
 * 
 * @author Vidhi
 *
 */


@RestController
@RequestMapping("/addDays")
public class AddDaysController {

	@Autowired
	private AddDaysService service;
	
	/**
	 * 
	 * @param date represent date which needs to be modified in the format dd-mm-yyyy
	 * @param day represent number of days needs to be included in given date
	 * @return expected date
	 */
	@GetMapping("/{date}/{day}")
	public String getDate(@PathVariable("date") String date, @PathVariable("day") int day)
	{
		String upatedDate = service.addDays(date, day);
		return upatedDate;	
	}	
	
}
