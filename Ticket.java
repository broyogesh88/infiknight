

import java.util.*;

class Screen
{
	int totalseats;
	int alies;
}

class Screen1 extends Screen
{
	boolean[] array = new boolean[151];
	Screen1()
	{
		for(int i = 0; i < 151; i++)
		array[i] = false;
	}
}

class Screen2 extends Screen
{
	boolean[] array = new boolean[101];
	Screen2()
	{
		for(int i = 0; i < 101; i++)
			array[i] = false;
	}
}

class Screen3 extends Screen
{
	boolean[] array = new boolean[81];
	Screen3()
	{
		for(int i = 0; i < 81; i++)
			array[i] = false;
	}
}

class Order
{
	String type;
	int quantity;
	float price;
	int[] seats = new int[150];
	
	
	public Order(Screen1 S, int quantity, int[] arr)
	{
		super();
		this.type = "S1";
		this.quantity = quantity;
		float P = (float) (quantity * ( 100 + (0.18 * 100)));
		this.seats = arr;
		if(quantity > 15)
		{
			this.price = P + 15 * quantity;
		}
		else
			this.price = P;
		
	}
	
	public Order(Screen2 S, int quantity, int[] arr)
	{
		super();
		this.type = "S2";
		this.quantity = quantity;
		float P = (float) (quantity * ( 150 + (0.18 * 150)));
		this.seats = arr;
		if(quantity > 15)
		{
			this.price = P + 15 * quantity;
		}
		else
			this.price = P;
	}
	
	public Order(Screen3 S, int quantity, int[] arr)
	{
		super();
		this.type = "S3";
		this.quantity = quantity;
		float P = (float) (quantity * ( 80 + (0.18 * 80)));
		this.seats = arr;
		if(quantity > 15)
		{
			this.price = P + 15 * quantity;
		}
		else
			this.price = P;
	}
	
	public void show(Screen1 S, ArrayList<Order> list)
	{
		System.out.println("Order are as follow:");
		
		System.out.print("Booked seats are: ");
		for(int i: this.seats)
		{	if(i != 0)
				System.out.print(i + ", ");
		}
		System.out.println("Total Amount is : " + this.price);
	}
	
	public void show(Screen2 S, ArrayList<Order> list)
	{
		System.out.println("Order are as follow:");
		System.out.print("Booked seats are: ");
		for(int i: this.seats)
		{	if(i != 0)
				System.out.print(i + ", ");
		}
		System.out.println("Total Amount is : " + this.price);
	}
	
	public void show(Screen3 S, ArrayList<Order>  list)
	{
		System.out.println("Order are as follow:");
		System.out.print("Booked seats are: ");
		for(int i: this.seats)
		{	if(i != 0)
				System.out.print(i + ", ");
		}
		System.out.println("Total Amount is : " + this.price);
	}
	
}

public class Ticket

{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Order> list1 = new ArrayList<>();
		ArrayList<Order> list2 = new ArrayList<>();
		ArrayList<Order> list3 = new ArrayList<>();
		Screen1 S1 = new Screen1();
		Screen2 S2 = new Screen2();
		Screen3 S3 = new Screen3();
		int choice; 
		int flag;
		while(true)
		{
			System.out.println("1: Book Tickets.\n2: View Tickets.\n3: To exit");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				while(true)
				{
					flag = 0;
					System.out.println("1: Screen 1\n2: Screen 2\n3: Screen 3\n4: To Exit");
					System.out.println("Enter your choice: ");
					choice = sc.nextInt();
					int num, seat;
					switch(choice)
					{
						case 1:
							System.out.println("Enter no. of seats you want:");
							num = sc.nextInt();
							if(num <= 0 || num > 150)
								System.out.println("Wrong Input");
							else
							{
								int[] arr = new int[150];
								System.out.println("Enter seat number: ");
								for(int i = 0; i < num; i++)
								{
									seat = sc.nextInt();
									if(S1.array[seat] == false)
									{
										S1.array[seat] = true;
										arr[i] = seat;
									}
									else
									{
										System.out.println("Seat is already taken..please select another one");
										i--;
									}
								}
								Order O = new Order(S1, num, arr);
								list1.add(O);
							}
							break;
						case 2:
							System.out.println("Enter no. of seats you want:");
							num = sc.nextInt();
							if(num <= 0 || num > 100)
								System.out.println("Wrong Input");
							else
							{
								int[] arr = new int[150];
								System.out.println("Enter seat number: ");
								for(int i = 0; i < num; i++)
								{
									seat = sc.nextInt();
									if(S2.array[seat] == false)
									{
										S2.array[seat] = true;
										arr[i] = seat;
									}
									else
									{
										System.out.println("Seat is already taken..please select another one");
										i--;
									}
								}
								Order O = new Order(S3, num, arr);
								list2.add(O);
							}
							break;
						case 3:
							System.out.println("Enter no. of seats you want:");
								num = sc.nextInt();
								if(num <= 0 || num > 80)
									System.out.println("Wrong Input");
								else
								{
									int[] arr = new int[150];
									System.out.println("Enter seat number: ");
									for(int i = 0; i < num; i++)
									{
										seat = sc.nextInt();
										if(S3.array[seat] == false)
										{
											S3.array[seat] = true;
											arr[i] = seat;
										}
										else
										{
											System.out.println("Seat is already taken..please select another one");
											i--;
										}
									}
									Order O = new Order(S3, num, arr);
									list3.add(O);
								}
								break;
						case 4:
							flag = 1;
							break;
						default:
							System.out.println("Sorry wrong input, please re-insert");
				
					}
					if(flag == 1)
						break;
				}
				break;
			case 2:
				int check = 0;
				while(true)
				{
					System.out.println("1: Screen 1\n2: Screen 2\n3: Screen 3\n4: To Exit");
					System.out.println("Enter your choice: ");
					choice = sc.nextInt();
					switch(choice)
					{
					case 1:
						if(list1.size() == 0)
							System.out.println("No tickets has been booked yet");
						else
						{
							for(Order i: list1)
								i.show(S1, list1);
						}
						break;
					case 2:
						if(list2.size() == 0)
							System.out.println("No tickets has been booked yet");
						else
						{
							for(Order i: list2)
								i.show(S2, list2);
						}
						break;
					case 3:
						if(list3.size() == 0)
							System.out.println("No tickets has been booked yet");
						else
						{
							for(Order i: list3)
								i.show(S3, list3);
						}
						break;
					case 4:
						check = 1;
						break;
					default:
						System.out.println("Sorry wrong input, please re-insert");	
					}
					if(check == 1)
						break;
				}
				break;
			case 3:
				System.exit(1);
			default:
				System.out.println("Sorry wrong input, please re-insert");
			}
		}
	}
}
	





