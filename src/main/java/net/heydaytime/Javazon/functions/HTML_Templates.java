package net.heydaytime.Javazon.functions;

import net.heydaytime.Javazon.models.InvoiceModel;
import net.heydaytime.Javazon.models.ItemModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HTML_Templates {

    public static String verificationCode(String verificationCode, String GeneratedAt) throws URISyntaxException, IOException {

        String fileString = readFile("VerificationCode.html");
        fileString = fileString.replaceAll("#VerificationCode", verificationCode);
        fileString = fileString.replaceAll("#GeneratedAt", GeneratedAt);

        return fileString;
    }


    public static String verificationCodeSuccess() throws URISyntaxException, IOException {
        return readFile("VerificationCodeSuccess.html");
    }

    public static String invoice(InvoiceModel invoice) throws URISyntaxException, IOException {
        String invoiceFileString = readFile("Invoice.html");
        String invoiceCartItemString = readFile("InvoiceCartItem.html");
        String invoiceCurrentCartItemString = "";

        String orderId = invoice.id();
        String ETA = invoice.ETA().getDayOfMonth() + "/" + invoice.ETA().getMonth() + "/" + invoice.ETA().getYear();
        double totalCost = 0;

        for(ItemModel item: invoice.cart()){
            totalCost += item.getPrice() * item.getQuantity();
            invoiceCurrentCartItemString += invoiceCartItemString.replaceAll("#ObjectId", item.getId());
            invoiceCurrentCartItemString = invoiceCurrentCartItemString.replaceAll("#ProductName", item.getProductName());
            invoiceCurrentCartItemString = invoiceCurrentCartItemString.replaceAll("#Price", item.getPrice().toString());
            invoiceCurrentCartItemString = invoiceCurrentCartItemString.replaceAll("#Quantity", item.getQuantity().toString());
        }


        invoiceCartItemString = invoiceCurrentCartItemString;

        invoiceFileString = invoiceFileString.replaceAll("#OrderId", orderId);
        invoiceFileString = invoiceFileString.replaceAll("#CartList", invoiceCartItemString);
        invoiceFileString = invoiceFileString.replaceAll("#TotalAmount", String.valueOf(Math.round(totalCost)));
        invoiceFileString = invoiceFileString.replaceAll("#ETA", ETA);

        return invoiceFileString;
    }

    public static String readFile(String fileName) throws URISyntaxException, IOException {
        InputStream stream = HTML_Templates.class.getResourceAsStream("/templates/" + fileName);
        assert stream != null;

        String out = "";

        Scanner sc = new Scanner(stream);
        while (sc.hasNextLine()) out += sc.nextLine();

        return out;
    }
}