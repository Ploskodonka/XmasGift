package com.epam.tanya_adnokulova.java.lesson2.task1;
import java.util.Scanner;

public class ShowMenu {
	private Gift gift = new Gift();
	
	public void giftMenu() {
		boolean exit = true;
		Scanner in = new Scanner(System.in);
	
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Create a gift");
			System.out.println("2. Sort candies by weight");
			System.out.println("3. Find candy");
			System.out.println("4. Show gift");
			int option = in.nextInt();
		
			switch(option) {
				case 1:
					boolean creation = true;
					while (creation) {
						System.out.println("Choose the type of candy:\n1) Caramel candy\n2) Chocolate candy\n3) Truffle candy");
						int type = in.nextInt();
						System.out.print("Enter the name of candy: ");
						String name = in.nextLine();
						System.out.print("Enter the color of candy: ");
						String color = in.nextLine();
						System.out.print("Enter the weight of candy: ");
						double weight = in.nextDouble();
						switch(type) {
							case 1:
								gift.addCandy(new CaramelCandy(name, color, weight));
								break;
							case 2: 
								gift.addCandy(new ChocolateCandy(name, color, weight));
								break;
							case 3:
								gift.addCandy(new TruffleCandy(name, color, weight));
								break;
							default: 
								System.out.println("Unknown operation");
								break;
						}
					System.out.println("Enter 1 to continue 'gift creation', 0 to return to menu");
					option = in.nextInt();
					if (option == 0) {
						gift.showGift();
						System.out.println("_________________________________");
						System.out.println("Total gift weight: " + gift.getTotalWeight());
						creation = false;
					}
					}
					break;
				case 2:
					gift.sortByWeight();
					break;
				case 3:
					System.out.println("Choose a field to search:\n1) Name\n2) Color\n3) Weight range");
					int search = in.nextInt();
					switch (search) {
						case 1:
							System.out.print("Enter name: ");
							String findName = in.nextLine();
							gift.findByName(findName);
							break;
						case 2:
							System.out.print ("Enter color: ");
							String findColor = in.nextLine();
							gift.findByColor(findColor);
							break;
						case 3:
							System.out.print("Enter the lower weight: ");
							double lowerWeight = in.nextDouble();
							System.out.print("Enter the upper weight: ");
							double upperWeight = in.nextDouble();
							gift.findByWeight(lowerWeight, upperWeight);
							break;
						default:
							System.out.println("Unknown operation");
							break;
					}
					break;
				case 4:
					gift.showGift();
					break;
				default:
					System.out.println("Unknown operation");
					break;
			}
		
			System.out.println("Enter 1 to continue, 0 to exit the application");
			option = in.nextInt();
			if (option == 0) exit = false;
		}
		while(exit);
		in.close();
	}

}
