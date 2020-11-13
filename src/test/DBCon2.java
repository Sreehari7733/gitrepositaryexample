package test;
import java.sql.*;
import java.util.*;
public class DBCon2 {
	public static void main(String a[])
	{
		try
		{
			Scanner s=new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srees7733");
			for(int i=0;i<=5;i++)
			{
				System.out.println("Enter Employee Id:");
				String eId=s.nextLine();
				System.out.println("Enter Employee name:");
				String eName=s.nextLine();
				System.out.println("Enter Employee desg:");
				String eDesg=s.nextLine();
				System.out.println("Enter Employee name:");
				float eSal=Float.parseFloat(s.nextLine());
				PreparedStatement ps=con.prepareStatement("insert into Employee28 values(?,?,?,?)");
				ps.setString(1,eId);
				ps.setString(2,eName);
				ps.setString(3,eDesg);
				ps.setFloat(4,eSal);
				int k=ps.executeUpdate();
				if(k>0)
				{
					System.out.println("Record is succesfylly inserted");
				}
				else
				{
					System.out.println("Record is not inserted");
				}
			}
			s.close();
			con.close();
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}