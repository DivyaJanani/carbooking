package com.cg.car.dao;


	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	import com.cg.car.bean.Customer;
	import com.cg.car.bean.Cars;
	import com.cg.car.util.DBConnection;

	public class CarsDAOImpl implements CarsDAO {

		@Override
		public void buyCar(Customer customer,Cars car) throws Exception {
			
			//Cars cars=new Cars();
			String model=car.getCarmodel();
			String carname=car.getCarname();
			System.out.println(model);
			System.out.println(customer.getCustomerName());
			Connection connection=null;
			try
			{
			connection=DBConnection.getConnection();
			
			PreparedStatement pS=connection.prepareStatement("insert into customer values(?,?,?,?,?,sysdate,id.nextval)");
			pS.setString(1,customer.getCustomerName());
			pS.setString(2,customer.getCustomerNumber());
			pS.setString(3,customer.getAddress());
			pS.setString(4,carname);
			pS.setString(5,model);
			pS.executeUpdate();
			
			Statement s=connection.createStatement();
			s.executeUpdate("update cars set quantity=quantity-1 where model='"+model+"' and carname='"+carname+"'");
			connection.close();
			}
			
			catch(Exception e)
			{
				
			}
		}

		@Override
		public Cars searchCar(String modelname,String modelno) throws Exception {
			// TODO Auto-generated method stub
			String modelName=modelname;
			String modelNo=modelno;
			
			Cars car=new Cars();
			try
			{
			Connection connection=null;
			connection=DBConnection.getConnection();
			
			Statement s=connection.createStatement();
			ResultSet rS=s.executeQuery("select * from cars where modelno='"+modelNo+"' and carname='"+modelName+"'");
			
			while(rS.next())
			{
				
				String n=rS.getString(1);
				String n1=rS.getString(2);
				int a=rS.getInt(3);
				String b=rS.getString(4);
				car.setCarmodel(n1);
				car.setmileage(n);
				car.setspeed(b);
				car.setQuantity(a);
			}
			connection.close();
			}
			
			catch(Exception s)
			{
				s.printStackTrace();
			}
			return car;
		}

		@Override
		public List showStock() {
			List<Cars> li=new ArrayList<Cars>();
			
			try
			{
			Connection connection=null;
			connection=DBConnection.getConnection();
			
			Statement s=connection.createStatement();
			ResultSet rS=s.executeQuery("select * from cars");
			
			while(rS.next())
			{
				Cars car=new Cars();
				car.setModel(rS.getString(1));
				car.setMileage(rS.getString(2));
				car.setspeed(rS.getString(3));
				
				li.add(car);	
				
			}
			connection.close();
			}
			
			catch(Exception s)
			{
				s.printStackTrace();
			}

			return li;
		}

		@Override
		public Cars searchCar(String modelname, String modelno) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
}
