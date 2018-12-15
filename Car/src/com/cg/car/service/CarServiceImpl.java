package com.cg.car.service;


	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import com.cg.car.bean.Customer;
	import com.cg.car.bean.Cars;
	import com.cg.car.dao.CarsDAO;
	import com.cg.car.dao.CarsDAOImpl;
	import com.cg.car.exception.CarException;

	public class CarServiceImpl implements CarService{
			CarsDAO cDAO=new CarsDAOImpl();
		@Override
		public void buyCar(Customer customer,Cars car) throws Exception {
			System.out.println("In service");
			cDAO.buyCar(customer,car);
			
		}

		public Cars searchCar(String carname,String modelno) throws Exception {
			
			Cars car=new Cars();
			String name=carname;
			String no=modelno;
			car=cDAO.searchCar(name,no);
			return car;
		}

		@Override
		public List showStock() {
			List<Cars> li=new ArrayList<Cars>();
			li=cDAO.showStock();
			
			return li;
		}
		
		
		public void validation(Customer customer) throws CarException
		 {
			
			List validationerrors=new ArrayList();
			if(!isValidName(customer.getcName()))
			{
						validationerrors.add("Name should be minium of 3 characters");
			}
			if(!isValidEmail(customer.getEmail()))
			{
						validationerrors.add("Enter a valid email Id");
			}
			if(!isValidPhone(customer.getPhoneNo()))
			{
						validationerrors.add("Number should be only digits and 10 in length");
			}
			if(!validationerrors.isEmpty())
			{
						throw new CarException(validationerrors+"\n");
			}
			
		}
		
		public void carValidation(Cars car) throws CarException
		{
			
			List validationerror=new ArrayList();
			if(!isValidMobile(car.getCarname()))
			{
				validationerror.add("car not available");
			}
			if(!validationerror.isEmpty())
			{
				throw new CarException(validationerror+"\n");
			}
			
		}
		
		
		
		public boolean isValidName(String cname)
		{
			Pattern p=Pattern.compile("[A-Z][a-z]{3,}");
			Matcher m=p.matcher(cname);
			return m.matches();
		}
		public boolean isValidPhone(String phone)
		{
			Pattern p=Pattern.compile("[6-9][0-9]{9}");
			Matcher m=p.matcher(phone);
			return m.matches();
		}
		public boolean isValidEmail(String email)
		{
			Pattern p=Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
			Matcher m=p.matcher(email);
			return m.matches();
		}
		public boolean isValidCar(String Car)
		{
			String car1=Car;
			
			if(car1.equals("benz")||car1.equals("jaguar")||car1.equals("audi")||car1.equals("bmw"))
			{
				
				return true;
			}
			else
			{
				return false;
			}
					
		}
		
	}


