package com.cg.car.bean;

public class Cars {
	public class CarBean {
		private String carid;
		private String carmodel;
		private String cartype;
		private String carmileage;
		private String carcc;
		private double speed;
		private String carname;
		

	    public String getCarname() {
			return carname;
		}
		public void setCarname(String carname) {
			this.carname = carname;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		public String getCarid() {
		return carid;
	    }
	    public void setCarid(String carid) {
		this.carid = carid;
	}

		public String getCarmodel() {
			return carmodel;
		}
		public void setCarmodel(String carmodel) {
			this.carmodel = carmodel;
		}
		public String getCartype() {
			return cartype;
		}
		public void setCartype(String cartype) {
			this.cartype = cartype;
		}
		public String getCarcc() {
			return carcc;
		}
		public void setCarcc(String carcc) {
			this.carcc = carcc;
		}
		public String getCarmileage() {
			return carmileage;
		}
		public void setCarmileage(String carmileage) {
			this.carmileage = carmileage;
		}
		public double getSpeed() {
			return speed;
		}
		public void setSpeed() {
			this.speed = speed;
		}
		@Override
		public String toString() {
			return "CarBean [carid=" + carid + ", carmodel=" + carmodel + ", cartype=" + cartype + ", carmileage="
					+ carmileage + ", carcc=" + carcc + ", speed=" + speed + ", carname=" + carname + "]";
		}

	}



		
		
}
