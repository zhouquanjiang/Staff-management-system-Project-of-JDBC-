package com.neusoft.entity;

public class Emp {
	//ÉùÃ÷£¬·´Éä
		public Emp() {
			
			
			
		}
		
		public Emp(Integer id, String name, String deptname, char sex, String tel) {
			super();
			this.id = id;
			this.name = name;
			this.deptname = deptname;
			this.sex = sex;
			this.tel = tel;
		}
		
		



		public Emp(int id, String name) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.name = name;
		}
		
		
		public Emp(int id, char sex) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.sex = sex;
		}

		@Override
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + ", deptname=" + deptname + ", sex=" + sex + ", tel=" + tel
					+ "]";
		}
		
		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDeptname() {
			return deptname;
		}

		public void setDeptname(String deptname) {
			this.deptname = deptname;
		}

		public char getSex() {
			return sex;
		}

		public void setSex(char sex) {
			this.sex = sex;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}



		private Integer id;
		
		private String name;
		
		private String deptname;
		
		private char sex;
		
		private String tel;
		
		
		
		
}
