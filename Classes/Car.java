
package Classes;


public  class Car {
    
    protected String brandName;
    protected String model;
    protected double price;
    protected String carID;
    protected String color;
    protected String status;
   
    
    public Car(){}    
    
    public Car(String brandName,String model,String carID,String color,double price,String status)
    {
        this.brandName=brandName;
        this.model=model;
        this.carID=carID;
        this.color=color;
        this.price=price;
        this.status=status;
        
    }
    
	
	public void setBrandName(String brandName)
    {
        this.brandName=brandName;
    }
    public void setModel(String model)
    {
        this.model=model;
    }
	public void setCarID(String carID)
	{
		this.carID=carID;
	}	
    public void setPriceO(double price)   
    {
        this.price=price;
    }
    public void setColor(String color)
    {
        this.color=color;
    }
    
    public void setStatus(String status)
    {
        this.status=status;
    }
    public String getBrandName(){return brandName;}
    public String getModel(){return model;}
    public double getPrice(){return price;}
    public String getCarID(){return carID;}
    public String getColor(){return color;}
    public String getStatus(){return status;}
    
    
    
    
    
    
    
    
}
