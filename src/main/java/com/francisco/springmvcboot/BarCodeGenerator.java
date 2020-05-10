package com.francisco.springmvcboot;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.stereotype.Component;

@Component
public class BarCodeGenerator {

	public static String generate(String barcodeText) {
		barcodeText = StringUtils.leftPad(barcodeText, 12, '0');
		EAN13Bean barcodeGenerator = new EAN13Bean();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

		barcodeGenerator.generateBarcode(canvas, barcodeText);

		System.out.println(barcodeText);
		String imageAsBase64 = "";
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(canvas.getBufferedImage(), "png", output);
			imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageAsBase64;
	}
}
