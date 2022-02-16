package com.example.practise.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.practise.demo.service.AddDaysService;

@RunWith(MockitoJUnitRunner.class)
public class AddDaysControllerTest {

	@InjectMocks
	AddDaysController addDaysController;

	@Mock
	private AddDaysService addDaysService;

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test 
	public void getDateTest() {
		System.out.println("testclass");
	  String upatedDate = addDaysController.getDate("31-01-2016", 1);
	  assertEquals("01/02/2016", upatedDate); }

}
