import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;
class javazon
{
    public static boolean LogCalled = false;
    public static boolean logPromoFuctionCalled = false;
    public static double promoPts;
    static boolean intOrnot;
    public static boolean logFound = false;
    public static boolean promoFuctionCalled = false;
    public static String LogW = "|";
    public static String LogPromo;
    public static byte c=0;
    public static String LogS = "JavazonLog";
    public static File path;
    public static String[] LogFileDatabase = new String[100];
    public static boolean offersDiscountChecker = false;
    public static String DisRate;
    public static char[] allchar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','1','2','3','4','5','6','7','8','9','0'};
    public static String discountL = "";
    public static String discountCharsS = "";
    public static int discountCharsI[] = new int[100];
    public static String promo =  "";
    public static int[] cartR = new int[100];
    public static int[] cartQ = new int[100];
    public static String[] cartS = new String[100];
    public static int subMenuChecker = 0;
    public static int menuChecker = 0;
    static String menuSelect = "1";
    public static String header= "";
    public static String categories = "Select from the following categories";
    public static String hereoptions = "Here Are Your Options";
    public static String error = "That Option Does Not Exist";
    public static Date date = new Date();
    public static String cartchecker = null;
    public static int totalAmount=0;
    public static Double DiscountedAmount=0.0;
    public static Double PromoDiscountedAmount=0.0;
    public static int quantity=1;
    public static String option = "";
    public static String dash = "----------------------------------------";
    public static String[] bill = new String[100];
    public static int Reader;
    public static String practical = "That is not practical!!";
    public static void main(String [] args) throws IOException {
        showmenu();
    }
    public static void showmenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        option = "";
        Menu.mainmenu();
        menuSelect = sc.nextLine();
        System.out.println(dash);
        switch(menuSelect)
        {
            case "1":
                option += "/Electronics";
                Electronics.electronics();
                break;
            case "2":
                option += "/Home_appliances_furniture";
                System.out.println(option);
                HomeApp.homeApp();
                break;
            case "3":
                option += "/Entertainment";
                System.out.println(option);
                Entertainment.Entertainment_opt();
                break;
            case "4":
                option += "/Food";
                Food.food();
                break;
            case "5":
                option += "/Offers";
                System.out.println(option);
                Promo.Offers();
                break;
            case "6":
                option += "/Credits";
                System.out.println(option);
                System.out.println(dash);
                CREDITS.showcredits();
                break;
            case "0":
                option += "/Cart";
                System.out.println(option);
                System.out.println(dash);
                BillAndDiscount.billOutput();
                System.exit(0);
                break;
            default:
                System.err.println(error);
                Delay(1);
                showmenu();
        }
    }
    public static void Delay(int TimeWasDifferent)
    {
        try {
            Thread.sleep(TimeWasDifferent * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void giveRightInputNextTime() throws IOException {
        if(intOrnot==false)
        {
            System.err.println(practical);
            Delay(1);
            showmenu();
        }

    }
    public static void ifGoBack() throws IOException
    {
        if(Reader == 0)
        {
            showmenu();
        }
    }
}
class Electronics extends javazon
{
    public static void electronics() throws IOException {
        menuChecker = 0;
        Scanner sc = new Scanner(System.in);
        Menu.menuElectronics();
        intOrnot = sc.hasNextInt();
        giveRightInputNextTime();
        menuSelect= sc.nextLine();
        System.out.println(dash);
        menuChecker = Integer.parseInt(menuSelect);
        switch(menuSelect)
        {
            case "1":
                header+= "/Processors";
                Menu.menuElectronics();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                System.out.println(dash);
                subMenuChecker = Integer.parseInt(menuSelect);
                switch(menuSelect)
                {
                    case "1": {
                        System.out.println(dash);
                        header+= "/Intel";
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        String menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Core i3 Added to cart.");
                                        totalAmount += 12000 * quantity;
                                        BillAndDiscount.billInput("Core i3---INR", 12000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Core i5 Added to cart.");
                                        BillAndDiscount.billInput("Core i5---INR", 15000, quantity);
                                        totalAmount += 15000 * quantity;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x Core i7 Added to cart.");
                                        BillAndDiscount.billInput("Core i7---INR ", 17000, quantity);
                                        totalAmount += 17000 * quantity;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Core i9 Added to cart.");
                                        BillAndDiscount.billInput("Core i9---INR ", 20000, quantity);
                                        totalAmount += 20000 * quantity;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                    case "0":
                                        showmenu();
                                        break;
                                }
                            } else
                                System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }

                        else
                            System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    }
                    case "2": {
                        header+= "/AMD";
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 5 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Ryzen 3 Added to cart.");
                                        totalAmount += 8000 * quantity;
                                        BillAndDiscount.billInput("Ryzen 3---INR ", 8000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Ryzen 5 Added to cart.");
                                        totalAmount += 15000 * quantity;
                                        BillAndDiscount.billInput("Ryzen 5---INR ", 15000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x Ryzen 7 Added to cart.");
                                        totalAmount += 27000 * quantity;
                                        BillAndDiscount.billInput(" Ryzen 7---INR", 27000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Ryzen 9 Added to cart.");
                                        totalAmount += 60000 * quantity;
                                        BillAndDiscount.billInput(" Ryzen 9---INR", 60000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "5":
                                        System.out.println(quantity + " x Ryzen Threadripper Added to cart");
                                        totalAmount += 200000 * quantity;
                                        BillAndDiscount.billInput(" Ryzen Threadripper---INR", 200000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;

                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else
                            System.out.println(dash);
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    }
                    case "0":
                        showmenu();
                        break;
                    default:System.out.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "2":
                header+= "/Graphics_Card";
                Menu.menuElectronics();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect)+2;
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        header+= "/Nvidia";
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 11 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x GTX 1050 Added to cart.");
                                        totalAmount += 10000 * quantity;
                                        BillAndDiscount.billInput("GTX 1050---INR", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x GTX 1060 Added to cart.");
                                        totalAmount += 15000 * quantity;
                                        BillAndDiscount.billInput("GTX 1060---INR ", 15000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x GTX 1660 Added to cart.");
                                        totalAmount += 25000 * quantity;
                                        BillAndDiscount.billInput("GTX 1660---INR", 25000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x GTX 1070 Added to cart.");
                                        totalAmount += 30000 * quantity;
                                        BillAndDiscount.billInput("GTX 1070---INR", 30000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "5":
                                        System.out.println(quantity + " x GTX 1080 Added to cart.");
                                        totalAmount += 50000 * quantity;
                                        BillAndDiscount.billInput("GTX 1080---INR ", 50000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "6":
                                        System.out.println(quantity + " x RTX 2060 Added to cart.");
                                        totalAmount += 30000 * quantity;
                                        BillAndDiscount.billInput("GTX 2060---INR ", 30000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "7":
                                        System.out.println(quantity + " x RTX 2070 Added to cart.");
                                        totalAmount += 40000 * quantity;
                                        BillAndDiscount.billInput("RTX 2070---INR ", 40000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "8":
                                        System.out.println(quantity + " x RTX 2080 Added to cart.");
                                        totalAmount += 80000 * quantity;
                                        BillAndDiscount.billInput("RTX 2080---INR ", 80000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "9":
                                        System.out.println(quantity + " x RTX 3070 Added to cart.");
                                        totalAmount += 60000 * quantity;
                                        BillAndDiscount.billInput("RTX 3070---INR ", 60000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "10":
                                        System.out.println(quantity + " x RTX 3080 Added to cart.");
                                        totalAmount += 80000 * quantity;
                                        BillAndDiscount.billInput("RTX 3080---INR ", 80000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "11":
                                        System.out.println(quantity + " x RTX 3090 Added to cart.");
                                        totalAmount += 100000 * quantity;
                                        BillAndDiscount.billInput("GTX 3090---INR ", 100000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else
                            System.out.println(dash);
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        quantity = 1;
                        header+= "/AMD";
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Radeon 7000 Added to cart.");
                                        totalAmount += 20000 * quantity;
                                        BillAndDiscount.billInput("Radeon 7000---INR", 20000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Radeon 8000 Added to cart.");
                                        totalAmount += 30000 * quantity;
                                        BillAndDiscount.billInput("Radeon 8000---INR", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x Radeon 9000 Added to cart.");
                                        totalAmount += 40000 * quantity;
                                        BillAndDiscount.billInput("Radeon 9000---INR ", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Radeon R300 Added to cart.");
                                        totalAmount += 50000 * quantity;
                                        BillAndDiscount.billInput("Radeon R300---INR ", 50000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else
                            System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "3":
                header+= "/Cables";
                Menu.menuElectronics();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1": {
                        header+= "/HDMI";
                        menuChecker = -1;
                        subMenuChecker = 5;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x HDMI 1.0 Added to cart.");
                                        totalAmount += 200 * quantity;
                                        BillAndDiscount.billInput("HDMI 1.0---INR", 200, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x HDMI 2.0 Added to cart.");
                                        BillAndDiscount.billInput("HDMI 1.0---INR", 300, quantity);
                                        totalAmount += 300 * quantity;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x HDMI 2.1 Added to cart.");
                                        BillAndDiscount.billInput("HDMI 2.1---INR ", 400, quantity);
                                        totalAmount += 400 * quantity;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.out.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else
                                System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    }
                    case "2": {
                        header+= "/DP";
                        menuChecker = -1;
                        subMenuChecker = 6;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <=4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x DP 1.0 Added to cart.");
                                        totalAmount += 200 * quantity;
                                        BillAndDiscount.billInput("DP 1.0---INR ", 200, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x DP 1.2 Added to cart.");
                                        totalAmount += 300 * quantity;
                                        BillAndDiscount.billInput("DP 1.2---INR ", 300, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x DP 3.0 Added to cart.");
                                        totalAmount += 500 * quantity;
                                        BillAndDiscount.billInput(" DP 3.0---INR", 500, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x DP 4.0 Added to cart.");
                                        totalAmount += 600 * quantity;
                                        BillAndDiscount.billInput(" DP 4.0---INR", 600, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else
                                System.err.println(practical);
                            Delay(1);
                            showmenu();


                        }
                        else
                            System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    }
                    case "3": {
                        System.out.println(dash);
                        header+= "/VGA";
                        menuChecker = -1;
                        subMenuChecker =7;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x VGA Added to cart.");
                                        totalAmount += 300 * quantity;
                                        BillAndDiscount.billInput("VGA---INR", 300, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Nishtech Male to Male VGA Cable 1 Meter, Support PC/Monitor/LCD/LED, Plasma, Projector, TFT added to cart.");
                                        totalAmount += 129 * quantity;
                                        BillAndDiscount.billInput("Nishtech Male to Male VGA Cable 1 Meter, Support PC/Monitor/LCD/LED, Plasma, Projector, TFT---INR ", 129, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x PremiumAV HDMI Male to VGA Female Video Converter Adapter Cable (Black) added to cart.");
                                        totalAmount += 377 * quantity;
                                        BillAndDiscount.billInput("PremiumAV HDMI Male to VGA Female Video Converter Adapter Cable (Black)---INR ", 377, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x JavazonBasics HDMI Input to DVI Output (Not VGA) Adapter Cable, 3 Feet,Black added to cart.");
                                        totalAmount += 329 * quantity;
                                        BillAndDiscount.billInput("JavazonBasics HDMI Input to DVI Output (Not VGA) Adapter Cable, 3 Feet,Black---INR ", 329, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.out.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    }
                    case "4": {
                        System.out.println(dash);
                        header+= "/DVI";
                        menuChecker = -1;
                        subMenuChecker = 8;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);

                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x DVI Added to cart.");
                                        totalAmount += 200 * quantity;
                                        BillAndDiscount.billInput("DVI---INR", 200, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x DVI-D (24+1) Dual Link Male to Male Digital Video Cable 1.5 Meter (5 Feet) for PC, Laptop, Projector, HDTV, HD-Monitor, Graphics Card, Gaming Console. added to cart.");
                                        totalAmount += 295 * quantity;
                                        BillAndDiscount.billInput("DVI-D (24+1) Dual Link Male to Male Digital Video Cable 1.5 Meter (5 Feet) for PC, Laptop, Projector, HDTV, HD-Monitor, Graphics Card, Gaming Console.---INR ", 295, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x BlueRigger Premium USB C 3.1 to DVI Adapter Cable added to cart.");
                                        totalAmount += 1599 * quantity;
                                        BillAndDiscount.billInput("BlueRigger Premium USB C 3.1 to DVI Adapter Cable---INR ", 1599, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Gibbon HDMI Male to DVI-D Male Dual Link (24+1 Pin) Cable 1.5 Meter added to cart.");
                                        totalAmount += 249 * quantity;
                                        BillAndDiscount.billInput("Gibbon HDMI Male to DVI-D Male Dual Link (24+1 Pin) Cable 1.5 Meter---INR ", 249, quantity);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.out.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    }
                    case "0":
                        showmenu();
                        break;
                    default:System.out.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "4":
                header+= "/Peripherals";
                Menu.menuElectronics();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        header+= "/Keyboard";
                        menuChecker = -1;
                        subMenuChecker = 9;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if (Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x DELL KB216 MULTIMEDIA KEYBOARD (580-AEKD, BLACK) added to cart.");
                                        totalAmount += 579 * quantity;
                                        BillAndDiscount.billInput("DELL KB216 MULTIMEDIA KEYBOARD (580-AEKD, BLACK)---INR ", 579, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Zebronics K25 Standard Keyboard with USB Inputadded to cart.");
                                        totalAmount += 299 * quantity;
                                        BillAndDiscount.billInput("Zebronics K25 Standard Keyboard with USB Input---INR ", 299, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x HP GK100 Wired USB Gaming Keyboard  (Black) added to cart.");
                                        totalAmount += 2799 * quantity;
                                        BillAndDiscount.billInput("HP GK100 Wired USB Gaming Keyboard  (Black)---INR ", 2799, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x HP 100 Wired USB Desktop Keyboard with Height Adjustment added to cart.");
                                        totalAmount += 549 * quantity;
                                        BillAndDiscount.billInput("HP 100 Wired USB Desktop Keyboard with Height Adjustment---INR ", 549, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        header+= "/Mouse";
                        menuChecker = -1;
                        subMenuChecker = 10;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x HP X1000 Wired Mouse (Black/Grey) added to cart.");
                                        totalAmount += 349 * quantity;
                                        BillAndDiscount.billInput("HP X1000 Wired Mouse (Black/Grey)---INR ", 349, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Logitech M90 Wired USB Mouse, 1000 DPI Optical Tracking, Ambidextrous PC/Mac/Laptop - Black added to cart.");
                                        totalAmount += 299 * quantity;
                                        BillAndDiscount.billInput("Logitech M90 Wired USB Mouse, 1000 DPI Optical Tracking, Ambidextrous PC/Mac/Laptop - Black---INR ", 299, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x LOGITECH M90 OPTICAL USB MOUSE (910-001795, BLACK) added to cart.");
                                        totalAmount += 299 * quantity;
                                        BillAndDiscount.billInput("LOGITECH M90 OPTICAL USB MOUSE (910-001795, BLACK)---INR ", 299, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Dell MS116 Optical Mouse added to cart.");
                                        totalAmount += 363 * quantity;
                                        BillAndDiscount.billInput("Dell MS116 Optical Mouse---INR ", 363, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "3":
                        header+= "/Headphones";
                        menuChecker = -1;
                        subMenuChecker = 11;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Logitech H111 Wired Headphone, Grey added to cart.");
                                        totalAmount += 729 * quantity;
                                        BillAndDiscount.billInput("Logitech H111 Wired Headphone, Grey---INR ", 729, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Logitech H111 Wired Headphone, Grey added to cart.");
                                        totalAmount += 24959 * quantity;
                                        BillAndDiscount.billInput("Logitech H111 Wired Headphone, Grey---INR ", 24959, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x Audio-Technica - ATH-M20x added to cart.");
                                        totalAmount += 4599 * quantity;
                                        BillAndDiscount.billInput("Audio-Technica - ATH-M20x---INR ", 4599, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Rockerz 550 added to cart.");
                                        totalAmount += 1999 * quantity;
                                        BillAndDiscount.billInput("Rockerz 550---INR ", 199, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();

                        break;
                    case "4":
                        header+= "/Monitors";
                        menuChecker = -1;
                        subMenuChecker = 12;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Samsung 59.8 cm (23.5 inch) Curved LED Backlit Computer Monitor added to cart.");
                                        totalAmount += 8999 * quantity;
                                        BillAndDiscount.billInput("Samsung 59.8 cm (23.5 inch) Curved LED Backlit Computer Monitor---INR ", 8999, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x HP EliteDisplay 23.8-inch (60.45 cm) IPS Anti Glare Full HD Monitor added to cart.");
                                        totalAmount += 15676 * quantity;
                                        BillAndDiscount.billInput("HP EliteDisplay 23.8-inch (60.45 cm) IPS Anti Glare Full HD Monitor---INR ", 15676, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x Dell SE Series SE2219HX 22 (55.88 cm) Full HD Monitor added to cart.");
                                        totalAmount += 9000 * quantity;
                                        BillAndDiscount.billInput("Dell SE Series SE2219HX 22 (55.88 cm) Full HD Monitor---INR ", 9000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Sharp 61 cm (24 inch) HD LED TV, C24BC2IN added to cart.");
                                        totalAmount += 7990 * quantity;
                                        BillAndDiscount.billInput("Sharp 61 cm (24 inch) HD LED TV, C24BC2IN---INR ", 7990, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();

                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "5":
                        header+= "/Microphones(only for computers)";
                        menuChecker = -1;
                        subMenuChecker = 13;
                        Menu.menuElectronics();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Rode NT-USB USB Condenser Microphone, Black added to cart.");
                                        totalAmount += 17999 * quantity;
                                        BillAndDiscount.billInput("Rode NT-USB USB Condenser Microphone, Black---INR ", 17999, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Maono AU-A04 Condenser Microphone Kit (Black) added to cart.");
                                        totalAmount += 4619 * quantity;
                                        BillAndDiscount.billInput("Maono AU-A04 Condenser Microphone Kit (Black)---INR ", 4619, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x Rode NT-USB Mini Studio quality USB Microphone added to cart.");
                                        totalAmount += 10999 * quantity;
                                        BillAndDiscount.billInput("Rode NT-USB Mini Studio quality USB Microphone---INR ", 10999, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x Raspberry Pi USB Plug and Play Desktop Microphone added to cart.");
                                        totalAmount += 195 * quantity;
                                        BillAndDiscount.billInput("Raspberry Pi USB Plug and Play Desktop Microphone---INR ", 195, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else
                                System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "0":
                showmenu();
                break;
            default: System.err.println(error);
                Delay(1);
                showmenu();
        }
    }
}
class HomeApp extends javazon{
    public static void homeApp() throws IOException {
        menuChecker = 0;
        Scanner sc = new Scanner(System.in);
        Menu.menuHomeApp();
        intOrnot = sc.hasNextInt();
        giveRightInputNextTime();
        menuSelect = sc.nextLine();
        System.out.println(dash);
        menuChecker = Integer.parseInt(menuSelect);
        switch(menuSelect)
        {
            case "1":
                header+= "/Washing_Machines";
                Menu.menuHomeApp();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        System.out.println(dash);
                        header+= "/Front_Load";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Godrej Eon 6 Added to cart.");
                                        totalAmount += 30000 * quantity;
                                        BillAndDiscount.billInput("Godrej Eon 6---INR ", 30000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x IFB Senorita Aqua SX Added to cart.");
                                        BillAndDiscount.billInput("IFB Senorita Aqua SX---INR ", 40000, quantity);
                                        Delay(1);
                                        totalAmount += 40000 * quantity;
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);
                            showmenu();

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        quantity = 1 ;
                        header+= "/Top_Load";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if (Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if (quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Samsung WA62M4100HY 6.2Kg Added to cart.");
                                        totalAmount += 15000 * quantity;
                                        BillAndDiscount.billInput("Samsung WA62M4100HY 6.2Kg---INR ", 15000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity +" x Panasonic F62B5HRB 6.2Kg Added to cart.");
                                        totalAmount += 20000 * quantity;
                                        BillAndDiscount.billInput(quantity + "Panasonic F62B5HRB 6.2Kg---INR ", 20000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            } else System.err.println(practical);
                            Delay(1);

                        }
                        else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0": showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "2":
                header+= "/Microwave_Oven";
                Menu.menuHomeApp();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect) + 2;
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        header+= "/Microwave";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Emerson MWG9115SB Added to cart.");
                                        totalAmount += 10000 * quantity;
                                        BillAndDiscount.billInput("Emerson MWG9115SB---INR ", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Whirlpool 24 L Convection Microwave Added to cart.");
                                        totalAmount += 15000 * quantity;
                                        BillAndDiscount.billInput("Whirlpool 24 L Convection Microwave---INR ", 15000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        header+= "/Oven";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Panasonic 23L Convection Oven Added to cart.");
                                        totalAmount += 20000 * quantity;
                                        BillAndDiscount.billInput("Panasonic 23L Convection Oven---INR ", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Samsung 28L Convection Oven Added to cart.");
                                        totalAmount += 30000 * quantity;
                                        BillAndDiscount.billInput("Samsung 28L Convection Oven---INR ", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "3":
                header+= "/Tables";
                Menu.menuHomeApp();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect) + 4;
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        System.out.println(dash);
                        header+= "/Urban";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Urban table with polished wood Added to cart.");
                                        totalAmount += 10000 * quantity;
                                        BillAndDiscount.billInput("Urban table with polished wood---INR ", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Stained Glass table Added to cart.");
                                        BillAndDiscount.billInput("Stained Glass table---INR ", 15000, quantity);
                                        totalAmount += 15000 * quantity;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        quantity = 1 ;
                        header+= "/Antique";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity +" x Jodhpur Table Added to cart.");
                                        totalAmount += 15000 * quantity;
                                        BillAndDiscount.billInput("Jodhpur Table---INR ", 8000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity +" x Tea table Added to cart.");
                                        totalAmount += 20000 * quantity;
                                        BillAndDiscount.billInput("Tea table---INR ", 15000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0": showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                }
                break;
            case "4":
                header+= "/Chairs";
                Menu.menuHomeApp();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect) + 6;
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        System.out.println(dash);
                        header+= "/Urban";
                        Menu.menuHomeApp();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect  = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Synthetic Chair Added to cart.");
                                        totalAmount += 10000 * quantity;
                                        BillAndDiscount.billInput("Synthetic Chair---INR ", 10000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x Wooden Chair Added to cart.");
                                        BillAndDiscount.billInput("Wooden Chair---INR ", 15000, quantity);
                                        Delay(1);
                                        totalAmount += 15000 * quantity;
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        quantity = 1 ;
                        header+= "/Antique";
                        Menu.menuHomeApp();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 2 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Bamboo Chair Added to cart.");
                                        totalAmount += 15000 * quantity;
                                        BillAndDiscount.billInput("Bamboo Chair--- INR ", 15000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity +" x Teak polished Chair Added to cart" );
                                        totalAmount += 20000 * quantity;
                                        BillAndDiscount.billInput("Teak polished Chair --- INR ", 20000, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0": showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "0":
                showmenu();
                break;
            default: System.err.println(error);
                Delay(1);
                showmenu();
        }
    }
}
class Food extends javazon{
    public static void food() throws IOException {
        menuChecker = 0;
        Scanner sc = new Scanner(System.in);
        Menu.menuFood();
        intOrnot = sc.hasNextInt();
        giveRightInputNextTime();
        menuSelect = sc.nextLine();
        System.out.println(dash);
        menuChecker = Integer.parseInt(menuSelect);
        switch(menuSelect)
        {
            case "1":
                header+= "/Frozen";
                Menu.menuFood();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        System.out.println(dash);
                        header+= "/Non-Veg";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 6 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity:");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x Whole Chicken Added to cart.");
                                        totalAmount += 200 * quantity;
                                        BillAndDiscount.billInput("Whole Chicken---INR ", 200, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x kg Chicken Brest Added to cart.");
                                        BillAndDiscount.billInput("IFB Senorita Aqua SX---INR ", 50, quantity);
                                        Delay(1);
                                        totalAmount += 50 * quantity;
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x kg Chicken Drumsticks Added to cart.");
                                        BillAndDiscount.billInput("Chicken Drumsticks---INR ", 60, quantity);
                                        Delay(1);
                                        totalAmount += 60 * quantity;
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x kg Mutton Chops Added to cart.");
                                        BillAndDiscount.billInput("Mutton Chops---INR ", 70, quantity);
                                        Delay(1);
                                        totalAmount += 70 * quantity;
                                        showmenu();
                                        break;
                                    case "5":
                                        System.out.println(quantity + " x kg Mutton Ribs Added to cart.");
                                        BillAndDiscount.billInput("Mutton Ribs---INR ", 40, quantity);
                                        Delay(1);
                                        totalAmount += 40 * quantity;

                                        showmenu();
                                        break;
                                    case "6":
                                        System.out.println(quantity + " x Whole Turkey Added to cart.");
                                        BillAndDiscount.billInput("Whole Turkey---INR ", 300, quantity);
                                        Delay(1);
                                        totalAmount += 300 * quantity;
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        quantity = 1 ;
                        header+= "/Veg";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity(kgs):");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x kg French Fries Added to cart.");
                                        totalAmount += 40 * quantity;
                                        BillAndDiscount.billInput("French Fries---INR ", 40, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x kg Potato Patties Added to cart.");
                                        totalAmount += 120 * quantity;
                                        BillAndDiscount.billInput(quantity + "kg Potato Paties---INR ", 120, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x lt Milk Added to cart.");
                                        totalAmount += 10 * quantity;
                                        BillAndDiscount.billInput(quantity + "lt Milk---INR ", 10, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x kg Paneer Added to cart.");
                                        totalAmount += 50 * quantity;
                                        BillAndDiscount.billInput(quantity + "kg Potato Paties---INR ", 50, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0": showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "2":
                header+= "/Fresh";
                Menu.menuFood();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect= sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect) + 2;
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        header+= "/Vegetables|Fruits";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 8 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity(kgs):");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x kg Tomato Added to cart.");
                                        totalAmount += 30 * quantity;
                                        BillAndDiscount.billInput("Tomato---INR ", 30, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x kg Carrots Added to cart.");
                                        totalAmount += 20 * quantity;
                                        BillAndDiscount.billInput("Carrots---INR ", 20, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x kg Apples Added to cart.");
                                        totalAmount += 20 * quantity;
                                        BillAndDiscount.billInput("Carrots---INR ", 20, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x kg Banana Added to cart.");
                                        totalAmount += 40 * quantity;
                                        BillAndDiscount.billInput("Banana---INR ", 40, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "5":
                                        System.out.println(quantity + " x kg Pineaplles Added to cart.");
                                        totalAmount += 50 * quantity;
                                        BillAndDiscount.billInput("Pineapples---INR ", 50, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "6":
                                        System.out.println(quantity + " x kg Capsicum Added to cart.");
                                        totalAmount += 40 * quantity;
                                        BillAndDiscount.billInput("Capsicum---INR ", 40, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "7":
                                        System.out.println(quantity + " x kg Ladyfingers Added to cart.");
                                        totalAmount += 50 * quantity;
                                        BillAndDiscount.billInput("Ladyfingers---INR ", 50, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "8":
                                        System.out.println(quantity + " x kg BEAN Added to cart.");
                                        totalAmount += 100 * quantity;
                                        BillAndDiscount.billInput("BEAN---INR ", 100, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        header+= "/Snacks";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 4 && Reader >= 0) {
                            ifGoBack();
                            System.out.println("Choose the quantity(kgs):");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x kg Potato Chips Added to cart.");
                                        totalAmount += 40 * quantity;
                                        BillAndDiscount.billInput("Potato Chips---INR ", 40, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x kg Apple Jacks to cart.");
                                        totalAmount += 50 * quantity;
                                        BillAndDiscount.billInput("Apple Jacks---INR ", 50, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x kg Banana Chips to cart.");
                                        totalAmount += 40 * quantity;
                                        BillAndDiscount.billInput("Banana Chips---INR ", 40, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println(quantity + " x kg Chivda to cart.");
                                        totalAmount += 50 * quantity;
                                        BillAndDiscount.billInput("Chivda---INR ", 50, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:
                        System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "3":
                header+= "/Essenstial";
                Menu.menuFood();
                menuChecker = -1;
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect) + 4;
                System.out.println(dash);
                switch(menuSelect)
                {
                    case "1":
                        System.out.println(dash);
                        header+= "/Flour";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 3 && Reader >= 0)
                        {
                            ifGoBack();
                            System.out.println("Choose the quantity(kgs):");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0) {
                                System.out.println(dash);

                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x kg Whole Wheat to cart.");
                                        totalAmount += 40 * quantity;
                                        BillAndDiscount.billInput("Whole Wheat---INR ", 40, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x kg Maida Added to cart.");
                                        BillAndDiscount.billInput("Maida---INR ", 50, quantity);
                                        Delay(1);
                                        totalAmount += 50 * quantity;
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x kg Rice Flour Added to cart.");
                                        BillAndDiscount.billInput("Rice Flour---INR ", 40, quantity);
                                        Delay(1);
                                        totalAmount += 40 * quantity;
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "2":
                        quantity = 1 ;
                        header+= "/Rice";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        if(Reader <= 3 && Reader >= 0)
                        {
                            ifGoBack();
                            System.out.println("Choose the quantity(kgs):");
                            System.out.print("Input - ");
                            intOrnot = sc.hasNextInt();
                            giveRightInputNextTime();
                            quantity = sc.nextInt();
                            if(quantity > 0 ) {
                                System.out.println(dash);
                                switch (menuSelect) {
                                    case "1":
                                        System.out.println(quantity + " x kg Sticky Rice to cart.");
                                        totalAmount += 30 * quantity;
                                        BillAndDiscount.billInput("Sticky Rice---INR ", 30, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println(quantity + " x kg Non Sticky Rice Added to cart.");
                                        totalAmount += 50 * quantity;
                                        BillAndDiscount.billInput("Non Sticky Rice---INR ", 50, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println(quantity + " x kg Biryani Rice Added to cart.");
                                        totalAmount += 70 * quantity;
                                        BillAndDiscount.billInput("Biryani Rice---INR ", 70, quantity);
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println(error);
                                        Delay(1);
                                        showmenu();
                                }
                            }else System.err.println(practical);
                            Delay(1);
                            showmenu();
                        }else System.err.println(error);
                        Delay(1);
                        showmenu();
                        break;
                    case "3":
                        quantity = 1 ;
                        header+= "/Spices";
                        Menu.menuFood();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        Reader = Integer.parseInt(menuSelect);
                        System.out.println("Choose the quantity(kgs):");
                        System.out.print("Input - ");
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        quantity = sc.nextInt();
                        System.out.println(dash);
                        switch(menuSelect)
                        {
                            case "1": System.out.println(quantity +" x kg Garam Masala to cart.");
                                totalAmount += 30*quantity;
                                BillAndDiscount.billInput("Garam Masala---INR ",30,quantity);
                                Delay(1);
                                showmenu();
                                break;
                            case "2": System.out.println(quantity +" x kg Tumric Added to cart.");
                                totalAmount += 40*quantity;
                                BillAndDiscount.billInput("Tumric---INR ",40,quantity);
                                Delay(1);
                                showmenu();
                                break;
                            case "3": System.out.println(quantity +" x kg Ginger Garlic Paste Added to cart.");
                                totalAmount += 20*quantity;
                                BillAndDiscount.billInput("Ginger Garlic Paste---INR ",20,quantity);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default: System.err.println(error);
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "0": showmenu();
                        break;
                    default: System.err.println(error);
                        Delay(1);
                        showmenu();
                }
                break;
            case "0":
                showmenu();
                break;
            default: System.err.println(error);
                Delay(1);
                showmenu();
        }
    }
}
class Entertainment extends javazon
{
    public static void Entertainment_opt() throws IOException {
        menuChecker = 0;
        subMenuChecker = 0;
        Scanner sc = new Scanner(System.in);
        Menu.menuEntertainment();
        intOrnot = sc.hasNextInt();
        giveRightInputNextTime();
        menuSelect = sc.nextLine();
        System.out.println(dash);
        menuChecker = Integer.parseInt(menuSelect);
        switch (menuSelect)
        {
            case "1":
                header+= "/Movies";
                Menu.menuEntertainment();
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch (menuSelect)
                {
                    case "1":
                        header+= "/Hollywood";
                        menuChecker = -1;
                        subMenuChecker = 0;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch (menuSelect)
                        {
                            case "1":
                                header+= "/Action";
                                menuChecker = -1;
                                subMenuChecker = 3;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);
                                System.out.println(dash);
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("The Fast and the furious 7 added to cart.");
                                        BillAndDiscount.billInput("The Fast and the furious 7", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Mission Impossible added to cart.");
                                        BillAndDiscount.billInput("Mission impossible", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("Avengers: Civil war added to cart.");
                                        BillAndDiscount.billInput("Avengers: Civil war", 500, 1);
                                        totalAmount += 500;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("Inception added to cart.");
                                        BillAndDiscount.billInput("Inception", 400, 1);
                                        totalAmount += 600;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "2":
                                header+= "/Melancholic";
                                menuChecker = -1;
                                subMenuChecker = 4;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("Titanic added to cart.");
                                        BillAndDiscount.billInput("Titanic", 299, 1);
                                        totalAmount += 299;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Romeo+Juliet added to cart.");
                                        BillAndDiscount.billInput("Romeo+Juliet", 400, 1);
                                        totalAmount += 400;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("Me before you added to cart.");
                                        BillAndDiscount.billInput("Me before you", 199, 1);
                                        totalAmount += 199;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("One Day added to cart.");
                                        BillAndDiscount.billInput("One Day", 300, 1);
                                        totalAmount += 300;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "3":
                                header+= "/Comedy";
                                menuChecker = -1;
                                subMenuChecker = 5;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("Borat added to cart.");
                                        BillAndDiscount.billInput("Borat", 399, 1);
                                        totalAmount += 399;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Accepted added to cart.");
                                        BillAndDiscount.billInput("Accepted", 299, 1);
                                        totalAmount += 299;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("The other guys added to cart.");
                                        BillAndDiscount.billInput("The other guys", 499, 1);
                                        totalAmount += 499;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("Due Date added to cart.");
                                        BillAndDiscount.billInput("Due date", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "4":
                                header+= "/Horror";
                                menuChecker = -1;
                                subMenuChecker = 6;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("IT 2 added to cart.");
                                        BillAndDiscount.billInput("IT 2", 299, 1);
                                        totalAmount += 299;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("The Conjuring 2 added to cart.");
                                        BillAndDiscount.billInput("The Conjuring 2", 400, 1);
                                        totalAmount += 400;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("Annabelle Creation added to cart.");
                                        BillAndDiscount.billInput("Annabelle creation", 500, 1);
                                        totalAmount += 500;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("Insidious added to cart.");
                                        BillAndDiscount.billInput("Insidious", 600, 1);
                                        totalAmount += 600;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "2":
                        header+= "/Bollywood";
                        menuChecker = -1;
                        subMenuChecker = 1;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch (menuSelect)
                        {
                            case "1":
                                header+= "/Action";
                                menuChecker = -1;
                                subMenuChecker = 7;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);//-1
                                System.out.println(dash);
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("Singham added to cart.");
                                        BillAndDiscount.billInput("Singham", 500, 1);
                                        totalAmount += 500;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Baaghi 2 added to cart.");
                                        BillAndDiscount.billInput("Baaghi 2", 199, 1);
                                        totalAmount += 199;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("Dhoom 3 added to cart.");
                                        BillAndDiscount.billInput("Dhoom 3", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("Singham returns added to cart.");
                                        BillAndDiscount.billInput("Singham returns", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "2":
                                header+= "/Romantic";
                                menuChecker = -1;
                                subMenuChecker = 8;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);//-1
                                System.out.println(dash);
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("Dil bechara added to cart.");
                                        BillAndDiscount.billInput("Dil bechara", 300, 1);
                                        totalAmount += 300;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Zero added to cart.");
                                        BillAndDiscount.billInput("Zero", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("Love Aaj kal added to cart.");
                                        BillAndDiscount.billInput("Love aaj kal", 199, 1);
                                        totalAmount += 199;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("Luka Chuppi added to cart.");
                                        BillAndDiscount.billInput("Luka Chuppi", 199, 1);
                                        totalAmount += 199;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "3":
                                header+= "/Comedy";
                                menuChecker = -1;
                                subMenuChecker = 9;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);//-1
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("Total Dhamaal added to cart.");
                                        BillAndDiscount.billInput("Total Dhamaal", 200, 1);
                                        totalAmount += 200;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Houseful 4 added to cart.");
                                        BillAndDiscount.billInput("Houseful 4", 299, 1);
                                        totalAmount += 299;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("Hera Pheri added to cart.");
                                        BillAndDiscount.billInput("Hera Pheri", 400, 1);
                                        totalAmount += 400;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("3 idiots added to cart.");
                                        BillAndDiscount.billInput("3 idiots", 300, 1);
                                        totalAmount += 300;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "4":
                                header+= "/Horror";
                                menuChecker = -1;
                                subMenuChecker = 10;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);//-1
                                switch (menuSelect)
                                {
                                    case "1":
                                        System.out.println("Alone added to cart.");
                                        BillAndDiscount.billInput("Alone", 199, 1);
                                        totalAmount += 199;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "2":
                                        System.out.println("Bhoot added to cart.");
                                        BillAndDiscount.billInput("Bhoot", 400, 1);
                                        totalAmount += 400;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "3":
                                        System.out.println("1920 London added to cart.");
                                        BillAndDiscount.billInput("1920 London", 500, 1);
                                        totalAmount += 500;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "4":
                                        System.out.println("Pari added to cart.");
                                        BillAndDiscount.billInput("Pari", 300, 1);
                                        totalAmount += 300;
                                        Delay(1);
                                        showmenu();
                                        break;
                                    case "0":
                                        showmenu();
                                        break;
                                    default:
                                        System.err.println("Please enter a valid option");
                                        Delay(1);
                                        showmenu();
                                }
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:
                        System.err.println("Please enter a valid option");
                        Delay(1);
                        showmenu();
                }
                break;
            case "2":
                header+= "/Books";
                Menu.menuEntertainment();
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch (menuSelect)
                {
                    case "1":
                        header+= "/Hindi";
                        menuChecker = -1;
                        subMenuChecker = 2;
                        Menu.menuEntertainment();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch (menuSelect)
                        {
                            case "1":
                                header+= "/Fiction";
                                menuChecker = -1;
                                subMenuChecker = 11;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0)
                                {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + "x Godann by Premchand added to cart.");
                                                    totalAmount += 100 * quantity;
                                                    BillAndDiscount.billInput("Godann by Premchand---INR", 100, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x Dharmayoddha Kalki: Avatar of Vishnu- Book 1 (HINDI) by Kevin Missal added to cart");
                                                    totalAmount += 150 * quantity;
                                                    BillAndDiscount.billInput("Dharmayoddha Kalki: Avatar of Vishnu- Book 1 (HINDI) by Kevin Missal---INR", 150, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + "x Gaban by Premchand added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Gaban by Premchand---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                case "4":
                                                    System.out.println(quantity + "x Chandrakanta by Devaki Nandan Khatri added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("Chandrakanta by Devaki Nandan Khatri---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "2":
                                header+= "/Non-Fiction";
                                menuChecker = -1;
                                subMenuChecker = 12;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0) {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true)
                                    {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + "x Siddhartha (DELUXE EDITION) by Hermann Hesse added to cart.");
                                                    totalAmount += 285 * quantity;
                                                    BillAndDiscount.billInput("Siddhartha (DELUXE EDITION) by Hermann Hesse---INR", 285, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x  Sapiens Manav Jati ka Sankshipt Itihas by Yuval Noah Harari added to cart.");
                                                    totalAmount += 285 * quantity;
                                                    BillAndDiscount.billInput("Sapiens Manav Jati ka Sankshipt Itihas by Yuval Noah Harari---INR", 285, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + "x Main Mann Hoon by Deep trivedi added to cart.");
                                                    totalAmount += 179 * quantity;
                                                    BillAndDiscount.billInput("Main Mann Hoon by Deep trivedi---INR", 179, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + "x Gora (Hindi) by Rabindranath Tagore added to cart.");
                                                    totalAmount += 189 * quantity;
                                                    BillAndDiscount.billInput("Gora (Hindi) by Rabindranath Tagore---INR", 189, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "3":
                                header+= "/Fantasy";
                                menuChecker = -1;
                                subMenuChecker = 13;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0) {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + "x Nirmala by Premchand added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("Nirmala by Premchand---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x Kamayani by Jaishankar Prasad added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Kamayani by Jaishankar Prasad---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + "x Volga Se Ganga by Rahul Sankrityayan added to cart.");
                                                    totalAmount += 199 * quantity;
                                                    BillAndDiscount.billInput("Volga Se Ganga by Rahul Sankrityayan---INR", 199, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + "x Gunahon Ka Devta by Dharamvir Bharati added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Gunahon Ka Devta by Dharamvir Bharati---INR 200", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "4":
                                header+= "/Adventure";
                                menuChecker = -1;
                                subMenuChecker = 14;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0)
                                {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + "x Sita-Warrior of Mithila Amish Tripathi added to cart.");
                                                    totalAmount += 400 * quantity;
                                                    BillAndDiscount.billInput("Sita-Warrior of Mithila Amish Tripathi---INR", 400, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x Ek Aaghaaz by Nitish Ojha added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Ek Aaghaaz by Nitish Ojha---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + "x Kashi Ka Assi by Kashinath Singh added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Kashi Ka Assi by Kashinath Singh---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + "x Ibnebatuti by Divya Prakash Dubey added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("Ibnebatuti by Divya Prakash Dubey---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "2":
                        header+= "/English";
                        menuChecker = -1;
                        subMenuChecker = 2;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch(menuSelect)
                        {
                            case "1":
                                header+= "/Fiction";
                                menuChecker = -1;
                                subMenuChecker = 15;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0) {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + " x 1984 by George Orwell added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("1984 by George Orwell---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x Pride and Prejudice by Jane Austen added to cart.");
                                                    totalAmount += 199 * quantity;
                                                    BillAndDiscount.billInput("Pride and Prejudice by Jane Austen---INR", 199, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + " x The Great Gatsby by F. Scott Fitzgerald added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("The Great Gatsby by F. Scott Fitzgerald.---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + " x The Catcher in the Rye by J. D. Salinger added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("The Catcher in the Rye by J. D. Salinger---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "2":
                                header+= "/Non-Fiction";
                                menuChecker = -1;
                                subMenuChecker = 16;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                subMenuChecker += Integer.parseInt(menuSelect);
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0)
                                {
                                    ifGoBack();
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + " x Silent Spring by Rachel Carson added to cart.");
                                                    totalAmount += 3200 * quantity;
                                                    BillAndDiscount.billInput("Silent Spring by Rachel Carson---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x In Cold Blood by Truman Capote added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("In Cold Blood by Truman Capote---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + " x The Double Helix: A Personal Account of the Discovery of the Structure of DNA by James Watson added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("The Double Helix: A Personal Account of the Discovery of the Structure of DNA by James Watson---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + " x Goodbye to All That by Robert Graves added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Goodbye to All That by Robert Graves---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "3":
                                header+= "/Fantasy";
                                menuChecker = -1;
                                subMenuChecker = 17;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0) {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + " x The Lord of the Rings by J. R. R. Tolkien added to cart.");
                                                    totalAmount += 500 * quantity;
                                                    BillAndDiscount.billInput("The Lord of the Rings by J. R. R. Tolkien---INR", 500, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x The Hobbit by J. R. R. Tolkien added to cart.");
                                                    totalAmount += 500 * quantity;
                                                    BillAndDiscount.billInput("The Hobbit by J. R. R. Tolkien---INR", 500, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + " x A Game of Thrones by George R. R. Martin added to cart.");
                                                    totalAmount += 300 * quantity;
                                                    BillAndDiscount.billInput("A Game of Thrones by George R. R. Martin---INR", 300, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + " x Alice's Adventures in Wonderland by Lewis Carroll added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Alice's Adventures in Wonderland by Lewis Carroll---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "4":
                                header+= "/Adventure";
                                menuChecker = -1;
                                subMenuChecker = 18;
                                Menu.menuEntertainment();
                                intOrnot = sc.hasNextInt();
                                giveRightInputNextTime();
                                menuSelect = sc.nextLine();
                                Reader = Integer.parseInt(menuSelect);
                                if(Reader <= 4 && Reader >= 0) {
                                    ifGoBack();
                                    subMenuChecker += Integer.parseInt(menuSelect);
                                    System.out.println("Choose the quantity:");
                                    System.out.print("Input-");
                                    intOrnot = sc.hasNextInt();
                                    if(intOrnot == true) {
                                        quantity = sc.nextInt();
                                        if (quantity > 0) {
                                            System.out.println(dash);
                                            switch (menuSelect) {
                                                case "1":
                                                    System.out.println(quantity + " x Treasure Island by Robert Louis Stevenson added to cart.");
                                                    totalAmount += 400 * quantity;
                                                    BillAndDiscount.billInput("Treasure Island by Robert Louis Stevenson---INR", 400, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "2":
                                                    System.out.println(quantity + "x Robinson Crusoe by Daniel Defoe added to cart.");
                                                    totalAmount += 500 * quantity;
                                                    BillAndDiscount.billInput("Robinson Crusoe by Daniel Defoe---INR", 500, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "3":
                                                    System.out.println(quantity + " x Journey to the centre of the earth by Jules Verne added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Journey to the centre of the earth by Jules Verne---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "4":
                                                    System.out.println(quantity + " x Lord of the Flies by William Golding added to cart.");
                                                    totalAmount += 200 * quantity;
                                                    BillAndDiscount.billInput("Lord of the Flies by William Golding---INR", 200, quantity);
                                                    Delay(1);
                                                    showmenu();
                                                    break;
                                                case "0":
                                                    showmenu();
                                                    break;
                                                default:
                                                    System.err.println("Please enter a valid option");
                                                    Delay(1);
                                                    showmenu();
                                            }
                                        } else System.err.println(practical);
                                        Delay(1);
                                        showmenu();
                                    }else System.err.println(practical);
                                    Delay(1);
                                    showmenu();
                                }else System.err.println(error);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();

                        }
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:
                        System.err.println("Please enter a valid option");
                        Delay(1);
                        showmenu();
                }
                break;
            case "3":
                header+= "/Video games";
                Menu.menuEntertainment();
                intOrnot = sc.hasNextInt();
                giveRightInputNextTime();
                menuSelect = sc.nextLine();
                subMenuChecker = Integer.parseInt(menuSelect);
                System.out.println(dash);
                switch (menuSelect)
                {
                    case "1":
                        header+= "/Shooter";
                        menuChecker = -1;
                        subMenuChecker = 19;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch(menuSelect)
                        {
                            case "1":
                                System.out.println("Counter-strike Global Offensive added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("Counter-strike Global Offensive",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "2":
                                System.out.println("Valorant added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("Valorant",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "3":
                                System.out.println("Fortnite added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("Fortnite",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "4":
                                System.out.println("PUBG added to cart");
                                totalAmount = 2000;
                                BillAndDiscount.billInput("PUBG---INR",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "2":
                        header+= "/Strategy";
                        menuChecker = -1;
                        subMenuChecker = 20;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch(menuSelect)
                        {
                            case "1":
                                System.out.println("League of Legends added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("League of Legends",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "2":
                                System.out.println("World of warships added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("World of warships",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "3":
                                System.out.println("World of tanks added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("World of tanks",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "4":
                                System.out.println("BattleTech added to cart");
                                totalAmount = 2891;
                                BillAndDiscount.billInput("BattleTech---INR",2891,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "3":
                        header+= "/Story-based";
                        menuChecker = -1;
                        subMenuChecker = 21;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch(menuSelect)
                        {
                            case "1":
                                System.out.println("The Last of us added to cart");
                                totalAmount = 1499;
                                BillAndDiscount.billInput("The Last of us---INR",1499,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "2":
                                System.out.println("Undertale added to cart");
                                totalAmount = 499;
                                BillAndDiscount.billInput("Undertale---INR",499,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "3":
                                System.out.println("GTA V added to cart");
                                totalAmount = 5310;
                                BillAndDiscount.billInput("GTA V---INR",5310,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "4":
                                System.out.println("Her Story added to cart");
                                totalAmount = 700;
                                BillAndDiscount.billInput("Her Story---INR",700,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "4":
                        header+= "/Horror";
                        menuChecker = -1;
                        subMenuChecker = 22;
                        Menu.menuEntertainment();
                        intOrnot = sc.hasNextInt();
                        giveRightInputNextTime();
                        menuSelect = sc.nextLine();
                        subMenuChecker += Integer.parseInt(menuSelect);
                        System.out.println(dash);
                        switch(menuSelect)
                        {
                            case "1":
                                System.out.println("Granny added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("Granny",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "2":
                                System.out.println("Five nights at freddy(FNAF) added to cart");
                                totalAmount = 0;
                                BillAndDiscount.billInput("Five nights at freddy(FNAF)",0,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "3":
                                System.out.println("Carrion added to cart");
                                totalAmount = 1400;
                                BillAndDiscount.billInput("Carrion---INR",1400,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "4":
                                System.out.println(" Amnesia : The Dark Descent added to cart");
                                totalAmount = 1400;
                                BillAndDiscount.billInput(" Amnesia : The Dark Descent---INR",1400,1);
                                Delay(1);
                                showmenu();
                                break;
                            case "0":
                                showmenu();
                                break;
                            default:
                                System.err.println("Please enter a valid option");
                                Delay(1);
                                showmenu();
                        }
                        break;
                    case "0":
                        showmenu();
                        break;
                    default:
                        System.err.println("Please enter a valid option");
                        Delay(1);
                        showmenu();
                }
                break;
            case "0":
                showmenu();
                break;
            default:
                System.err.println("Please enter a valid option");
                Delay(1);
                showmenu();
        }
    }
}
class BillAndDiscount extends javazon
{
    public static void billInput(String cart,int rate, int quantity)
    {
        cartchecker = cart;
        //  cartR[c] = rate;
        boolean found = false;
        if(c > 0) {

            for (byte i = 0; i < c; i++) {
                if (cart.equals(cartS[i])) {
                    found= true;
                    cartQ[i] += quantity; // adding the present quantity with the original quantity
                    bill[i] = cart + rate + "x" + cartQ[i];
                    c--;
                }
            }
        }
        if(found == false){
            bill[c]= cart +rate +"x"+ quantity;   //adding a new item details in bill list
            cartQ[c] = quantity;
            cartS[c] = cart;
        }
        c++;
    }
    public static void billOutput() throws IOException {
        Scanner sc = new Scanner(System.in);
        for(byte i = 0; i < c; i ++)
        {
            System.out.println(bill[i]);
        }
        if (cartchecker == null){
            cartchecker = "You Don't Have Anything in The Cart";
            System.out.println(cartchecker);
            for (byte i = 0; i < 1;){
                System.out.println("Do you want to exit? (Y/n)");
                System.out.print("Input - ");
                String input = sc.nextLine();
                if(input.toLowerCase().startsWith("y")){
                    System.out.println("Thanks For Using Javazon For Your Online Needs!");
                    System.exit(0);
                    i++;
                }
                else if (input.toLowerCase().startsWith("n")){
                    cartchecker = null;
                    i++;
                    showmenu();
                }
                else {
                    System.out.println(dash);
                    System.out.println("Please Enter A Valid Option");
                }
            }
        }
        else {
            System.out.print("Here Is Your Bill - INR ");
            System.out.println(totalAmount);
            Discount();
        }
        promoFuctionCalled = true;
        System.out.println("Your bill without Discount is: INR " + totalAmount);
        System.out.println("Your total bill with "+DisRate+" Discount is: INR " + DiscountedAmount);
        System.out.print("(Press Any Key To Continue)");
        sc.nextLine();
        Promo.Offers();
        promoFuctionCalled = false;
        promo();
        Log.logMaker(promo,totalAmount,DiscountedAmount,DisRate);
        Delay(1);
        Log.logger();
        System.out.println(dash);
        if(logFound == true) {
            System.out.print("Do You Want To Apply Your Promo Cupon Code From Your Earlier Purchases ? (Y/n) - ");
            menuSelect = sc.nextLine();
            System.out.println();
            if(menuSelect.toLowerCase().startsWith("y")){
                Promo.promoDiscount(LogPromo);
                System.out.println("Congratulations On Obtaining - " + promoPts + " POINTS");
                promoDiscount();
                System.out.println("Your New Discounted Bill Is - " + PromoDiscountedAmount);
                System.out.println(dash);
                Exit.Exit();
            }
            else if (menuSelect.toLowerCase().startsWith("n")){
                Exit.Exit();
                System.out.println(path);
            }
        }
        Exit.Exit();
    }
    public static void promo() {
        Random random = new Random();
        promo = "";
        String allchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String promointconversion = Integer.toString(totalAmount);
        int promolength = promointconversion.length();
        for (byte x = 0; x <= promolength; x++) {
            int randomGenerator = random.nextInt(72);
            char adder = allchar.charAt(randomGenerator);
            if (x < promolength) {
                promo += adder;
            }
        }
        System.out.println("Generating Promo Code!");

    }
    public static void promoDiscount() {
        byte pts = 100;
        PromoDiscountedAmount = (Double) (DiscountedAmount - (promoPts * pts));
    }
    public static void Discount() {
        if (totalAmount >= 1000000) {
            DiscountedAmount = (totalAmount - (totalAmount * (5.0 / 10.0)));
            DisRate = "50%";
        } else if (totalAmount >= 500000 && totalAmount <= 1000000) {
            DiscountedAmount = totalAmount - (totalAmount * (4.0 / 10.0));
            DisRate = "40%";
        } else if (totalAmount >= 250000 && totalAmount < 500000) {
            DiscountedAmount = totalAmount - (totalAmount * (3.0 / 10.0));
            DisRate = "30%";
        } else if (totalAmount >= 100000 && totalAmount < 250000) {
            DiscountedAmount = totalAmount - (totalAmount * (2.0 / 10.0));
            DisRate = "20%";
        } else if (totalAmount >= 50000 && totalAmount < 100000) {
            DiscountedAmount = totalAmount - (totalAmount * (1.0 / 10.0));
            DisRate = "10%";
        } else if (totalAmount >= 10000 && totalAmount < 50000) {
            DiscountedAmount = totalAmount - (totalAmount * (5.0 / 100.0));
            DisRate = "5%";
        } else if (totalAmount >= 0 && totalAmount < 10000) {
            DiscountedAmount = totalAmount - (totalAmount * (0.0 / 100.0));
            DisRate = "0%";
        }
    }
}
class Promo extends javazon{
    public static void promoDiscount(String logPromo) {
        if (logPromoFuctionCalled == false) {
            System.out.println("|||||" + dash + "|||||");
            for (byte i = 0; i < logPromo.length(); i++) {
                for (byte j = 0; j < 36; j++) {
                    if (logPromo.charAt(i) == allchar[j]) {
                        promoPts += discountCharsI[j];
                        System.out.println("Calculating Promo Pts (" + logPromo.charAt(i) + ")");
                        System.out.println("Points Obtained Till Now " + promoPts);
                        System.out.println("|||||" + dash + "|||||");
                        Delay(2);
                    }
                }
            }
            logPromoFuctionCalled = true;
        }
    }

    public static void Offers() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] highestDiscountI = new int[]{0,1,2,3,4,5,6,7,8,9};
        String[] highestDiscountS = new String[]{"|","|","|","|","|","|","|","|","|","|",};
        System.out.println(dash);
        if(offersDiscountChecker == false) {
            for (byte i = 0; i < 36; i++) {
                int randomGenerator = random.nextInt(10);
                discountCharsI[i] = randomGenerator;
            }
            offersDiscountChecker = true;
        }
        if( promoFuctionCalled == false){
            System.out.println("Points Given To The Given Characters");
            for (byte i = 0; i < 36; i++) {
                if (i % 6 == 0) {
                    System.out.println("");
                }
                System.out.print(allchar[i] + "---" + discountCharsI[i] + " Pts" + "\t");
            }
            System.out.println();
            System.out.println(dash);
            System.out.println("The Highest Value Characters Today Are - ");
            for (byte i = 0; i < 36; i++) {
                for (byte j = 0; j < 10; j++) {
                    if (discountCharsI[i] == highestDiscountI[j]) {
                        highestDiscountS[j] += allchar[i] + "---" + discountCharsI[i] + " Pts" + "\t";
                    }
                }
            }
            for (byte i = 7; i < 10; i++) {
                System.out.println(highestDiscountS[i]);
            }
            System.out.println("These are the points given to these characters for");
            System.out.print("(Press any key to continue)");
            sc.nextLine();
            showmenu();
        }
    }
}

class Menu extends javazon {
    public static void mainmenu() {
        String[] categories = {dash, "Time - " + date, dash, "Welcome to JAVAZON™ - An Online Shopping place", "1: Electronics", "2: Home appliances and furniture", "3: Entertainment","4: Food","5: Offers" ,"6: CREDITS","0: Go to cart?"};
        for (byte i = 0; i < categories.length; i++) {
            System.out.println(categories[i]);
        }
        System.out.print("Input - ");
    }

    public static void menuElectronics() {

        String[][] types = {{option, dash, categories, "1:Processors", "2:Graphics Cards", "3:Cables", "4:Peripherals", "0:Go Back",},
                {option, dash, "Select from the following brands", "1.Intel", "2.AMD", "0:Go Back"},
                {option, dash, "Select between the 2 brands:", "1.Nvidia", "2.AMD", "0:Go back"},
                {option, dash, "1:HDMI", "2:DP", "3:VGA", "4:DVI", "0:Go Back"},
                {option, dash, "1:Keyboard", "2:Mouse", "3:Headphones", "4:Monitors", "5:Microphone", "0:Go Back"}};

        String[][] subTypes = {{option, dash, hereoptions, "1:Core i3---INR 12000", "2:Core i5---INR 15000", "3:Core i7---INR 17000", "4:Core i9---INR 20000", "0: Go back"},
                {option, dash, hereoptions, "1:Ryzen 3---INR 8000", "2:Ryzen 5---INR 15000", "3:Ryzen 7---INR 27000", "4:Ryzen 9---INR 60000", "5:Ryzen Threadripper---200000", "0: Go back"},
                {option, dash, hereoptions, "1: GTX 1050---INR 10000", "2: GTX 1060---INR 15000", "3: GTX 1660---INR 25000", "4: GTX 1070---INR 30000", "5: GTX 1080---INR 50000", "6: RTX 2060---INR 30000", "7: RTX 2070---INR 40000", "8: RTX 2080---INR 80000", "9: RTX 3070---INR 60000", "10:RTX 3080---INR 80000", "11:RTX 3090---INR 100000", "0: Go back"},
                {option, dash, hereoptions, "1:Radeon 7000---INR 20000", "2:Radeon 8000---INR 30000", "3:Radeon 9000---INR 40000", "4:Radeon R300---INR 50000", "0: Go back"},
                {option, dash, hereoptions, "1:HDMI 1.0---INR 200", "2:HDMI 2.0---INR 300", "3:HDMI 2.1(Works with everything BOI!)---INR 400", "0: Go back"},
                {option, dash, hereoptions, "1:DP 1.0---INR 200", "2:DP 1.2---INR 300", "3:DP 3.0---INR 500","4:DP 4.0---INR 600", "0: Go back"},
                {option, dash, hereoptions, "1:VGA(you still sue VGA? How old are you?)---INR 300", "2: Nishtech Male to Male VGA Cable 1 Meter, Support PC/Monitor/LCD/LED, Plasma, Projector, TFT---INR 129", "3: PremiumAV HDMI Male to VGA Female Video Converter Adapter Cable (Black)---INR 377", "4: AmazonBasics HDMI Input to DVI Output (Not VGA) Adapter Cable, 3 Feet,Black---INR 329" , "0: Go back"},
                {option, dash, hereoptions, "1:DVI(Digital Visual Interface) cable---INR 200","2: DVI-D (24+1) Dual Link Male to Male Digital Video Cable 1.5 Meter (5 Feet) for PC, Laptop, Projector, HDTV, HD-Monitor, Graphics Card, Gaming Console.--- INR 295","3: BlueRigger Premium USB C 3.1 to DVI Adapter Cable (Thunderbolt 3 Compatible) for MacBook Pro 2017/18/19/20, MacBook Air/iPad Pro 2020, Surface Book 2, Samsung Galaxy S8/S9/S20, Note 10 and more (6 Feet / 1.8 Meters)---INR 1599","4: Gibbon HDMI Male to DVI-D Male Dual Link (24+1 Pin) Cable 1.5 Meter---INR 249", "0: Go back"},
                {option, dash, hereoptions, "1: DELL KB216 MULTIMEDIA KEYBOARD (580-AEKD, BLACK)---INR 579", "2: Zebronics K25 Standard Keyboard with USB Input---INR 299", "3: HP GK100 Wired USB Gaming Keyboard  (Black)---INR 2799", "4: HP 100 Wired USB Desktop Keyboard with Height Adjustment---INR 549", "0: Go back"},
                {option, dash, hereoptions, "1: HP X1000 Wired Mouse (Black/Grey)---INR 349", "2: Logitech M90 Wired USB Mouse, 1000 DPI Optical Tracking, Ambidextrous PC/Mac/Laptop - Black---INR 299", "3: LOGITECH M90 OPTICAL USB MOUSE (910-001795, BLACK)---INR 299", "4: Dell MS116 Optical Mouse---INR 363", "0: Go back"},
                {option, dash, hereoptions, "1: Logitech H111 Wired Headphone, Grey---INR 729", "2: Logitech H111 Wired Headphone, Grey---INR 24,959", "3: Audio-Technica - ATH-M20x---INR 4599", "4: Rockerz 550---INR 1999", "0: Go back"},
                {option, dash, hereoptions, "1: Samsung 59.8 cm (23.5 inch) Curved LED Backlit Computer Monitor - Full HD, VA Panel with VGA, HDMI, Audio Ports - LC24F390FHWXXL (Black)---INR 8999", "2: HP EliteDisplay 23.8-inch (60.45 cm) IPS Anti Glare Full HD Monitor with Pivot Rotation and VGA - E243 (Black)---INR 15676", "3: Dell SE Series SE2219HX 22 (55.88 cm) Full HD Monitor---INR 9000", "4: Sharp 61 cm (24 inch) HD LED TV, C24BC2IN---INR 7990", "0: Go back"},
                {option, dash, hereoptions, "1: Rode NT-USB USB Condenser Microphone, Black---INR 17999", "2: Maono AU-A04 Condenser Microphone Kit (Black)---INR 4619", "3: Rode NT-USB Mini Studio quality USB Microphone for podcasting, streaming, musician, gaming, voice over---INR 10999", "4: Raspberry Pi USB Plug and Play Desktop Microphone---INR 195", "0: Go back"}};
        if (menuChecker != -1) {
            for (byte i = 0; i < types[menuChecker].length; i++) {
                System.out.println(types[menuChecker][i]);
            }
        } else if (subMenuChecker != 0) {
            subMenuChecker -= 1;
            for (byte i = 0; i < subTypes[subMenuChecker].length; i++) {
                System.out.println(subTypes[subMenuChecker][i]);
            }
        }
        System.out.print("Input - ");
    }

    public static void menuHomeApp() {
        String[][] types = {{dash, "1:Washing Machines", "2:Microwave/Oven", "3:Tables", "4:Chairs", "0:Go Back"},
                {option, dash, "Select from the following Types", "1.Front Load", "2.Top Load", "0:Go Back."},
                {option, dash, "Select between the following categories", "1.Microwave", "2.Oven", "0:Go Back."},
                {option, dash, "Select from the following brands", "1:Urban", "2:Antique", "0:Go Back."},
                {option, dash, "Select from the following brands", "1:Urban", "2:Antique", "0:Go Back."}};

        String[][] subTypes = {{option, dash, hereoptions, "1:Godrej Eon 6--- INR 30000", "2:IFB Senorita Aqua SX--- INR 40000", "0:Go Back."},
                {option, dash, hereoptions, "1:Samsung WA62M4100HY 6.2Kg---INR 15000", "2:Panasonic F62B5HRB 6.2Kg---INR 20000", "0:Go Back."},
                {option, dash, hereoptions, "1: Emerson MWG9115SB---INR 10000", "2: Whirlpool 24 L Convection Microwave---INR 15000", "0:Go Back."},
                {option, dash, hereoptions, "1: Panasonic 23L Convection Oven---INR 9000", "2: Samsung 28L Convection Oven---INR 11000", "0:Go Back."},
                {option, dash, hereoptions, "1:Urban Table With Polished Wood--- INR 10000", "2: Stained glass table--- INR 15000", "0:Go Back."},
                {option, dash, hereoptions, "1:Jodhpur Table---INR 15000", "2:Tea table(Colonial age)---INR 20000", "0:Go Back."},
                {option, dash, hereoptions, "1:Synthetic Chair--- INR 10000", "2:Wooden Chair--- INR 15000", "0:Go Back."},
                {option, dash, hereoptions, "1:Bamboo Chair--- INR 15000", "2:Teak polished Chair --- INR 20000", "0:Go Back."}};
        if (menuChecker != -1) {
            for (byte i = 0; i < types[menuChecker].length; i++) {
                System.out.println(types[menuChecker][i]);
            }
        } else if (subMenuChecker != 0) {
            subMenuChecker -= 1;
            for (byte i = 0; i < subTypes[subMenuChecker].length; i++) {
                System.out.println(subTypes[subMenuChecker][i]);
            }
        }
        System.out.print("Input - ");
    }
    public static void menuFood() {

        String[][] types = {{option, dash, categories, "1:Frozen", "2:Fresh", "3:Essential", "0:Go Back",},
                {option, dash, "Select from the following Options:", "1.Non-Veg", "2.Veg", "0:Go Back"},
                {option, dash, "Select between the 2 Options:", "1.Vegitables/Fruits", "2.Snacks", "0:Go Back"},
                {option, dash, "1:Flour", "2:Rice", "3:Spices", "0:Go Back"},};


        String[][] subTypes = {{option, dash, hereoptions, "1:Whole Chicken---INR 200", "2:Chicken Brest---INR 50", "3:Chicken Drumsticks---INR 60", "4:Mutton Chops---INR 70","5:Mutton Ribs---INR 40","6: Whole Turkey---INR 300", "0: Go back"},
                {option, dash, hereoptions, "1: French Fries---INR 40", "2: Potato Patties---INR 120", "3:Milk---INR 10", "4:Paneer---INR 50",},
                {option, dash, hereoptions, "1: Tomato---INR 30", "2: Carrots---INR 20", "3: Apples---INR 40", "4: Banana---INR 20", "5: PineApple---INR 50", "6: Capsicum---INR 40", "7: Lady Finger---INR 50", "8: BEAN---INR 100","0: Go back"},
                {option, dash, hereoptions, "1: Potato Chips---INR 40", "2: Apple jacks---INR 50", "3: Banana Chips---INR 40", "4: Chivda---INR 50","0: Go back"},
                {option, dash, hereoptions, "1: Whole Wheat---INR 40", "2: Maida---INR 50", "3: Rice Flour---INR 40","0: Go back"},
                {option, dash, hereoptions, "1: Sticky Rice---INR 50", "2: Non-Sticky ---INR 40", "3: Biryani Rice---INR 70","0: Go back"},
                {option, dash, hereoptions, "1: Garam Masala---INR 30", "2: Tumric---INR 40", "3: Ginger Garlic Paste---INR 20","0: Go back"}};
        if (menuChecker != -1) {
            for (byte i = 0; i < types[menuChecker].length; i++) {
                System.out.println(types[menuChecker][i]);
            }
        } else if (subMenuChecker != 0) {
            subMenuChecker -= 1;
            for (byte i = 0; i < subTypes[subMenuChecker].length; i++) {
                System.out.println(subTypes[subMenuChecker][i]);
            }
        }
        System.out.print("Input - ");
    }
    public static void menuEntertainment() {
        String[][] types = {{dash, "1: Movies", "2: Books", "3: Video Games","0:Go back!"},
                {option, dash, hereoptions, "1: Hollywood", "2: Bollywood","0:Go back!"},
                {option, dash, hereoptions, "1: Hindi", "2: English","0:Go back!"},//Booklanguage
                {option, dash, hereoptions, "1: Shooter", "2: Strategy", "3: Story- based", "4: Horror","0:Go back!"}};//Video game

        String[][] subTypes = {{option, dash, hereoptions, "1: Action", "2: Melancholic", "3: Comedy", "4: Horror","0:Go back!"},//Hollywoodoption
                {option, dash, hereoptions, "1: Action", "2: Romantic", "3: Comedy", "4: Horror","0:Go back!"},//Bollywoodoption
                {option, dash, hereoptions, "1: Fiction", "2: Non-fiction", "3: Fantasy", "4: Adventure","0:Go back!"},//Booksgenre
                {option, dash, hereoptions, "1: The Fast and the furious 7---INR 200", "2: Mission Impossible---.INR 200", "3: Avengers: Civil War---INR 500", "4: Inception---INR 400","0: Go back"},//Action movie hollywood
                {option, dash, hereoptions, "1: Titanic---INR 299", "2: Romeo+Juliet---INR 400", "3: Me before you---INR 199", "4: One Day---INR 380","0: Go back"},// Melancholic movie hollywood
                {option, dash, hereoptions, "1: Borat---INR 399", "2: Accepted---INR 299", "3: The other guys---INR 499", "4: Due Date---INR 200","0: Go back"},//Comedy movie hollywood
                {option, dash, hereoptions, "1: IT 2---INR 299", "2: The Conjuring 2---INR 400", "3: Annabelle Creation---INR 500", "4: The Insidious---INR 600","0: Go back"},//Horror movie hollywood
                {option, dash, hereoptions, "1: Singham---INR 500", "2: Baaghi 2---INR 199", "3: Dhoom 3 ---INR 200", "4: Singham returns ---INR 200","0: Go back"},//ActionBolly
                {option, dash, hereoptions, "1: Dil Bechara---INR 100", "2: Zero---INR 300", "3: Love aaj kal---INR 299", "4: Luka Chuppi---INR 299","0: Go back"},//RomanticBolly
                {option, dash, hereoptions, "1: Total Dhamaal---INR 200", "2: Houseful 4---INR 299", "3: Hera Pheri---INR 400", "4: 3 Idiots---INR 300","0: Go back"},//ComedyBolly
                {option, dash, hereoptions, "1: Alone---INR 199", "2: Bhoot---INR 400", "3: 1920 London---INR 500", "4: Pari---INR 300","0: Go back"},//HorrorBolly
                {option, dash, hereoptions, "1: Godann by Premchand---INR 100", "2: Dharmayoddha Kalki: Avatar of Vishnu- Book 1 (HINDI) by Kevin Missal---INR 150", "3: Gaban by Premchand---INR 200", "4: Chandrakanta by Devaki Nandan Khatri---INR 300","0: Go back"},//HindiBooksGenreFiction
                {option, dash, hereoptions, "1: Siddhartha (DELUXE EDITION) by Hermann Hesse---INR 285", "2: Sapiens Manav Jati ka Sankshipt Itihas by Yuval Noah Harari---INR 285 ", "3: Main Mann Hoon by Deep trivedi---INR 179", "4: Gora (Hindi) by Rabindranath Tagore---INR 189","0: Go back"},
                {option, dash, hereoptions, "1: Nirmala by Premchand---INR 300", "2: Kamayani by Jaishankar Prasad---INR 200", "3: Volga Se Ganga by Rahul Sankrityayan---INR 199", "4: Gunahon Ka Devta by Dharamvir Bharati---INR 200","0: Go back"},
                {option, dash, hereoptions, "1: Sita-Warrior of Mithila Amish Tripathi---INR 400", "2: Ek Aaghaaz by Nitish Ojha---INR 200", "3: Kashi Ka Assi by Kashinath Singh---INR 200", "4: Ibnebatuti by Divya Prakash Dubey ---INR 300","0: Go back"},//Hindibookadventure
                {option, dash, hereoptions, "1: 1984 by George Orwell---INR 300", "2: Pride and Prejudice by Jane Austen---INR 199", "3: The Great Gatsby by F. Scott Fitzgerald---INR 300", "4: The Catcher in the Rye by J. D. Salinger---INR 200","0: Go back"},//EnglishFiction
                {option, dash, hereoptions, "1: Silent Spring by Rachel Carson---INR 200", "2: In Cold Blood by Truman Capote---INR 300", "3: The Double Helix: A Personal Account of the Discovery of the Structure of DNA by James Watson---INR 300", "4: Goodbye to All That by Robert Graves---INR 200","0: Go back"},//English NON-Fiction
                {option, dash, hereoptions, "1: The Lord of the Rings by J. R. R. Tolkien---INR 500", "2: The Hobbit by J. R. R. Tolkien---INR 500", "3: A Game of Thrones by George R. R. Martin---INR 300", "4: Alice's Adventures in Wonderland by Lewis Carroll---INR 200","0: Go back"},
                {option, dash, hereoptions, "1: Treasure Island by Robert Louis Stevenson---INR 400", "2: Robinson Crusoe by Daniel Defoe---INR 500", "3: Journey to the centre of the earth by Jules Verne---INR 200", "4: Lord of the Flies by William Golding---INR 200","0: Go back"},
                {option, dash, hereoptions, "1: Counter-Strike Global Offensive---FREE", "2: Valorant---FREE", "3: Fortnite---FREE", "4: PUBG---INR 2000","0: Go back"},
                {option, dash, hereoptions, "1: League of Legends---FREE", "2: World of warships---FREE", "3: World of tanks---FREE", "4: BattleTech---INR 2891","0: Go back"},
                {option, dash, hereoptions, "1: The Last of us---INR 1499", "2: Undertale---INR 499", "3: GTA V---INR 5310", "4: Her Story---INR 700","0: Go back"},
                {option, dash, hereoptions, "1: Granny---FREE", "2: Five nights at freddy(FNAF)---FREE", "3: Carrion---INR 1400", "4: Amnesia : The Dark Descent---INR 1400","0: Go back"}};

        if (menuChecker != -1) {
            for (byte i = 0; i < types[menuChecker].length; i++) {
                System.out.println(types[menuChecker][i]);
            }
        } else if (subMenuChecker != 0) {
            for (byte i = 0; i < subTypes[subMenuChecker].length; i++) {
                System.out.println(subTypes[subMenuChecker][i]);
            }
        } else if (subMenuChecker == 0) {
            for (byte i = 0; i < subTypes[subMenuChecker].length; i++) {
                System.out.println(subTypes[subMenuChecker][i]);
            }
        }
        System.out.print("Input - ");
    }
}
class CREDITS extends javazon
{

    public static void showcredits() throws IOException {
        String Heyday = "Mihir Belose";
        String j0lly = "Dhruv Patil";
        String GIGA = "Nishad Nandi";
        String made = "made by ";
        String all = Heyday +", "+ j0lly + " and " + GIGA+".";
        Scanner sc = new Scanner(System.in);
        System.out.println("Javazon made by:");
        javazon.Delay(2);
        System.out.println("Mihir Belose");
        javazon.Delay(2);
        System.out.println("Dhruv Patil");
        javazon.Delay(2);
        System.out.println("Nishad Nandi");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Continue? \n Y/N");
        System.out.print("Input -");
        String continued = sc.nextLine();
        if(continued.equals("y")|| continued.equals("Y") )
        {
            System.out.println("Categories:\n \n \n");
            javazon.Delay(2);
            System.out.println("Electronics made by -  "+all+"\n \n \n");
            javazon.Delay(4);
            System.out.println("Home Appliances & furniture and food made by "+ j0lly+".\n \n \n");
            javazon.Delay(4);
            System.out.println("Entertainment - "+made+GIGA+".\n \n \n");
            javazon.Delay(4);
            System.out.println("Food  - " + j0lly + ".\n \n \n");
            javazon.Delay(4);
            System.out.println("Logic -  "+Heyday+".\n \n \n");
            javazon.Delay(4);
            System.out.println("Promo Code - "+Heyday+".\n \n \n");
            javazon.Delay(4);
            System.out.println("Log Files - "+Heyday+".\n \n \n");
            javazon.Delay(4);
            System.out.println("Menu edited and "+made+all+"\n \n \n");
            javazon.Delay(4);
            System.out.println("CREDITS "+made+GIGA+".\n \n \n");
            javazon.Delay(4);
            System.out.println("BillandDiscount "+made+j0lly+" "+Heyday+".\n \n \n");
            Delay(4);
            System.out.println("Discount system "+made+j0lly);
            Delay(4);
            System.out.println("Thank you so much for using our program!");
            Delay(3);
            showmenu();

        }
        else if(continued.equals("n")|| continued.equals("N"))
        {
            System.out.println("Thank you so much for using our program!");
            Delay(3);
            showmenu();
        }
        else
            System.out.println("Please choose a valid option!");
        Delay(2);
        showmenu();

    }
}

class Exit extends javazon{
    public static void Exit() throws IOException {
        Scanner Input = new Scanner(System.in);
        for(byte i = 0; i < 1;) {
            System.out.println("Do you want to leave, and proceed to checkout? (Y/n)");
            System.out.print("Input - ");
            String in = Input.nextLine();
            if (in.toLowerCase().startsWith("y")) {
                i++;
                System.out.println("Thank You For Shopping With Javazon, Here is Your Promo code For Your Future Purchases At Javazon - " + promo);
                System.exit(0);
            } else if (in.toLowerCase().startsWith("n")) {
                i++;
                showmenu();
            } else {
                System.err.println(error);
                System.out.println(dash);
            }
        }
    }
}
class Log extends javazon {
    public static void pathFinder() {
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        path = fw.getDefaultDirectory();
    }

    public static void logger() throws IOException {
        pathFinder();
        String log = "\\" + LogS + ".txt";
        File fileLog = new File(String.valueOf(path) + log);
        if (!fileLog.exists()) {
            fileLog.getParentFile().mkdirs(); // If File Does not Exist
            fileLog.createNewFile();
        }
        Scanner sc = new Scanner(fileLog);
        byte z = 0;
        System.out.println("Scanning For Pre Existing Log Files....");
        if (LogCalled == false) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                LogFileDatabase[z] = line;
                z++;
            }
            if (LogFileDatabase[1] != null) {
                LogPromo = LogFileDatabase[1].replaceAll("Promo Code - ", "");
            }
            System.out.println("Scanned!");
            Delay(2);
            if (z != 0) {
                System.out.println("Found Log Files :)");
                System.out.println("Promo Code Found : " + LogPromo);
                System.out.println(dash);
                logFound = true;
            } else {
                System.err.println("No Log Files Found :(");
            }
            LogCalled = true;
        }
        FileWriter fileWriter = new FileWriter(fileLog);
        fileWriter.write(LogW);
        fileWriter.write("\n");
        for (byte i = 0; i < c; i++) {
            fileWriter.write("\n");
            fileWriter.write(bill[i]);
        }
        fileWriter.close();
    }
    public static void logMaker (String promo,int tAmt, double dAmt, String dRate){
        LogW = dash + "\n" + "Promo Code - " + promo + "\n" + "Total Amount - " + tAmt + "\n" + "Discounted Amount - " + dAmt + "\n" + "Discounted Rate - " + dRate + "\n" + dash;
    }
}
