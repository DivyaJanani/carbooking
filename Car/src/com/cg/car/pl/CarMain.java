package com.cg.car.pl;

	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	import javax.xml.ws.ServiceMode;

	import com.cg.car.bean.Customer;
	import com.cg.car.bean.Cars;
	import com.cg.car.exception.CarException;
	import com.cg.car.service.CarService;
	import com.cg.car.service.CarServiceImpl;

	public class CarMain {
		static Scanner sc=new Scanner(System.in);
		static CarService carService=null;
		static CarServiceImpl carServiceimpl=null;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Customer customer=null;
			Cars cars=null;
			
			
			int option;
			while(true)
			{
				
				System.out.println("CAR SALE");
				System.out.println("____________");
				System.out.println("1.PURCHASE CAR");
				System.out.println("2.SEARCH CAR");
				System.out.println("3.VIEW CARS");
				System.out.println("4.EXIT");
				System.out.println("______________");
				System.out.println("ENTER YOUR OPTION");
				
				option=sc.nextInt();
				switch(option)
				{
				case 1:
					
					try {
						 cars=new Cars();
						
						while(customer==null)
						{
						customer=customerDetails();
						}
						while(cars==null)
						{
						cars=CarMain.retrievecars();
						}
						carService=new CarServiceImpl();
						try {
							carService.buyCar(customer,cars);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					} 
					catch (CarException e) {
						
					}
					
					
					break;
					
				case 2:
					carServiceimpl=new CarServiceImpl();
					System.out.println("Car Name :");
					String carName=sc.next();
					System.out.println("car No :");
					String modelNo=sc.next();
					try {
						System.out.println("cars "+carServiceimpl.searchMobile(carName,modelNo));
						
					}
					catch (Exception e) {
						System.out.println("No Car Found.");
					} 
					
					break;
					
				case 3:
					List<Cars> li=new ArrayList<Cars>();
					carServiceimpl=new CarServiceImpl();
					li=carServiceimpl.showStock();
					System.out.println(li+"\n");
					
					break;
					
				case 4:
					
					System.exit(0);
					break;
					
				}
			}
			

		}
		
		public static Customer customerDetails() throws CarException
		{
			Customer customer=new Customer();
			System.out.println("Enter Customer Details");
			System.out.println("Enter Customer Name :");
			customer.setCustomerName(sc.next());
			
			System.out.println("Enter Phone number:");
			customer.setCustomerNumber(sc.next());
			
			System.out.println("Enter your address :");
			customer.setAddress(sc.next());
			
			try
			{
				carServiceimpl=new CarServiceImpl();
				carServiceimpl.validation(customer);
				return customer;
			}
			catch(Exception e)
			{
				System.out.println("\n enter valid Details \n"+"try agian");
			}
			return null;
		}
		public static Cars retrievecars() throws CarException
		{
		    cars=new Cars();
			System.out.println("Enter Car details you want :");
			System.out.println("Enter Car Name :");
			
			String c=sc.next();
			cars.
			
			System.out.println("Enter Model");
			cars.setCarmodel(sc.next());
			try
			{
					carServiceimpl.mobileValidation(car);
					return cars;
			}
			catch(CarException e)
			{
				
			}
			return null;
		}

	}


