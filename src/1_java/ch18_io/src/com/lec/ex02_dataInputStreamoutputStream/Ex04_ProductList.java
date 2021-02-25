package com.lec.ex02_dataInputStreamoutputStream;

//입력한 데이터 값을 불러오는곳
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex04_ProductList {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		String name;
		int price, ps;
		ArrayList<Product> products = new ArrayList<Product>();

		try {

			fis = new FileInputStream("txtFile/product.dat");
			dis = new DataInputStream(fis);
			while (true) {
				name = dis.readUTF();
				price = dis.readInt();
				ps = dis.readInt();
				products.add(new Product(name, price, ps));
				
			}

		} catch (Exception e) {
			System.out.println("물건명 "+ "\t" + "가격"+ "\t" + "재고");

		} finally {
			try {
				if (dis != null)
					dis.close();
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
