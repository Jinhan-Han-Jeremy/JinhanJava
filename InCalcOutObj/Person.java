/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gscott
 */
public class Person 
{
    private String name;
    private int age;
    public Person(String nameIn, int agein)
    {
        name =  nameIn;
        age =  agein;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public double getMonths()
    {
       return  age * 365.0 /  30.0;
    }
}

