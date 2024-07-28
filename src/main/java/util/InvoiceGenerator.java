package util;

import model.Order;
import model.CartItem;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InvoiceGenerator {
    public static void generateInvoice(Order order, List<CartItem> cartItems, String outputPath) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Tiêu đề
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
        contentStream.beginText();
        contentStream.newLineAtOffset(20, 750);
        contentStream.showText("Hóa đơn mua hàng");
        contentStream.endText();

        // Thông tin khách hàng
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(20, 720);
        contentStream.showText("Họ và tên: " + order.getFullName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(20, 700);
        contentStream.showText("Số điện thoại: " + order.getPhone());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(20, 680);
        contentStream.showText("Địa chỉ: " + order.getAddress());
        contentStream.endText();

        // Thông tin sản phẩm
        float yPosition = 640;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(20, yPosition);
        contentStream.showText("Sản phẩm");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(220, yPosition);
        contentStream.showText("Số lượng");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(320, yPosition);
        contentStream.showText("Giá");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(420, yPosition);
        contentStream.showText("Tổng");
        contentStream.endText();

        contentStream.setFont(PDType1Font.HELVETICA, 12);
        for (CartItem item : cartItems) {
            yPosition -= 20;
            contentStream.beginText();
            contentStream.newLineAtOffset(20, yPosition);
            contentStream.showText(item.getProduct().getProductName());
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(220, yPosition);
            contentStream.showText(String.valueOf(item.getQuantity()));
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(320, yPosition);
            contentStream.showText(item.getProduct().getPrice().toString());
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(420, yPosition);
            contentStream.showText(item.getTotalPrice().toString());
            contentStream.endText();
        }

        // Tổng cộng
        yPosition -= 40;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(20, yPosition);
        contentStream.showText("Tổng cộng: " + order.getTotalAmount());
        contentStream.endText();

        contentStream.close();

        // Lưu PDF
        File outputFile = new File(outputPath, "Invoice_" + order.getOrderID() + ".pdf");
        document.save(outputFile);
        document.close();
    }
}
