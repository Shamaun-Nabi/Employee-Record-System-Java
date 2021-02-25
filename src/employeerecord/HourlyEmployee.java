/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecord;

/**
 *
 * @author snash
 */
public class HourlyEmployee extends Employee{
   double hourlyRate;
	int hourWorked;
	
	public HourlyEmployee(String name, String id, String designation, double hourlyRate, int hourWorked) {
		super(name, id, designation);
		this.hourlyRate = hourlyRate;
		this.hourWorked = hourWorked;
	}
	
	double getSalary(int hWorked) {
		
		return hourlyRate*hWorked;
	}
	
	@Override
	void increaseSalary(double amt) {
		
		hourlyRate += amt;
	}
	
	@Override
	double getSalary() {
		
		return hourlyRate*hourWorked;
	}
	
	@Override
	String display() {
		
		return super.display()+" Rate: "+hourlyRate;
		
	}
    
}
