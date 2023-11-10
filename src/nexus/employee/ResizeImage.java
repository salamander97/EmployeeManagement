package nexus.employee;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ResizeImage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập đường dẫn của tệp ảnh: ");
            String inputPath = scanner.nextLine();

            System.out.print("Nhập chiều rộng mới: ");
            int newWidth = scanner.nextInt();
            System.out.print("Nhập chiều cao mới: ");
            int newHeight = scanner.nextInt();

            BufferedImage originalImage = ImageIO.read(new File(inputPath));
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            System.out.print("Nhập đường dẫn để lưu ảnh đã resize: ");
            String outputPath = scanner.next();

            ImageIO.write(resizedImage, "jpg", new File(outputPath));
            System.out.println("Ảnh đã resize đã được lưu tại " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
