package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import in.sts.gradleproject.models.Employee;

class connection{
	
	
	
}




public class dbmain {
	
	

	public static void main(String[] args) {
		
				int root=0;

				int count;
				String TLname;
				String PMname;
				String TMname;

		
			
				List<Integer> detail=new ArrayList<>();
				List<Integer> detail2=new ArrayList<>();
				
				HashMap<String,String> hp=new HashMap<>();
				LinkedHashSet<String> TL=new LinkedHashSet<>();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");

					String url="jdbc:mysql://localhost:3306/jaydeep";
					String user="root";
					String pass="root";


					Connection  con=DriverManager.getConnection(url,user,pass);
					
					

					String query="Select firstname,employeeid from employee where reportingto=?";
					PreparedStatement pstmt=con.prepareStatement(query);
				
					
					
				
					
				
						
						
							pstmt.setInt(1,root);
							ResultSet rs=pstmt.executeQuery();
							
							
							while(rs.next())
							{
								
								TMname=rs.getString("firstname");
								count=rs.getInt("Employeeid");//8
								
								detail.add(count);
								
								System.out.println("                                                "+TMname+" "+count+" reporting to"+"0");
								
							}	
						
							
							for(int k=0;k<detail.size();k++)
							{
								pstmt.setInt(1,detail.get(k));//8
								rs=pstmt.executeQuery();
								
								String pt="                                          ____________________|_________________________";
								String pt2= "                                       |                                             |\n";
								
								System.out.println(pt+pt2);
								
								
								while(rs.next())
								{
									
									TMname=rs.getString("firstname");//jaydeep,dhruv
									count=rs.getInt("Employeeid");//5,6
									
									detail2.add(count);//[5,6]
									
									System.out.print("                    "+TMname+" "+count+" reporting to"+detail.get(k)+"        ");
									
									
									
								}	
								System.out.println("");
								
								System.out.println("  ___________________________|________________________"   +     "     ___________________________|______________________________                         ");
								System.out.println("  |                          |                       | "   +     "     |                         | ");
								
								for(int i=k;i<detail2.size();i++)
								{
									pstmt.setInt(1,detail2.get(i));
									rs=pstmt.executeQuery();
									while(rs.next())
									{
										
										TMname=rs.getString("firstname");
										count=rs.getInt("Employeeid");//8
										
										detail2.add(count);
										
										System.out.print(TMname+" "+count+" TO"+detail2.get(i)+"        ");
										
										
										
									}
									
									
									
								}
								
								
								System.out.println();
								
							
							
						}
						
						
					
				
					
				

					if(pstmt!=null)
					{
						System.out.println("You Successfully Signed In");
					}
					if(con!=null)
					{
						System.out.println("You Successfully Signed In");
					}

				}
				catch(SQLException ex)
				{
					System.out.println("Sql Exception please cheack the connectivity or the query");
				}
				catch(Exception e)
				{
					System.out.println(" Exception please cheack the code");
				}
				




			}
	




	}


