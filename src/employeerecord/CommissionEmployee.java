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
public class CommissionEmployee extends Employee{
    
    double commission;
	double sale;
	
	public CommissionEmployee(String name, String id, String designation, double commission, double sale) {
		super(name, id, designation);
		this.commission = commission;
		this.sale = sale;
	}
	
	double getSalary(double sale) {
		
		return commission*sale;
	}
	
	@Override
	double getSalary() {
		
		return commission*sale;
	}
	
	@Override
	void increaseSalary(double amt)
	{
		commission += amt;
	}

	@Override
	String display() {
        return super.display()+" Commission: "+commission;
	}
    
}
